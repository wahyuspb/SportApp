package com.example.sport;


import com.example.sport.model.SportResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("api/v1/json/1/eventspastleague.php")
    Call<SportResponse> getPlayingSport(@Query("id") String id);
}
