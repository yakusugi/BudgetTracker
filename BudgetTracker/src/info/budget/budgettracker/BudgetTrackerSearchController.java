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

	public void init() throws ServletException {
		// 初期コンテキストを取得
		try {
			ic = new InitialContext();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 文字コードの設定
		request.setCharacterEncoding("Windows-31J");

		// modeの取得
		String mode = request.getParameter("mode");
		String searchJan2020 = "searchJan2020";
		String searchByStoreNameDescJan2020 = "searchByStoreNameDescJan2020";
		String searchByTypeDescJan2020 = "searchByTypeDescJan2020";
		String modifyJan2020 = "modifyJan2020";
		String delAddJan2020 = "delAddJan2020";
				
		// 実行ステータスの宣言
		String status = "Successful!";

		// データソースの取得
		DataSource ds = null;
		try {
			ds = (DataSource) ic.lookup("java:comp/env/jdbc/searchman");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (mode.equals(searchJan2020)) {
			// JavaBeansの初期化
			BudgetTrackerSearchLogic btSearchLogic = BudgetTrackerSearchLogicFactory.createBudgetTrackerLogic(request,
					ds, mode);

			List<BudgetTrackerSearchDto> rset = null;
			try {
				rset = btSearchLogic.searchData();
			} catch (Exception e) {
				e.printStackTrace();
				status = "Failed!";
			}

			// statusをセットして、result.jspに転送
			request.setAttribute("status", status);
			request.setAttribute("SqlResult", rset);
			request.getRequestDispatcher("/searchResultJan2020.jsp").forward(request, response);
		} else if (mode.equals(searchByStoreNameDescJan2020)) {
			BudgetTrackerSearchLogic btSearchLogic = BudgetTrackerSearchLogicFactory.createBudgetTrackerLogic(request,
					ds, mode);

			List<BudgetTrackerSearchDto> rset = null;
			try {
				rset = btSearchLogic.searchStoreNameDescJan2020();
			} catch (Exception e) {
				e.printStackTrace();
				status = "Failed!";
			}

			// statusをセットして、result.jspに転送
			request.setAttribute("status", status);
			request.setAttribute("SqlResult", rset);
			request.getRequestDispatcher("/searchResultByStoreNameDesc.jsp").forward(request, response);
		} else if (mode.equals(searchByTypeDescJan2020)) {
			BudgetTrackerSearchLogic btSearchLogic = BudgetTrackerSearchLogicFactory.createBudgetTrackerLogic(request,
					ds, mode);

			List<BudgetTrackerSearchDto> rset = null;
			try {
				rset = btSearchLogic.searchByTypeDescJan2020();
			} catch (Exception e) {
				e.printStackTrace();
				status = "Failed!";
			}

			// statusをセットして、result.jspに転送
			request.setAttribute("status", status);
			request.setAttribute("SqlResult", rset);
			request.getRequestDispatcher("/searchResultByType.jsp").forward(request, response);
		} else if (mode.equals(modifyJan2020)){
			BudgetTrackerSearchLogic btSearchLogic = BudgetTrackerSearchLogicFactory.createBudgetTrackerLogic(request,
					ds, mode);
			request.setAttribute("btSearchLogic", btSearchLogic);
			request.getRequestDispatcher("/searchResultModifyJan2020.jsp").forward(request, response);
			return;
			
		} else if (mode.equals(delAddJan2020)){
			BudgetTrackerLogic btLogic = BudgetTrackerLogicFactory.createBudgetTrackerLogic(request, ds, mode);
			BudgetTrackerDeleteLogic btDeleteLogic = BudgetTrackerDeleteLogicFactory.createBudgetTrackerDeleteLogic(request, ds, mode);
			
			try {
				if (!(btDeleteLogic.deleteData() && btLogic.addData())) {
					status = "Failed";
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("do nothing");
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}
}