package info.budget.budgettracker;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

public class Feb2020Search extends BudgetTrackerSearchLogic {
	
	public Feb2020Search(HttpServletRequest request, DataSource ds) {
		super(request, ds);
	}
	
	@Override
	protected String getTableName() {
		return "Feb2020";
	}
}
