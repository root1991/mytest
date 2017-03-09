package test.badoo.com.andrewkhrystiantest.base;

import android.support.annotation.NonNull;
import android.support.annotation.StringRes;

import com.trello.navi.Event;
import com.trello.navi.NaviComponent;
import com.trello.navi.rx.RxNavi;

import rx.Subscription;
import rx.functions.Action1;
import rx.internal.util.SubscriptionList;
import test.badoo.com.andrewkhrystiantest.App;
import test.badoo.com.andrewkhrystiantest.manager.DataManager;

/**
 * Created by andrewkhristyan on 3/9/17.
 */

public abstract class BaseMvpPresenterImpl<V extends BaseMvpView> implements BaseMvpPresenter<V> {

    protected V mView;
    protected final DataManager mDataManager = App.getDataManager();
    protected SubscriptionList mSubscriptionList = new SubscriptionList();

    /**
     * Attach view to presenter, also here we have subscription
     * for destroy event. On destroy event we should detach view
     * and destroy presenter
     *
     * @param view extend BaseMvpView
     */
    @Override
    public void attachView(V view) {
        mView = view;
        mSubscriptionList.add(RxNavi.observe((NaviComponent) view, Event.DESTROY).subscribe(new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                detachView();
            }
        }));
    }

    /**
     * This method adds given rx subscription to the {@link #mSubscriptionList}
     * which is unsubscribed {@link #detachView()}
     *
     * @param subscription - rx subscription that must be unsubscribed {@link #detachView()}
     */
    protected void addSubscription(@NonNull Subscription subscription) {
        mSubscriptionList.add(subscription);
    }

    protected String getString(@StringRes int strResId) {
        return mView.getContext().getString(strResId);
    }

    protected String getString(@StringRes int strResId, Object... formatArgs) {
        return mView.getContext().getString(strResId, formatArgs);
    }

    /**
     * Here we are detaching view and removing and
     * unsubscribing all subscriptions
     */
    @Override
    public void detachView() {
        mSubscriptionList.unsubscribe();
        mSubscriptionList.clear();
        mView = null;
    }

}
