package com.firehook.paykeyexersice.networking;

/**
 * Created by Vladyslav Bondar on 04.03.2019
 * Skype: diginital
 */

public interface ResultCallback {
    default void onGotResult( Object o) {}
}
