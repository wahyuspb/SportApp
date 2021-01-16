package com.example.sport;

import com.example.sport.model.NextSportResponse;
import com.example.sport.model.SportResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NextApiService {
    @GET("api/v1/json/1/eventsnextleague.php")
    Call<NextSportResponse> getPlayingNextSport(@Query("id") String id);
}
