package info.budget.budgettracker;

import javax.sql.DataSource;
import javax.servlet.http.HttpServletRequest;

public class BudgetTrackerSearchLogicFactory {
    
    public static BudgetTrackerSearchLogic createBudgetTrackerLogic(
        HttpServletRequest request, DataSource ds, String mode){
    	BudgetTrackerSearchLogic res = null;

        switch(mode) {
            case "searchJan2020":
                res = new Jan2020Search(request, ds);
                break;
                // ƒNƒ‰ƒX‚ğ‘‚â‚·‚Æ‚«‚Écase‚ğ’Ç‰Á
            default:
                break;
        }

        return res;
    }
}