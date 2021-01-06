package info.budget.budgettracker;

import java.io.IOException;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class BudgetTrackerModifyController extends HttpServlet {
	
	private InitialContext ic;  

    public void init() throws ServletException {
    	// �����R���e�L�X�g���擾
    	try {
			ic = new InitialContext();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

		// �����R�[�h�̐ݒ�
		request.setCharacterEncoding("Windows-31J");

		// mode�̎擾
		String mode = request.getParameter("mode");
		String delAddJan2020 = "delAddJan2020";
		PreparedStatement pstm = null;

		// ���s�X�e�[�^�X�̐錾
		String status = "Successful!";
		
		// �f�[�^�\�[�X�̎擾
		DataSource ds = null;
		try {
			ds = (DataSource) ic.lookup("java:comp/env/jdbc/searchman");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//�R�R�J��
		
		if (mode.equals(delAddJan2020)) {
			// JavaBeans�̏�����
			BudgetTrackerDeleteLogic btDeleteLogic = BudgetTrackerDeleteLogicFactory.createBudgetTrackerDeleteLogic(request, ds, mode);
			BudgetTrackerLogic btLogic = BudgetTrackerLogicFactory.createBudgetTrackerLogic(request, ds, mode);
			
			
			try {
				pstm.executeUpdate();
				btDeleteLogic.deleteData();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    try {
				btLogic.addData();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			try {
//				btDeleteLogic.deleteData();
//			    btLogic.addData();
//			} catch (Exception e) {
//			    e.printStackTrace();
//			        status = "Failed!";
//			}

			// status���Z�b�g���āAresult.jsp�ɓ]��
	        request.setAttribute("status", status);
	        request.getRequestDispatcher("/result.jsp").forward(request, response);
		} 

		// JavaBeans�̏�����
		BudgetTrackerLogic btLogic = BudgetTrackerLogicFactory.createBudgetTrackerLogic(request, ds, mode);
		
		try {
		    btLogic.addData();
		} catch (Exception e) {
		    e.printStackTrace();
		        status = "Failed!";
		}

		// status���Z�b�g���āAresult.jsp�ɓ]��
        request.setAttribute("status", status);
        request.getRequestDispatcher("/result.jsp").forward(request, response);
        
        //�R�R�}�f

	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

}