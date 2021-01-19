package info.budget.budgettracker;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class BudgetTrackerSearchController extends HttpServlet {

	private InitialContext ic;
	boolean bool = true;

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
//		String mode = request.getParameter("mode");
//		String searchJan2020 = "searchJan2020";
//		String searchByStoreNameDescJan2020 = "searchByStoreNameDescJan2020";
//		String searchByTypeDescJan2020 = "searchByTypeDescJan2020";
//		String modifyJan2020 = "modifyJan2020";
//		String delAddJan2020 = "delAddJan2020";
//		String likeSearchByProductNameJan2020 = "likeSearchByProductNameJan2020";
//		String searchByTotalSumOfJan2020 = "searchByTotalSumOfJan2020";
		String year = request.getParameter("year");
		String month = request.getParameter("month");
			
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
		
		
			// JavaBeans�̏�����
			BudgetTrackerSearchLogic btSearchLogic = BudgetTrackerSearchLogicFactory.createBudgetTrackerLogic(request,
					ds, year, month);

			List<BudgetTrackerSearchDto> rset = null;
			try {
				rset = btSearchLogic.searchDataJan2020();
			} catch (Exception e) {
				e.printStackTrace();
				status = "Failed!";
			}

			// status���Z�b�g���āAresult.jsp�ɓ]��
			request.setAttribute("status", status);
			request.setAttribute("SqlResult", rset);
			request.getRequestDispatcher("/searchResult.jsp").forward(request, response);
	}
//		if (mode.equals(searchByStoreNameDescJan2020)) {
//			BudgetTrackerSearchLogic btSearchLogic = BudgetTrackerSearchLogicFactory.createBudgetTrackerLogic(request,
//					ds, mode);
//
//			List<BudgetTrackerSearchDto> rset = null;
//			try {
//				rset = btSearchLogic.searchStoreNameDescJan2020();
//			} catch (Exception e) {
//				e.printStackTrace();
//				status = "Failed!";
//			}
//
//			// status���Z�b�g���āAresult.jsp�ɓ]��
//			request.setAttribute("status", status);
//			request.setAttribute("SqlResult", rset);
//			request.getRequestDispatcher("/searchResultByStoreNameDesc.jsp").forward(request, response);
//		} else if (mode.equals(searchByTypeDescJan2020)) {
//			BudgetTrackerSearchLogic btSearchLogic = BudgetTrackerSearchLogicFactory.createBudgetTrackerLogic(request,
//					ds, mode);
//
//			List<BudgetTrackerSearchDto> rset = null;
//			try {
//				rset = btSearchLogic.searchByTypeDescJan2020();
//			} catch (Exception e) {
//				e.printStackTrace();
//				status = "Failed!";
//			}
//
//			// status���Z�b�g���āAresult.jsp�ɓ]��
//			request.setAttribute("status", status);
//			request.setAttribute("SqlResult", rset);
//			request.getRequestDispatcher("/searchResultByType.jsp").forward(request, response);
//		} else if (mode.equals(modifyJan2020)){
//			BudgetTrackerSearchLogic btSearchLogic = BudgetTrackerSearchLogicFactory.createBudgetTrackerLogic(request,
//					ds, mode);
//			request.setAttribute("btSearchLogic", btSearchLogic);
//			request.getRequestDispatcher("/searchResultModifyJan2020.jsp").forward(request, response);
//			return;
//			
//		} else if (mode.equals(delAddJan2020)){
//			BudgetTrackerAddLogic btLogic = BudgetTrackerAddLogicFactory.createBudgetTrackerLogic(request, ds, mode);
//			BudgetTrackerDeleteLogic btDeleteLogic = BudgetTrackerDeleteLogicFactory.createBudgetTrackerDeleteLogic(request, ds, mode);
//			
//			try {
//				if ((btDeleteLogic.deleteData())) {
//					if ((btLogic.addData())) {
//						bool = true;
//					} else {
//						bool = false;
//					}
//
//				}
//				request.setAttribute("bool", bool);
//		        request.getRequestDispatcher("/modifyResult.jsp").forward(request, response);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} else if (mode.equals(likeSearchByProductNameJan2020)){
//			BudgetTrackerSearchLogic btSearchLogic = BudgetTrackerSearchLogicFactory.createBudgetTrackerLogic(request,
//					ds, mode);
//
//			List<BudgetTrackerSearchDto> rset = null;
//			try {
//				rset = btSearchLogic.likeSearchByProductNameJan2020();
//			} catch (Exception e) {
//				e.printStackTrace();
//				status = "Failed!";
//			}
//
//			// status���Z�b�g���āAresult.jsp�ɓ]��
//			request.setAttribute("status", status);
//			request.setAttribute("SqlResult", rset);
//			request.getRequestDispatcher("/searchResultJan2020.jsp").forward(request, response);
//		} else if (mode.equals(searchByTotalSumOfJan2020)) {
//			BudgetTrackerSearchLogic btSearchLogic = BudgetTrackerSearchLogicFactory.createBudgetTrackerLogic(request,
//					ds, mode);
//
//			List<BudgetTrackerSearchDto> rset = null;
//			try {
//				rset = btSearchLogic.searchByTotalSumOfJan2020();
//			} catch (Exception e) {
//				e.printStackTrace();
//				status = "Failed!";
//			}
//
//			// status���Z�b�g���āAresult.jsp�ɓ]��
//			request.setAttribute("status", status);
//			request.setAttribute("SqlResult", rset);
//			request.getRequestDispatcher("/searchByTotalSumOfJan2020.jsp").forward(request, response);
//		} else {
//			System.out.println("do nothing");
//		}
//
//	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}
}