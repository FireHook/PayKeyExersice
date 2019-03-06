package com.firehook.paykeyexersice.networking;

import android.os.AsyncTask;

import com.firehook.paykeyexersice.networking.model.CoreResponse;

import retrofit2.Response;

/**
 * Created by Vladyslav Bondar on 04.03.2019
 * Skype: diginital
 */

public class ServerServiceUtil  {

    private API serverAPI;

    public ServerServiceUtil(API api) {
        serverAPI = api;
    }

    public void execute(String apiKey, int page, ResultCallback callback)  {
        ServerAsyncTask task = new ServerAsyncTask(apiKey, page, new ResultCallback() {
            @Override
            public void onGotResult(Object o) {
                callback.onGotResult(o);
            }
        });
        task.execute();
    }

    private class ServerAsyncTask extends AsyncTask<Void, Void,  Response<CoreResponse>> {

        private final String apiKey;
        private final int page;
        private final ResultCallback callback;

        public ServerAsyncTask(String apiKey, int page, ResultCallback callback) {
            this.apiKey = apiKey;
            this.page = page;
            this.callback = callback;
        }

        @Override
        protected Response<CoreResponse> doInBackground(Void... voids) {
            return null;
        }

        @Override
        protected void onPostExecute(Response<CoreResponse> coreResponseResponse) {
            if (coreResponseResponse != null) {
                callback.onGotResult(coreResponseResponse.body());
            }
        }
    }
}
