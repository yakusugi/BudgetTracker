package info.budget.budgettracker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

public abstract class BudgetTrackerLogic {
	// private String yearMonth;
	private String id;
	private String date;
	private String storeName;
	private String productName;
	private String type;
	private String price;

	// DB関連の初期設定
	protected DataSource ds = null;

	// コンストラクタ
	public BudgetTrackerLogic(HttpServletRequest request, DataSource  ds) {

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
	public boolean addData() throws Exception {

		Connection conn = ds.getConnection();
		String tableNm = getTableName();

		// sql文を表示
		String sql = "insert into " + tableNm + "(id, Date, StoreName, ProductName, type, Price) values (?, ?, ?, ?, ?, ?);";
		System.out.println(sql);

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, this.getId());
		pstmt.setString(2, this.getDate());
		pstmt.setString(3, this.getStoreName());
		pstmt.setString(4, this.getProductName());
		pstmt.setString(5, this.getType());
		pstmt.setString(6, this.getPrice());
		
		// sql文実行
		boolean res = pstmt.execute();

		// 使用したオブジェクトを終了させる
		pstmt.close();
		// conn.close(); Webサーバー側のコネクションを使っているためコネクションはクローズしない

		return res;
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