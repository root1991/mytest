package test.badoo.com.andrewkhrystiantest.flow.products;

import test.badoo.com.andrewkhrystiantest.base.BaseMvpPresenterImpl;

/**
 * Created by andrewkhristyan on 3/9/17.
 */

public class ProductsPresenter extends BaseMvpPresenterImpl<ProductsContract.View> implements ProductsContract.Presenter {

    @Override
    public void generateData() {
        mView.showResults(mDataManager.getListOfProducts());
    }
}
