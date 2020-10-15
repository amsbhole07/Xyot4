package com.xyot4.game.Ui;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.xyot4.game.Constants.Constants;
import com.xyot4.game.R;

public class DashboardActivity extends AppCompatActivity {
    private TextView textView;
    private TextView textView2;
    private ImageView imageView;
    private TextView txtOnlinePlay;
    private TextView txtClosedRoomPlay;
    private TextView txtOfflineSinglePlayer;
    private TextView txtOfflineMultiplayer;
    private TextView txtAlreadyAccnt;

    private void assignViews() {
        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        imageView = (ImageView) findViewById(R.id.imageView);
        txtOnlinePlay = (TextView) findViewById(R.id.txt_online_play);
        txtClosedRoomPlay = (TextView) findViewById(R.id.txt_closed_room_play);
        txtOfflineSinglePlayer = (TextView) findViewById(R.id.txt_offline_single_player);
        txtOfflineMultiplayer = (TextView) findViewById(R.id.txt_offline_multiplayer);
        txtAlreadyAccnt = (TextView) findViewById(R.id.txt_already_accnt);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_dashboard);
        assignViews();
        Glide.with(DashboardActivity.this).load(R.drawable.main_logo).into(imageView);

        txtOnlinePlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              /*  Intent i = new Intent(DashboardActivity.this, OnlinePlayMenuScreenActivity.class);
                startActivity(i);*/
                Intent i = new Intent(DashboardActivity.this, LoginActivity.class);
                i.putExtra(Constants.Screen,Constants.ONLINE_PLAY);
                startActivity(i);
            }
        });

        txtClosedRoomPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              /*  Intent i = new Intent(DashboardActivity.this, OnlineClosedRoomPlayMenuScreenActivity.class);
                startActivity(i);*/

                Intent i = new Intent(DashboardActivity.this, LoginActivity.class);
                i.putExtra(Constants.Screen,Constants.ONLINE_CLOSED_ROOM_PLAY);
                startActivity(i);

            }
        });

        txtOfflineSinglePlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DashboardActivity.this, OfflineSingleplyrMenuScreenActivity.class);
                i.putExtra(Constants.Screen,Constants.OFFLINE_SINGLE_PLAYER);
                startActivity(i);

            }
        });

        txtOfflineMultiplayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DashboardActivity.this, OfflineSingleplyrMenuScreenActivity.class);
                i.putExtra(Constants.Screen,Constants.OFFLINE_MULTI_PLAYER);
                startActivity(i);

            }
        });



    }
}