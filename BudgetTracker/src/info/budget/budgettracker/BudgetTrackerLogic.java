package info.budget.budgettracker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

public class BudgetTrackerLogic {
	// private String yearMonth;
	private String id;
	private String date;
	private String storeName;
	private String productName;
	private String type;
	private String price;

	// DB関連の初期設定
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	protected DataSource ds = null;
	private ResultSet rset = null;

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
   //省略

	// // データベースへのアクション
	// private void doDataBase(String sql) throws Exception {
	//
	// // コンテキストを取得
	// InitialContext ic = new InitialContext();
	// // ルックアップしてデータソースを取得
	// ds = (DataSource) ic.lookup("java:comp/env/jdbc/searchman");
	// conn = ds.getConnection();
	//
	// // sql文を表示
	// System.out.println(sql);
	// pstmt = conn.prepareStatement(sql);
	// // sql文実行
	// pstmt.execute();
	//
	// // 使用したオブジェクトを終了させる
	// pstmt.close();
	// conn.close();
	// }

	// データベースへのアクション
	protected void doDataBase(String sql) throws Exception {

		// コンテキストを取得
		InitialContext ic = new InitialContext();
		// ルックアップしてデータソースを取得
		ds = (DataSource) ic.lookup("java:comp/env/jdbc/searchman");
		conn = ds.getConnection();

		// sql文を表示
		System.out.println(sql);
		pstmt = conn.prepareStatement(sql);
		// sql文実行
		pstmt.execute();

		// 使用したオブジェクトを終了させる
		pstmt.close();
		conn.close();
	}

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

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public PreparedStatement getPstmt() {
		return pstmt;
	}

	public void setPstmt(PreparedStatement pstmt) {
		this.pstmt = pstmt;
	}

	public DataSource getDs() {
		return ds;
	}

	public void setDs(DataSource ds) {
		this.ds = ds;
	}

	public Boolean addData() {
		return true;
	}

}
