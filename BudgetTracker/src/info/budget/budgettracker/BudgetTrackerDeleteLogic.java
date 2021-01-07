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

	// DB�֘A�̏����ݒ�
	protected DataSource ds = null;

	// �R���X�g���N�^
	public BudgetTrackerDeleteLogic(HttpServletRequest request, DataSource  ds) {

        setId(request.getParameter("id"));
        this.ds = ds;
    }

	// �f�[�^�x�[�X�ւ̃A�N�V����
	// �f�[�^�̒ǉ������{
	public boolean deleteData() throws Exception {

		Connection conn = ds.getConnection();
		String tableNm = getTableName();

		// sql��
		String sql = "delete from " + tableNm +  " where id = ?;";

		System.out.println(sql);

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, this.getId());

		
		// sql�����s
//		boolean res = pstmt.execute();
		int n = pstmt.executeUpdate();
//		System.out.println("delete num " + n);
		boolean res = (n > 0);

		// �g�p�����I�u�W�F�N�g���I��������
		pstmt.close();
		// conn.close(); Web�T�[�o�[���̃R�l�N�V�������g���Ă��邽�߃R�l�N�V�����̓N���[�Y���Ȃ�

		return res;
	}

	// �T�u�N���X����e�[�u������Ԃ�
	protected abstract String getTableName();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}