package info.budget.budgettracker;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class BudgetTrackerController extends HttpServlet {
	
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

		// 実行ステータスの宣言
		String status = "Successed!";
		
		// データソースの取得
		DataSource ds = null;
		try {
			ds = (DataSource) ic.lookup("java:comp/env/jdbc/searchman");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// JavaBeansの初期化
		BudgetTrackerLogic btLogic = BudgetTrackerLogicFactory.createBudgetTrackerLogic((request, ds, mode);

        if (btLogic.addData() == false) {
            status = "Failed!";
		}

		// statusをセットして、result.jspに転送
        request.setAttribute("status", status);
        request.getRequestDispatcher("/result.jsp").forward(request, response);

	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

}
