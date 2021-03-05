package info.budget.budgettracker;

import javax.sql.DataSource;
import javax.servlet.http.HttpServletRequest;

public class BudgetTrackerDeleteLogicFactory {
    
    public static BudgetTrackerDeleteLogic createBudgetTrackerDeleteLogic(
        HttpServletRequest request, DataSource ds, String mode, String year, String month){
        BudgetTrackerDeleteLogic res = null;

        switch(mode) {
            case "deleteJan2020":
                res = new Jan2020Delete(request, ds);
                break;
                // クラスを増やすときにcaseを追加
            case "delAddJan2020":
                res = new Jan2020Delete(request, ds);
                break;
                // クラスを増やすときにcaseを追加
            default:
                break;
        }

        return res;
    }
}