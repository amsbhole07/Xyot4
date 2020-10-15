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

public class OfflineSingleplyrMenuScreenActivity extends AppCompatActivity {
    private TextView textView;
    private TextView textView2;
    private ImageView imageView;
    private TextView txt_3by3;
    private TextView txt_4by4;
    private TextView txt_5by5;
    private TextView txtOfflineMultiplayer;
    private TextView txtAlreadyAccnt;

    private void assignViews() {
        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        imageView = (ImageView) findViewById(R.id.imageView);
        txt_3by3 = (TextView) findViewById(R.id.txt_online_play);
        txt_4by4 = (TextView) findViewById(R.id.txt_closed_room_play);
        txt_5by5 = (TextView) findViewById(R.id.txt_offline_single_player);
        txtOfflineMultiplayer = (TextView) findViewById(R.id.txt_offline_multiplayer);
        txtAlreadyAccnt = (TextView) findViewById(R.id.txt_already_accnt);
    }
    String lStrUserCode = "", lStrPassword = "",lStrScrenName="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_singleplyr_menu_screen);

        assignViews();
        if(getIntent()!=null)
        {
            lStrScrenName = this.getIntent().getStringExtra(Constants.Screen);
        }
        Glide.with(OfflineSingleplyrMenuScreenActivity.this).load(R.drawable.main_logo).into(imageView);


        txt_3by3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(OfflineSingleplyrMenuScreenActivity.this, OfflineSingleplyrEasyLevelMenuScreenActivity.class);
                i.putExtra(Constants.Screen,lStrScrenName);
                i.putExtra(Constants.Game_Play,"3");
                startActivity(i);

            }
        });

        txt_4by4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(OfflineSingleplyrMenuScreenActivity.this, OfflineSingleplyrEasyLevelMenuScreenActivity.class);
                i.putExtra(Constants.Screen,lStrScrenName);
                i.putExtra(Constants.Game_Play,"4");
                startActivity(i);

            }
        });

        txt_5by5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(OfflineSingleplyrMenuScreenActivity.this, OfflineSingleplyrEasyLevelMenuScreenActivity.class);
                i.putExtra(Constants.Screen,lStrScrenName);
                i.putExtra(Constants.Game_Play,"5");
                startActivity(i);

            }
        });


    }
}