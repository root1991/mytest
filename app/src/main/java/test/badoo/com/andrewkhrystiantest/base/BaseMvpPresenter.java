package test.badoo.com.andrewkhrystiantest.base;

/**
 * Created by andrewkhristyan on 3/9/17.
 */

public interface BaseMvpPresenter<V extends BaseMvpView> {

    void attachView(V view);

    void detachView();

}
