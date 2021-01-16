package com.example.sport;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sport.model.NextSportResponse;
import com.example.sport.model.SportResponse;
import com.example.sport.model.nextsport;
import com.example.sport.model.sport;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NextPlayFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NextPlayFragment extends Fragment {

    private ArrayList<nextsport> listNextSport;
    private RecyclerView rvNextSport;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_next_play, container, false);
        rvNextSport = view.findViewById(R.id.rv_sport);
        rvNextSport.setHasFixedSize(true);
        rvNextSport.setLayoutManager(new LinearLayoutManager(getContext()));

        NextApiService service = ApiClient.getRetrofitInstance().create(NextApiService.class);
        Call<NextSportResponse> call = service.getPlayingNextSport("4328");
        call.enqueue(new Callback<NextSportResponse>() {
            @Override
            public void onResponse(Call<NextSportResponse> call, Response<NextSportResponse> response) {

                listNextSport = response.body().getEvents();

                NextSportAdapter nextSportAdapter = new NextSportAdapter(listNextSport);
                rvNextSport.setAdapter(nextSportAdapter);
            }

            @Override
            public void onFailure(Call<NextSportResponse> call, Throwable t) {

            }
        });



        return view;
    }
}