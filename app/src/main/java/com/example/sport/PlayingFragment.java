package com.example.sport;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sport.model.SportResponse;
import com.example.sport.model.sport;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PlayingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */


public class PlayingFragment extends Fragment {

    private ArrayList<sport> listSport;
    private RecyclerView rvSport;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_playing, container, false);
        rvSport = view.findViewById(R.id.rv_sport);
        rvSport.setHasFixedSize(true);
        rvSport.setLayoutManager(new LinearLayoutManager(getContext()));

        ApiService service = ApiClient.getRetrofitInstance().create(ApiService.class);
        Call<SportResponse> call = service.getPlayingSport("4328");
        call.enqueue(new Callback<SportResponse>() {
            @Override
            public void onResponse(Call<SportResponse> call, Response<SportResponse> response) {

                listSport = response.body().getEvents();

                SportAdapter sportAdapter = new SportAdapter(listSport);
                rvSport.setAdapter(sportAdapter);
            }

            @Override
            public void onFailure(Call<SportResponse> call, Throwable t) {

            }
        });



        return view;
    }
}
