package com.xyot4.game.Ui;


import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.google.android.gms.common.data.DataHolder;
import com.xyot4.game.R;

public class HeaderActivity extends AppCompatActivity {
    private LayoutInflater inflater;
    private PopupWindow pw;
    private View popupView;
    private ImageView img;

    public ProgressDialog barProgressDialog;
    public String gStrDateTimePickerValue = "";
    Handler updateBarHandler;
    String ScrnTabCall;
    private DataHolder session;
    String lStrApiLink;
    Typeface FontMedium, FontSemiBold;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_header);
        inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        updateBarHandler = new Handler();

    }

    public void setHeader(String title, boolean btnHomeVisible,
                          boolean btnFeedbackVisible) {
        ViewStub stub = (ViewStub) findViewById(R.id.vsHeader);
        View inflated = stub.inflate();

        TextView txtTitle = (TextView) inflated.findViewById(R.id.txtHeading);
        txtTitle.setText(title);
        txtTitle.setTypeface(FontSemiBold);

        TextView btnHome = (TextView) inflated.findViewById(R.id.txt_Home);

        if (!btnHomeVisible)
            btnHome.setVisibility(View.INVISIBLE);

        ImageView btnFeedback = (ImageView) inflated
                .findViewById(R.id.img_Overflow);


        if (!btnFeedbackVisible)
            btnFeedback.setVisibility(View.INVISIBLE);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();

            }
        });

        btnFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(getIntent());

            }
        });


    }

}