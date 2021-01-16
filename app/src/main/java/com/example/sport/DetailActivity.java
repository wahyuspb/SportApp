package com.example.sport;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        TextView title = (TextView) findViewById(R.id.tv_title_detail);
        TextView Home = (TextView) findViewById(R.id.txtHome_detail);
        TextView HomeScore = (TextView) findViewById(R.id.txtHomeScore_detail);
        TextView Away = (TextView) findViewById(R.id.txtAway_detail);
        TextView AwayScore = (TextView) findViewById(R.id.txtAwayScore_detail);
        TextView Date = (TextView) findViewById(R.id.txtDate);
        ImageView image = (ImageView) findViewById(R.id.img_detail);
        String coverImageSrc = getIntent().getStringExtra("src");
        ImageView imageView = (ImageView) findViewById(R.id.img_detail);

        Glide.with(this)
                .load(getIntent().getStringExtra("img"))
                .into(imageView);

        title.setText(getIntent().getStringExtra("title"));
        Home.setText(getIntent().getStringExtra("Home"));
        HomeScore.setText(getIntent().getStringExtra("HomeScore"));
        Away.setText(getIntent().getStringExtra("Away"));
        AwayScore.setText(getIntent().getStringExtra("AwayScore"));
        Date.setText(getIntent().getStringExtra("Date"));
        Button btn = findViewById(R.id.btn_Fav);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(view.getContext(), "Berhasil di click", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}