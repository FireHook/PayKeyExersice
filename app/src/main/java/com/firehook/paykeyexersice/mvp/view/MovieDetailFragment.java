package com.firehook.paykeyexersice.mvp.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.firehook.paykeyexersice.R;
import com.firehook.paykeyexersice.networking.model.Movie;
import com.squareup.picasso.Picasso;

/**
 * Created by Vladyslav Bondar on 04.03.2019
 * Skype: diginital
 */

public class MovieDetailFragment extends Fragment {

    private Movie mMovie;

    public static MovieDetailFragment newInstance(Movie movie) {
        MovieDetailFragment instance = new MovieDetailFragment();
        instance.mMovie = movie;
        return instance;
    }

    @Nullable @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.movie_detail_item, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView mImageView = view.findViewById(R.id.image_detail);
        TextView mTextTitle = view.findViewById(R.id.original_title);
        TextView mGenres = view.findViewById(R.id.overview);

        if (mMovie != null) {
            Picasso.get().load("https://image.tmdb.org/t/p/w500".concat(mMovie.posterPath)).into(mImageView);
            mTextTitle.setText(mMovie.originalTitle);
            mGenres.setText(mMovie.overview);
        }
    }
}
