package info.budget.budgettracker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

public abstract class BudgetTrackerSearchLogic {
	// private String yearMonth;
	private String id;
	private String date;
	private String storeName;
	private String productName;
	private String type;
	private String price;

	// DB関連の初期設定
	protected DataSource ds = null;
	// ResultSet rset = null;

	// コンストラクタ
	public BudgetTrackerSearchLogic(HttpServletRequest request, DataSource ds) {

		setId(request.getParameter("id"));
		setDate(request.getParameter("date"));
		setStoreName(request.getParameter("storeName"));
		setProductName(request.getParameter("productName"));
		setType(request.getParameter("type"));
		setPrice(request.getParameter("price"));
		this.ds = ds;
	}

	// データベースへのアクション
	// データの追加を実施
	public List<BudgetTrackerSearchDto> searchDataJan2020() throws SQLException {

		List<BudgetTrackerSearchDto> btsList = new ArrayList<>();

		Connection conn = ds.getConnection();
		String tableNm = getTableName();
		StringBuilder sql = new StringBuilder();

		// sql文を表示
		sql.append(
				"select id, Date, StoreName, ProductName, type, Price from " + tableNm + " where StoreName like '%'");
		// sql.append(storeName + "%'");
		System.out.println(sql);

		// if id is selected, add it
		if (id != "") {
			sql.append("and id ='" + this.getId() + "';");
		}

		// if Date is selected, add it
		if (date != "") {
			sql.append("and Date ='" + date + "'");
		}

		// if StoreName is selected, add it
		if (storeName != "") {
			sql.append("and StoreName ='" + storeName + "'");
		}

		// if ProductName is selected, add it
		if (productName != "") {
			sql.append("and ProductName ='" + productName + "'");
		}

		// if Type is selected, add it
		if (type != "") {
			sql.append("and Type ='" + type + "'");
		}

		// if Price is selected, add it
		if (type != "") {
			sql.append("and Price ='" + price + "'");
		}

		PreparedStatement pstmt = conn.prepareStatement(new String(sql));

		// sql文実行
		// boolean res = pstmt.execute();
		try (ResultSet rset = pstmt.executeQuery()) {
			while (rset.next()) {
				// dtoをインスタンス化
				BudgetTrackerSearchDto btsdto = new BudgetTrackerSearchDto();
				btsdto.setId(rset.getString(1));
				btsdto.setDate(rset.getString(2));
				btsdto.setStoreName(rset.getString(3));
				btsdto.setProductName(rset.getString(4));
				btsdto.setType(rset.getString(5));
				btsdto.setPrice(rset.getString(6));

				btsList.add(btsdto);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return btsList;
	}

	public List<BudgetTrackerSearchDto> searchStoreNameDescJan2020() throws SQLException {

		List<BudgetTrackerSearchDto> btsList = new ArrayList<>();

		Connection conn = ds.getConnection();
		String tableNm = getTableName();
		StringBuilder sql = new StringBuilder();

		// sql文を表示
		sql.append("select StoreName,sum(price) from " + tableNm + " group by StoreName order by sum(price) desc");
		// sql.append(storeName + "%'");
		System.out.println(sql);

		PreparedStatement pstmt = conn.prepareStatement(new String(sql));

		// sql文実行
		// boolean res = pstmt.execute();
		try (ResultSet rset = pstmt.executeQuery()) {
			while (rset.next()) {
				// dtoをインスタンス化
				BudgetTrackerSearchDto btsdto = new BudgetTrackerSearchDto();
				// btsdto.setId(rset.getString(1));
				// btsdto.setDate(rset.getString(2));
				btsdto.setStoreName(rset.getString(1));
				// btsdto.setProductName(rset.getString(4));
				// btsdto.setType(rset.getString(5));
				btsdto.setPrice(rset.getString(2));

				btsList.add(btsdto);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return btsList;
		// return new BudgetTrackerSearchLogic(btsList, tableNm);
		// return new List<BudgetTrackerSearchDto>[] {btsList, tableNm};
	}

	public List<BudgetTrackerSearchDto> searchByTotalSumOfJan2020() throws SQLException {

		List<BudgetTrackerSearchDto> btsList = new ArrayList<>();

		Connection conn = ds.getConnection();
		String tableNm = getTableName();
		StringBuilder sql = new StringBuilder();

		// sql文を表示
		sql.append("select sum(price) Jan2020_Sum from " + tableNm);
		// sql.append(storeName + "%'");
		System.out.println(sql);

		PreparedStatement pstmt = conn.prepareStatement(new String(sql));

		// sql文実行
		// boolean res = pstmt.execute();
		try (ResultSet rset = pstmt.executeQuery()) {
			while (rset.next()) {
				// dtoをインスタンス化
				BudgetTrackerSearchDto btsdto = new BudgetTrackerSearchDto();
				// btsdto.setId(rset.getString(1));
				// btsdto.setDate(rset.getString(2));
				// btsdto.setStoreName(rset.getString(1));
				// btsdto.setProductName(rset.getString(4));
				// btsdto.setType(rset.getString(1));
				btsdto.setPrice(rset.getString(1));

				btsList.add(btsdto);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return btsList;
	}
	
	public List<BudgetTrackerSearchDto> searchByTypeDescJan2020() throws SQLException {

		List<BudgetTrackerSearchDto> btsList = new ArrayList<>();

		Connection conn = ds.getConnection();
		String tableNm = getTableName();
		StringBuilder sql = new StringBuilder();

		// sql文を表示
		sql.append("select type, sum(price) from " + tableNm + " group by type order by sum(price) desc");
		// sql.append(storeName + "%'");
		System.out.println(sql);

		PreparedStatement pstmt = conn.prepareStatement(new String(sql));

		// sql文実行
		// boolean res = pstmt.execute();
		try (ResultSet rset = pstmt.executeQuery()) {
			while (rset.next()) {
				// dtoをインスタンス化
				BudgetTrackerSearchDto btsdto = new BudgetTrackerSearchDto();
				// btsdto.setId(rset.getString(1));
				// btsdto.setDate(rset.getString(2));
				// btsdto.setStoreName(rset.getString(1));
				// btsdto.setProductName(rset.getString(4));
				btsdto.setType(rset.getString(1));
				btsdto.setPrice(rset.getString(2));

				btsList.add(btsdto);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return btsList;
	}

	public List<BudgetTrackerSearchDto> likeSearchByProductNameJan2020() throws SQLException {

		List<BudgetTrackerSearchDto> btsList = new ArrayList<>();

		Connection conn = ds.getConnection();
		String tableNm = getTableName();
		StringBuilder sql = new StringBuilder();

		// sql文を表示
		sql.append(
				"select id, Date, StoreName, ProductName, type, Price from " + tableNm + " where ProductName LIKE '%" + productName +  "%'");
		// sql.append(storeName + "%'");
		System.out.println(sql);

		// if id is selected, add it

		PreparedStatement pstmt = conn.prepareStatement(new String(sql));

		// sql文実行
		// boolean res = pstmt.execute();
		try (ResultSet rset = pstmt.executeQuery()) {
			while (rset.next()) {
				// dtoをインスタンス化
				BudgetTrackerSearchDto btsdto = new BudgetTrackerSearchDto();
				btsdto.setId(rset.getString(1));
				btsdto.setDate(rset.getString(2));
				btsdto.setStoreName(rset.getString(3));
				btsdto.setProductName(rset.getString(4));
				btsdto.setType(rset.getString(5));
				btsdto.setPrice(rset.getString(6));

				btsList.add(btsdto);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return btsList;
	}

	// サブクラスからテーブル名を返す
	protected abstract String getTableName();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public DataSource getDs() {
		return ds;
	}

	public void setDs(DataSource ds) {
		this.ds = ds;
	}
}