package com.firehook.paykeyexersice;

import android.app.Application;

import com.firehook.paykeyexersice.injection.component.AppComponent;
import com.firehook.paykeyexersice.injection.component.DaggerAppComponent;
import com.firehook.paykeyexersice.injection.module.ApplicationModule;

/**
 * Created by Vladyslav Bondar on 06.03.2019
 * Skype: diginital
 */

public class App extends Application {

    public static AppComponent sAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        sAppComponent = DaggerAppComponent.builder().applicationModule(new ApplicationModule()).build();
    }

}
