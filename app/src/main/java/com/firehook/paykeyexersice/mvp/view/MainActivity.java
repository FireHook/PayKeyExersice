package com.firehook.paykeyexersice.mvp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.firehook.paykeyexersice.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("TAG", "OnCreate");

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_frame, new MovieListFragment(), MovieListFragment.class.getSimpleName())
                .commit();
    }
}
