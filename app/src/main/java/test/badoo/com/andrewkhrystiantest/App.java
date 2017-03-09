package test.badoo.com.andrewkhrystiantest;

import android.app.Application;

import test.badoo.com.andrewkhrystiantest.manager.DataManager;

/**
 * Created by andrewkhristyan on 3/9/17.
 */

public class App extends Application{

    private static DataManager sDataManager = new DataManager();


    @Override
    public void onCreate() {
        super.onCreate();
        sDataManager.init(this);
    }

    public static DataManager getDataManager() {
        return sDataManager;
    }
}
