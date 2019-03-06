package com.firehook.paykeyexersice.injection.module;

import com.firehook.paykeyexersice.DataManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Vladyslav Bondar on 06.03.2019
 * Skype: diginital
 */

@Module
public class ApplicationModule {

    public ApplicationModule() {    }

    @Provides @Singleton
    DataManager provideDataManager() { return new DataManager(); }
}
