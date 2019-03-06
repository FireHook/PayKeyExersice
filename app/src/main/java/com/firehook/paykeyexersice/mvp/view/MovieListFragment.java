package com.firehook.paykeyexersice.mvp.view;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.firehook.paykeyexersice.R;
import com.firehook.paykeyexersice.adapter.MoviesListAdapter;
import com.firehook.paykeyexersice.mvp.presenter.MovieListPresenter;
import com.firehook.paykeyexersice.networking.model.Movie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vladyslav Bondar on 04.03.2019
 * Skype: diginital
 */

public class MovieListFragment extends MvpAppCompatFragment implements MovieListView {

    @InjectPresenter MovieListPresenter mPresenter;

    private MoviesListAdapter mAdapter;
    private ProgressBar mProgressBar;

    private MoviesListAdapter.OnItemClickListener mItemClickListener = movie -> {
        getActivity().getSupportFragmentManager().beginTransaction()
                .add(R.id.content_frame, MovieDetailFragment.newInstance(movie), MovieDetailFragment.class.getSimpleName())
                .addToBackStack(MovieDetailFragment.class.getSimpleName())
                .commit();
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movie_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mProgressBar = getActivity().findViewById(R.id.progress_bar);
        RecyclerView mRecyclerView = getActivity().findViewById(R.id.movies_recycler_view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        DividerItemDecoration decoration = new DividerItemDecoration(mRecyclerView.getContext(),
                linearLayoutManager.getOrientation());
        mRecyclerView.addItemDecoration(decoration);
        mAdapter = new MoviesListAdapter(new ArrayList<>());
        mRecyclerView.setAdapter(mAdapter);

        mPresenter.loadDataFromNetwork(getString(R.string.api_key));
    }

    @Override
    public void onStart() {
        super.onStart();
        if (mAdapter != null) mAdapter.setOnItemClickListener(mItemClickListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAdapter != null) mAdapter.setOnItemClickListener(null);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.movie_list_menu, menu);
        initSearchView(menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    private void initSearchView(Menu menu) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            MenuItem searchMenuItem = menu.findItem(R.id.action_search);
            SearchManager searchManager = (SearchManager) activity.getSystemService(Context.SEARCH_SERVICE);
            SearchView searchView = (SearchView) searchMenuItem.getActionView();

            if (searchManager != null) {
                searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));
                searchView.setQueryHint(getString(R.string.search));
                searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

                    @Override public boolean onQueryTextSubmit(String query) {
                        return false;
                    }

                    @Override public boolean onQueryTextChange(String newText) {
                        if (mAdapter != null)
                            mAdapter.filter(newText);
                        return true;
                    }
                });
            }
        }
    }

    @Override
    public void populateMovieAdapter(List<Movie> movies) {
        mAdapter.addMovies(movies);
    }

    @Override
    public void showNetworkError() {
        Toast.makeText(getContext(), R.string.network_error, Toast.LENGTH_LONG).show();
    }

    @Override
    public void startProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void stopProgress() {
        mProgressBar.setVisibility(View.INVISIBLE);
    }
}