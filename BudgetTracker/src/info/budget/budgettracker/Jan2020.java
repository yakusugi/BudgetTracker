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
	

	// ����������
//	public void init() throws ServletException {
//		try {
//			// �����R���e�L�X�g���擾
//			InitialContext ic = new InitialContext();
//			// ���b�N�A�b�v���ăf�[�^�\�[�X���擾
//			ds = (DataSource) ic.lookup("java:comp/env/jdbc/searchman");
//		} catch (Exception e) {
//
//		}
//	}
	
	// �f�[�^�x�[�X�ւ̃A�N�V����
		protected void doDataBase(String sql) throws Exception {

			// �R���e�L�X�g���擾
			InitialContext ic = new InitialContext();
			// ���b�N�A�b�v���ăf�[�^�\�[�X���擾
			ds = (DataSource) ic.lookup("java:comp/env/jdbc/searchman");
			conn = ds.getConnection();

			// sql����\��
			System.out.println(sql);
			pstmt = conn.prepareStatement(sql);
			// sql�����s
			pstmt.execute();

			// �g�p�����I�u�W�F�N�g���I��������
			pstmt.close();
			conn.close();
		}
	
	

	public Boolean addData() {
		try {
			
			
			String sql = null;
			
			// sql�� �̍쐬
			sql = "insert into Jan2020(id, Date, StoreName, ProductName, type, Price) values (?, ?, ?, ?, ?, ?);";
			
			pstmt.setString(1, this.getId());
			pstmt.setString(2, this.getDate());
			pstmt.setString(3, this.getStoreName());
			pstmt.setString(4, this.getProductName());
			pstmt.setString(5, this.getType());
			pstmt.setString(6, this.getPrice());
	
			// �f�[�^�x�[�X�ڑ����������̎��s
			doDataBase(sql);
			
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
	}

	

}
