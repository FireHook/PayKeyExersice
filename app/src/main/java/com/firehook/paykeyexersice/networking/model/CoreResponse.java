package com.firehook.paykeyexersice.networking.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class CoreResponse {
	@SerializedName("page")
	@Expose
	public Integer page;
	@SerializedName("total_results")
	@Expose
	public Integer totalResults;
	@SerializedName("total_pages")
	@Expose
	public Integer totalPages;
	@SerializedName("results")
	@Expose
	public List<Movie> results = new ArrayList<Movie>();
}