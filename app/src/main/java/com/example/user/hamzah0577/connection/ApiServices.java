package com.example.user.hamzah0577.connection;


import com.example.user.hamzah0577.model.ModelListMovie;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by user on 27/01/2018.
 */

public interface ApiServices {




    //sort by nowplaying
    @GET("movie/now_playing?api_key=6faf3907bbbde8f8af6fea8cc8ba5831&language=en-US&page=1")
    Call <ModelListMovie> getNowPlaying();

}
