package com.firehook.paykeyexersice.mvp.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.firehook.paykeyexersice.networking.model.Movie;

import java.util.List;

/**
 * Created by Vladyslav Bondar on 06.03.2019
 * Skype: diginital
 */

@StateStrategyType(OneExecutionStateStrategy.class)
public interface MovieListView extends MvpView {
    void populateMovieAdapter(List<Movie> movies);
    void showNetworkError();
    void startProgress();
    void stopProgress();
}
