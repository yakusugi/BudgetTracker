package info.budget.yearSelection;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class YearSelector
 */
@WebServlet("/YearSelector")
public class YearSelector extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public YearSelector() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// setting text code
				request.setCharacterEncoding("Windows-31J");

				// get month info from mainpage.jsp
				String yearInfo = request.getParameter("year");

				System.out.println(yearInfo);

				try {
					if (yearInfo.equals("2020")) {
						request.getRequestDispatcher("2020.jsp").forward(request, response);
					} if(yearInfo.equals("2021")) {
						request.getRequestDispatcher("2021.jsp").forward(request, response);
					}

				} catch (Exception e) {
					e.printStackTrace();

					doGet(request, response);
				} finally {
					try {
						// just in case, terminate the DB connection with finally statement
						
					} catch (Exception e) {
					}
				}
	}

}
