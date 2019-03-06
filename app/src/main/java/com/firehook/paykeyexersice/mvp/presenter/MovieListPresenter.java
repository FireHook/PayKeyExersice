package com.firehook.paykeyexersice.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.firehook.paykeyexersice.App;
import com.firehook.paykeyexersice.DataManager;
import com.firehook.paykeyexersice.mvp.view.MovieListView;
import com.firehook.paykeyexersice.networking.API;
import com.firehook.paykeyexersice.networking.ApiClient;
import com.firehook.paykeyexersice.networking.model.CoreResponse;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Vladyslav Bondar on 06.03.2019
 * Skype: diginital
 */

@InjectViewState
public class MovieListPresenter extends MvpPresenter<MovieListView> {

    @Inject DataManager dataManager;

    public MovieListPresenter() {
        App.sAppComponent.inject(this);
    }

    public void loadDataFromNetwork(String api_key) {

        getViewState().startProgress();

        API client = ApiClient.getClient().create(API.class);

        for (int i = 1; i < 6; i++) {
            client.getData(api_key, i).enqueue(new Callback<CoreResponse>() {
                @Override
                public void onResponse(Call<CoreResponse> call, Response<CoreResponse> response) {
                    getViewState().populateMovieAdapter(response.body().results);
                    if (response.body().page == 5)
                        getViewState().stopProgress();
                }

                @Override
                public void onFailure(Call<CoreResponse> call, Throwable t) {
                    getViewState().showNetworkError();
                }
            });
        }
    }
}
