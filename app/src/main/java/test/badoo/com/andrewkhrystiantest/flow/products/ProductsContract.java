package test.badoo.com.andrewkhrystiantest.flow.products;

import java.util.List;

import test.badoo.com.andrewkhrystiantest.base.BaseMvpPresenter;
import test.badoo.com.andrewkhrystiantest.base.BaseMvpView;
import test.badoo.com.andrewkhrystiantest.data.model.Transaction;

/**
 * Created by andrewkhristyan on 3/9/17.
 */

public class ProductsContract {

    interface View extends BaseMvpView{

        void showResults(List<Transaction> results);

    }

    interface Presenter extends BaseMvpPresenter<View>{

        void generateData();

    }




}
