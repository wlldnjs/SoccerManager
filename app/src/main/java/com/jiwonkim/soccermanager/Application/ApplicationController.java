package com.jiwonkim.soccermanager.Application;

import android.app.Application;

/**
 * Created by user on 2017-06-07.
 */

public class ApplicationController extends Application {
    private static ApplicationController instance;
    public static ApplicationController getInstance(){
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ApplicationController.instance = this;
    }

    public ApplicationController() {
    }

}
