package com.firehook.paykeyexersice.networking;

/**
 * Created by Vladyslav Bondar on 04.03.2019
 * Skype: diginital
 */

public class CallbackServiceImplementation implements CallbackServerService {

    private ServerServiceUtil util;

    public CallbackServiceImplementation(ServerServiceUtil util) {
        this.util = util;
    }

    @Override
    public void getData(String apiKey, int page, ResultCallback callback) {
        util.execute(apiKey, page, callback);
    }
}
