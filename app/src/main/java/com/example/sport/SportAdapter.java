package com.example.sport;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.sport.model.sport;

import java.util.ArrayList;

public class SportAdapter extends RecyclerView.Adapter<SportAdapter.ListViewHolder> {
    private ArrayList<sport> listSport;

    public SportAdapter(ArrayList<sport> listSport) {
        this.listSport = listSport;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row,parent,false);

        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        sport sport = listSport.get(position);

        holder.txtTitle.setText(sport.getStrEvent());
        holder.txtHome.setText(sport.getStrHomeTeam());
        holder.txtHomeScore.setText(sport.getIntHomeScore());
        holder.txtAway.setText(sport.getStrAwayTeam());

        holder.txtAwayScore.setText(sport.getIntAwayScore());
        holder.txtDate.setText(sport.getDateEvent());

        holder.txtimg.setText(sport.getStrThumb());

        Glide.with(holder.itemView)
                .load(sport.getStrThumb())
                .into(holder.imgPoster);
    }

    @Override
    public int getItemCount() {
        return listSport.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitle;
        TextView txtHome;
        TextView txtHomeScore;
        TextView txtAway;
        TextView txtDate;
        TextView txtimg;
        TextView txtAwayScore;
        ImageView imgPoster;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            txtimg = itemView.findViewById(R.id.txtimg);
            txtDate = itemView.findViewById(R.id.txtDate);
            txtHome =  itemView.findViewById(R.id.txtHome);
            txtHomeScore =  itemView.findViewById(R.id.txtHomeScore);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtAway = itemView.findViewById(R.id.txtAway);
            txtAwayScore = itemView.findViewById(R.id.txtAwayScore);
            imgPoster = itemView.findViewById(R.id.imgPoster);
            Button button = itemView.findViewById(R.id.btnDetail);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Toast toast = Toast.makeText(view.getContext(), "Berhasil di click", Toast.LENGTH_SHORT);
                    toast.show();
                    Intent intent = new Intent(view.getContext(), DetailActivity.class);

                    intent.putExtra("title", txtTitle.getText().toString());
                    intent.putExtra("Home", txtHome.getText().toString());
                    intent.putExtra("HomeScore", txtHomeScore.getText().toString());
                    intent.putExtra("Away", txtAway.getText().toString());
                    intent.putExtra("AwayScore", txtAwayScore.getText().toString());
                    intent.putExtra("Date", txtDate.getText().toString());
                    intent.putExtra("img", txtimg.getText().toString());



                    view.getContext().startActivity(intent);

                }
            });
        }
    }
}

