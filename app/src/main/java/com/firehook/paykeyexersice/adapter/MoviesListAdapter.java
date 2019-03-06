package com.firehook.paykeyexersice.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.firehook.paykeyexersice.R;
import com.firehook.paykeyexersice.networking.model.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vladyslav Bondar on 04.03.2019
 * Skype: diginital
 */

public class MoviesListAdapter extends RecyclerView.Adapter<MoviesListAdapter.ViewHolder> {

    private List<Movie> mMovieList;
    private List<Movie> mCachedList;
    private OnItemClickListener mOnItemClickListener;

    public MoviesListAdapter(List<Movie> movieList) {
        mMovieList = movieList;
        mCachedList = new ArrayList<>();
    }

    @NonNull @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_list_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final Movie movie = mMovieList.get(i);

        viewHolder.mTitle.setText(movie.title);
        viewHolder.mPopularity.setText(movie.popularity.toString());

        Picasso.get().load("https://image.tmdb.org/t/p/w500".concat(movie.posterPath))
                .resize(100, 100).into(viewHolder.mMovieImage);

        viewHolder.itemView.setOnClickListener(v -> {
            if (mOnItemClickListener != null) mOnItemClickListener.onItemClicked(movie);
        });
    }

    @Override
    public int getItemCount() {
        return mMovieList.size();
    }

    public void addMovies(List<Movie> movies) {
        mMovieList.addAll(movies);
        mCachedList.addAll(movies);
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public void filter(String constraint) {
        mMovieList.clear();
        if (constraint != null && constraint.length() > 0) {
            for (int i = 0; i < mCachedList.size(); i++) {
                if ((mCachedList.get(i).title.toLowerCase()).contains(String.valueOf(constraint).toLowerCase())) {
                    mMovieList.add(new Movie(mCachedList.get(i)));
                    Log.d("TAG", "Match!!!");
                }
            }
        } else {
            mMovieList.addAll(mCachedList);
        }
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView mMovieImage;
        TextView mTitle;
        TextView mPopularity;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mMovieImage = itemView.findViewById(R.id.image_movie);
            mTitle = itemView.findViewById(R.id.movie_title);
            mPopularity = itemView.findViewById(R.id.movie_popularity);
        }
    }

    public interface OnItemClickListener {
        void onItemClicked(Movie movie);
    }
}
