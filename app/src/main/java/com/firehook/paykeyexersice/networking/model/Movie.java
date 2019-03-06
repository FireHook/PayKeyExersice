package com.firehook.paykeyexersice.networking.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Movie {
	@SerializedName("vote_count") 		 @Expose public Integer voteCount;
	@SerializedName("id") 				 @Expose public Integer id;
	@SerializedName("video") 			 @Expose public Boolean video;
	@SerializedName("vote_average") 	 @Expose public Double voteAverage;
	@SerializedName("title") 			 @Expose public String title;
	@SerializedName("popularity") 		 @Expose public Double popularity;
	@SerializedName("poster_path")       @Expose public String posterPath;
	@SerializedName("original_language") @Expose public String originalLanguage;
	@SerializedName("original_title")    @Expose public String originalTitle;
	@SerializedName("genre_ids") 		 @Expose public List<Integer> genreIds = new ArrayList<Integer>();
	@SerializedName("backdrop_path") 	 @Expose public String backdropPath;
	@SerializedName("adult") 			 @Expose public Boolean adult;
	@SerializedName("overview") 		 @Expose public String overview;
	@SerializedName("release_date") 	 @Expose public String releaseDate;

	public Movie(Movie movie) {
		id = movie.id;
		title = movie.title;
		popularity = movie.popularity;
		posterPath = movie.posterPath;
		originalLanguage = movie.originalLanguage;
		originalTitle = movie.originalTitle;
	}
}