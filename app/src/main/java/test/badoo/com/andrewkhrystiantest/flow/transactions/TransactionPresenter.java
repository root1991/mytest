package test.badoo.com.andrewkhrystiantest.flow.transactions;

import java.text.DecimalFormat;
import java.util.List;

import test.badoo.com.andrewkhrystiantest.base.BaseMvpPresenterImpl;
import test.badoo.com.andrewkhrystiantest.data.model.TransactionDetail;

/**
 * Created by andrewkhristyan on 3/9/17.
 */

class TransactionPresenter extends BaseMvpPresenterImpl<TransactionContract.View> implements TransactionContract.Presenter {

    private static final String GBP = "GBP";

    @Override
    public void generateData(String transactionName) {
        List<TransactionDetail> details = mDataManager.getTransactionsByName(transactionName, GBP);
        DecimalFormat f = new DecimalFormat("#.00");
        String totalPounds = GBP + ": " + f.format(mDataManager.getTotalPounds(details));

        mView.showTotalPounds(totalPounds);
        mView.showResults(details);
    }

}
