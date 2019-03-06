package com.firehook.paykeyexersice.networking.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Vladyslav Bondar on 04.03.2019
 * Skype: diginital
 */

public class Genre {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("name")
    @Expose
    public String name;

}
