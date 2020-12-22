package info.budget.budgettracker;

import javax.sql.DataSource;
import javax.servlet.http.HttpServletRequest;

public class BudgetTrackerDeleteLogicFactory {
    
    public static BudgetTrackerDeleteLogic createBudgetTrackerDeleteLogic(
        HttpServletRequest request, DataSource ds, String mode){
        BudgetTrackerDeleteLogic res = null;

        switch(mode) {
            case "deleteJan2020":
                res = new Jan2020Delete(request, ds);
                break;
                // ƒNƒ‰ƒX‚ğ‘‚â‚·‚Æ‚«‚Écase‚ğ’Ç‰Á
            default:
                break;
        }

        return res;
    }
}