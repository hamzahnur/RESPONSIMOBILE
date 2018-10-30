package com.example.user.hamzah0577.activity;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.user.hamzah0577.DataMovie;
import com.example.user.hamzah0577.R;
import com.example.user.hamzah0577.database.MovieContract;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailMovieActivity extends AppCompatActivity {

    @BindView(R.id.iv_detail_gambar)
    ImageView ivDetailGambar;
    @BindView(R.id.txt_overview)
    TextView txtOverview;
    @BindView(R.id.txt_popularity)
    TextView txtPopularity;
    @BindView(R.id.txt_rd)
    TextView txtRD;
    @BindView(R.id.txt_vc)
    TextView txtVC;
    @BindView(R.id.image)
    ImageView image;
    ArrayList<DataMovie> datamovies = new ArrayList<>();
    int position;
    SharedPreferences preferences;
    boolean isfavorit = false;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        //terima data dari intent
        datamovies = getIntent().getParcelableArrayListExtra("DATA_MOVIE");
        position = getIntent().getIntExtra("DATA_POSISI",0);
        getSupportActionBar().setTitle(datamovies.get(position).getTitle());
        Glide.with(this).load("https://image.tmdb.org/t/p/w500/"+datamovies.get(position).getBackdropPath()).into(ivDetailGambar);
        txtOverview.setText(datamovies.get(position).getOverview());
        txtPopularity.setText(String.format(String.valueOf(datamovies.get(position).getVoteAverage())));
        txtRD.setText(datamovies.get(position).getReleaseDate());
        txtVC.setText(String.format(String.valueOf(datamovies.get(position).getVoteCount())));
        Glide.with(this).load("https://image.tmdb.org/t/p/w500/"+datamovies.get(position).getPosterPath()).into(image);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                updateFAB();
            }
        });
        //ambil data dari preferences
        isfavorit = preferences.getBoolean("FAVORIT"+ datamovies.get(position).getTitle(), false);

        updateFAB();
    }

    private void updateFAB() {
        if(isfavorit){
            fab.setImageResource(R.drawable.ic_favorit);
        }
        else{
            fab.setImageResource(R.drawable.ic_notfavorit);
        }
    }



}