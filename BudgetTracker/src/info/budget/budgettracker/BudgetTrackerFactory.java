package info.budget.budgettracker;

import javax.sql.DataSource;
import javax.servlet.http.HttpServletRequest;

public class BudgetTrackerLogicFactory {
    
    public static BudgetTrackerLogic createBudgetTrackerLogic(
        HttpServletRequest request, DataSource ds, String mode){
        BudgetTrackerLogic res = null;

        switch(mode) {
            case "addJan2020":
                res = new Jan2020(request, ds);
                break;
                // クラスを増やすときにcaseを追加
            default:
                break;
        }

        return res;
    }
}