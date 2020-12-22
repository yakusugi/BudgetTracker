package info.budget.budgettracker;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

public class Jan2020Delete extends BudgetTrackerDeleteLogic {
	
	public Jan2020Delete(HttpServletRequest request, DataSource ds) {
		super(request, ds);
	}
	
	@Override
	protected String getTableName() {
		return "Jan2020";
	}
}
