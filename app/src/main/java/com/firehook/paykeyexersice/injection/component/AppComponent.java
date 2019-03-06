package com.firehook.paykeyexersice.injection.component;

import com.firehook.paykeyexersice.injection.module.ApplicationModule;
import com.firehook.paykeyexersice.mvp.presenter.MovieListPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Vladyslav Bondar on 06.03.2019
 * Skype: diginital
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface AppComponent {

    void inject(MovieListPresenter presenter);
}
