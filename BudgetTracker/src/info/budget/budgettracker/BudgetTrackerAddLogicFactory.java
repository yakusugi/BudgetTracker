package info.budget.budgettracker;

import javax.sql.DataSource;
import javax.servlet.http.HttpServletRequest;

public class BudgetTrackerAddLogicFactory {
    
    public static BudgetTrackerAddLogic createBudgetTrackerLogic(
        HttpServletRequest request, DataSource ds, String mode){
        BudgetTrackerAddLogic res = null;

        switch(mode) {
            case "addJan2020":
                res = new Jan2020(request, ds);
                break;
                // �N���X�𑝂₷�Ƃ���case��ǉ�
            case "delAddJan2020":
                res = new Jan2020(request, ds);
                break;
                // �N���X�𑝂₷�Ƃ���case��ǉ�
            case "addFeb2020":
                res = new Feb2020(request, ds);
                break;
                // �N���X�𑝂₷�Ƃ���case��ǉ�
            default:
                break;
        }

        return res;
    }
}