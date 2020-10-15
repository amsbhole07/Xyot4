package com.xyot4.game.Ui;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.xyot4.game.R;

public class SplashScreenActivity extends AppCompatActivity {
    ImageView imageView;
    private static int SPLASH_TIME_OUT = 2300;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        imageView=(ImageView)findViewById(R.id.splash);

       Glide.with(SplashScreenActivity.this).load(R.drawable.game_loader).into(imageView);

      new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                //Intent i = new Intent(SplashScreenActivity.this, com.monish.mepl.pressshopplanning.Ui.UiTestActivity.class);
                Intent i = new Intent(SplashScreenActivity.this, DashboardActivity.class);

                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);

    }
}