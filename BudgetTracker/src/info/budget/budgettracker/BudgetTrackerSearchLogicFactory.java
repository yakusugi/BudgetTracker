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
                // クラスを増やすときにcaseを追加
            case "searchByStoreNameDescJan2020":
                res = new Jan2020Search(request, ds);
                break;
                // クラスを増やすときにcaseを追加
            case "searchByTypeDescJan2020":
                res = new Jan2020Search(request, ds);
                break;
                // クラスを増やすときにcaseを追加
            case "modifyJan2020":
                res = new Jan2020Search(request, ds);
                break;
                // クラスを増やすときにcaseを追加
            case "delAddJan2020":
                res = new Jan2020Search(request, ds);
                break;
                // クラスを増やすときにcaseを追加
            case "likeSearchByProductNameJan2020":
                res = new Jan2020Search(request, ds);
                break;
                // クラスを増やすときにcaseを追加
            case "searchByTotalSumOfJan2020":
                res = new Jan2020Search(request, ds);
                break;
                // クラスを増やすときにcaseを追加
            case "searchFeb2020":
                res = new Feb2020Search(request, ds);
                break;               
                // クラスを増やすときにcaseを追加
            default:
                break;
        }

        return res;
    }
}