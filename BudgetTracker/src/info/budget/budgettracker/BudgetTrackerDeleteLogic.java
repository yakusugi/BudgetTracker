package info.budget.budgettracker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

public abstract class BudgetTrackerDeleteLogic {
	// private String yearMonth;
	private String id;

	// DB関連の初期設定
	protected DataSource ds = null;

	// コンストラクタ
	public BudgetTrackerDeleteLogic(HttpServletRequest request, DataSource  ds) {

        setId(request.getParameter("id"));
        this.ds = ds;
    }

	// データベースへのアクション
	// データの追加を実施
	public boolean deleteData() throws Exception {

		Connection conn = ds.getConnection();
		String tableNm = getTableName();

		// sql文
		String sql = "delete from " + tableNm +  " where id = ?;";

		System.out.println(sql);

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, this.getId());

		
		// sql文実行
//		boolean res = pstmt.execute();
		int n = pstmt.executeUpdate();
//		System.out.println("delete num " + n);
		boolean res = (n > 0);

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

}