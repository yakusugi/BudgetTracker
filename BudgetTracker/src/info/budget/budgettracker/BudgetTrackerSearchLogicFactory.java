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
                // �N���X�𑝂₷�Ƃ���case��ǉ�
            case "searchByStoreNameDescJan2020":
                res = new Jan2020Search(request, ds);
                break;
                // �N���X�𑝂₷�Ƃ���case��ǉ�
            case "searchByTypeDescJan2020":
                res = new Jan2020Search(request, ds);
                break;
                // �N���X�𑝂₷�Ƃ���case��ǉ�
            case "modifyJan2020":
                res = new Jan2020Search(request, ds);
                break;
                // �N���X�𑝂₷�Ƃ���case��ǉ�
            case "delAddJan2020":
                res = new Jan2020Search(request, ds);
                break;
                // �N���X�𑝂₷�Ƃ���case��ǉ�
            case "likeSearchByProductNameJan2020":
                res = new Jan2020Search(request, ds);
                break;
                // �N���X�𑝂₷�Ƃ���case��ǉ�
            case "searchByTotalSumOfJan2020":
                res = new Jan2020Search(request, ds);
                break;
                // �N���X�𑝂₷�Ƃ���case��ǉ�
            case "searchFeb2020":
                res = new Feb2020Search(request, ds);
                break;               
                // �N���X�𑝂₷�Ƃ���case��ǉ�
            default:
                break;
        }

        return res;
    }
}