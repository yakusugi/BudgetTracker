package info.budget.budgettracker;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

public class Jan2020Search extends BudgetTrackerSearchLogic {
	
	public Jan2020Search(HttpServletRequest request, DataSource ds) {
		super(request, ds);
	}
	
	@Override
	protected String getTableName() {
		return "Jan2020";
	}
}
