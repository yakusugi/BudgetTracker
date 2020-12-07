package info.budget.budgettracker;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BudgetTrackerController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// �����R�[�h�̐ݒ�
		request.setCharacterEncoding("Windows-31J");

		// mode�̎擾
		String mode = request.getParameter("mode");

		// ���s�X�e�[�^�X�̐錾
		String status = "Successed!";

		// JavaBeans�̏�����
		//BudgetBeans�֒l�𗬂�
		

		switch (mode) {

		case "addJan2020": // �o�^
			BudgetTrackerLogic btLogicJan2020 = new Jan2020(request);
			if (btLogicJan2020.addData() == false) {
				status = "Failed!";
			}
			break;
			
//		case "delete": // �폜
//			if (budgetInfo.deleteData() == false) {
//				status = "Failed!";
//			}
//			break;
//			
//		case "change": // �ύX
//			request.setAttribute("budgetInfo", budgetInfo);
//			request.getRequestDispatcher("/change.jsp").forward(request, response);
//			return;
//
//		case "del_add": // �ύX�m��
//			if (!(budgetInfo.deleteData() && budgetInfo.addData())) {
//				status = "Failed";
//			}
//			break;

		}

		// status���Z�b�g���āAresult.jsp�ɓ]��
		request.setAttribute("status", status);
		request.getRequestDispatcher("/result.jsp").forward(request, response);

	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

}
