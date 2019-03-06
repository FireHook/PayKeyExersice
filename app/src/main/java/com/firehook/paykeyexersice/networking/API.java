package com.firehook.paykeyexersice.networking;

import com.firehook.paykeyexersice.networking.model.CoreResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Vladyslav Bondar on 04.03.2019
 * Skype: diginital
 */

public interface API {
    @GET("movie/popular?language=en-US")
    Call<CoreResponse> getData(@Query("api_key") String api_key, @Query("page") int page);
}
