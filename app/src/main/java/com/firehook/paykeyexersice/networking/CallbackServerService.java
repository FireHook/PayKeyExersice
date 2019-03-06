package com.firehook.paykeyexersice.networking;

/**
 * Created by Vladyslav Bondar on 04.03.2019
 * Skype: diginital
 */

public interface CallbackServerService {
    void getData(String apiKey, int page, ResultCallback callback);
}
