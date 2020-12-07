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

		// 文字コードの設定
		request.setCharacterEncoding("Windows-31J");

		// modeの取得
		String mode = request.getParameter("mode");

		// 実行ステータスの宣言
		String status = "Successed!";

		// JavaBeansの初期化
		//BudgetBeansへ値を流す
		

		switch (mode) {

		case "addJan2020": // 登録
			BudgetTrackerLogic btLogicJan2020 = new Jan2020(request);
			if (btLogicJan2020.addData() == false) {
				status = "Failed!";
			}
			break;
			
//		case "delete": // 削除
//			if (budgetInfo.deleteData() == false) {
//				status = "Failed!";
//			}
//			break;
//			
//		case "change": // 変更
//			request.setAttribute("budgetInfo", budgetInfo);
//			request.getRequestDispatcher("/change.jsp").forward(request, response);
//			return;
//
//		case "del_add": // 変更確定
//			if (!(budgetInfo.deleteData() && budgetInfo.addData())) {
//				status = "Failed";
//			}
//			break;

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
