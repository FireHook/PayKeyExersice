package com.firehook.paykeyexersice.networking.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Vladyslav Bondar on 04.03.2019
 * Skype: diginital
 */

public class SpokenLanguage {

    @SerializedName("iso_639_1")
    @Expose
    public String iso6391;
    @SerializedName("name")
    @Expose
    public String name;

}
