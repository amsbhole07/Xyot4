package com.xyot4.game.Ui;


import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.xyot4.game.R;

public class ThreeByThreePlayBoradActivity extends HeaderActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_three_by_three_play_borad);
        setHeader("",true,true);
    }
}