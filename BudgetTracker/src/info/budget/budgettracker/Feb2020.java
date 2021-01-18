package info.budget.budgettracker;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

public class Feb2020 extends BudgetTrackerAddLogic {
	
	public Feb2020(HttpServletRequest request, DataSource ds) {
		super(request, ds);
	}
	
	@Override
	protected String getTableName() {
		return "Feb2020";
	}
}
