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

public class OfflineSingleplyrEasyLevelMenuScreenActivity extends AppCompatActivity {
    private TextView textView;
    private TextView textView2;
    private ImageView imageView;
    private TextView txt_offline_EASY_Mode;
    private TextView txt_offline_MEDIUM_Mode;
    private TextView txt_offline_HARD_Mode;
    private TextView txtOfflineMultiplayer;
    private TextView txtAlreadyAccnt;

    private void assignViews() {
        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        imageView = (ImageView) findViewById(R.id.imageView);
        txt_offline_EASY_Mode = (TextView) findViewById(R.id.txt_online_play);
        txt_offline_MEDIUM_Mode = (TextView) findViewById(R.id.txt_closed_room_play);
        txt_offline_HARD_Mode = (TextView) findViewById(R.id.txt_offline_single_player);
        txtOfflineMultiplayer = (TextView) findViewById(R.id.txt_offline_multiplayer);
        txtAlreadyAccnt = (TextView) findViewById(R.id.txt_already_accnt);
    }
    String lStrUserCode = "", lStrGame_Player = "",lStrScrenName="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_offline_singleplyr_easy_level_menu_screen);
        assignViews();
        if(getIntent()!=null)
        {
            lStrScrenName = this.getIntent().getStringExtra(Constants.Screen);
            lStrGame_Player= this.getIntent().getStringExtra(Constants.Game_Play);
        }
        Glide.with(OfflineSingleplyrEasyLevelMenuScreenActivity.this).load(R.drawable.main_logo).into(imageView);

        txt_offline_EASY_Mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(OfflineSingleplyrEasyLevelMenuScreenActivity.this, ThreeByThreePlayBoradActivity.class);
                i.putExtra(Constants.Screen,lStrScrenName);
                i.putExtra(Constants.Game_Play,lStrGame_Player);
                i.putExtra(Constants.Game_play_Mode,Constants.EASY);
                startActivity(i);

            }
        });

        txt_offline_MEDIUM_Mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(OfflineSingleplyrEasyLevelMenuScreenActivity.this, ThreeByThreePlayBoradActivity.class);
                i.putExtra(Constants.Screen,lStrScrenName);
                i.putExtra(Constants.Game_Play,lStrGame_Player);
                i.putExtra(Constants.Game_play_Mode,Constants.MEDIUM);
                startActivity(i);

            }
        });

        txt_offline_HARD_Mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(OfflineSingleplyrEasyLevelMenuScreenActivity.this, ThreeByThreePlayBoradActivity.class);
                i.putExtra(Constants.Screen,lStrScrenName);
                i.putExtra(Constants.Game_Play,lStrGame_Player);
                i.putExtra(Constants.Game_play_Mode,Constants.HARD);
                startActivity(i);

            }
        });


    }
}