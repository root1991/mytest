package test.badoo.com.andrewkhrystiantest.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.trello.navi.component.support.NaviAppCompatActivity;

/**
 * Created by andrewkhristyan on 3/9/17.
 */

public abstract class BaseMvpActivity<T extends BaseMvpPresenter> extends NaviAppCompatActivity implements BaseMvpView{


    protected T mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = getPresenterInstance();
        mPresenter.attachView(this);
    }

    protected @NonNull abstract T getPresenterInstance();

    @Override
    public Context getContext() {
        return this;
    }

}
