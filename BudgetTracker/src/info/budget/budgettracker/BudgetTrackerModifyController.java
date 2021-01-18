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
		
		//ココカラ
		
		if (mode.equals(delAddJan2020)) {
			// JavaBeansの初期化
			BudgetTrackerDeleteLogic btDeleteLogic = BudgetTrackerDeleteLogicFactory.createBudgetTrackerDeleteLogic(request, ds, mode);
			BudgetTrackerAddLogic btLogic = BudgetTrackerAddLogicFactory.createBudgetTrackerLogic(request, ds, mode);
			
			
			try {
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

			// statusをセットして、result.jspに転送
	        request.setAttribute("status", status);
	        request.getRequestDispatcher("/result.jsp").forward(request, response);
		} 

		// JavaBeansの初期化
		BudgetTrackerAddLogic btLogic = BudgetTrackerAddLogicFactory.createBudgetTrackerLogic(request, ds, mode);
		
		try {
		    btLogic.addData();
		} catch (Exception e) {
		    e.printStackTrace();
		        status = "Failed!";
		}

		// statusをセットして、result.jspに転送
        request.setAttribute("status", status);
        request.getRequestDispatcher("/result.jsp").forward(request, response);
        
        //ココマデ

	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

}