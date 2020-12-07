package info.budget.budgettracker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

public class Jan2020 extends BudgetTrackerLogic {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private DataSource ds = null;
	
	public Jan2020(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}
	

	// 初期化処理
//	public void init() throws ServletException {
//		try {
//			// 初期コンテキストを取得
//			InitialContext ic = new InitialContext();
//			// ルックアップしてデータソースを取得
//			ds = (DataSource) ic.lookup("java:comp/env/jdbc/searchman");
//		} catch (Exception e) {
//
//		}
//	}
	
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
	
	

	public Boolean addData() {
		try {
			
			
			String sql = null;
			
			// sql文 の作成
			sql = "insert into Jan2020(id, Date, StoreName, ProductName, type, Price) values (?, ?, ?, ?, ?, ?);";
			
			pstmt.setString(1, this.getId());
			pstmt.setString(2, this.getDate());
			pstmt.setString(3, this.getStoreName());
			pstmt.setString(4, this.getProductName());
			pstmt.setString(5, this.getType());
			pstmt.setString(6, this.getPrice());
	
			// データベース接続＆ｓｑｌの実行
			doDataBase(sql);
			
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
	}

	

}
