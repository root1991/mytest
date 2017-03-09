package test.badoo.com.andrewkhrystiantest.flow.transactions;

import java.util.List;

import test.badoo.com.andrewkhrystiantest.base.BaseMvpPresenter;
import test.badoo.com.andrewkhrystiantest.base.BaseMvpView;
import test.badoo.com.andrewkhrystiantest.data.model.TransactionDetail;

/**
 * Created by andrewkhristyan on 3/9/17.
 */

public class TransactionContract {

    interface View extends BaseMvpView {

        void showResults(List<TransactionDetail> transactionDetails);

        void showTotalPounds(String totalPounds);

    }

    interface Presenter extends BaseMvpPresenter<View> {

        void generateData(String transactionName);

    }

}
