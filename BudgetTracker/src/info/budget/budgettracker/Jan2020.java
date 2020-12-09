package info.budget.budgettracker;

public class Jan2020 extends BudgetTrackerLogic {
	
	public Jan2020(HttpServletRequest request, DataSource ds) {
		super(request, ds);
	}
	
	@Override
	protected String getTableName() {
		return "Jan2020";
	}
}
