package info.budget.budgettracker;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

public class Jan2020 extends BudgetTrackerAddLogic {
	
	public Jan2020(HttpServletRequest request, DataSource ds) {
		super(request, ds);
	}
	
	@Override
	protected String getTableName() {
		return "Jan2020";
	}
}
