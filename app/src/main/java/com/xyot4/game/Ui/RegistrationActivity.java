package com.xyot4.game.Ui;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.xyot4.game.Constants.Constants;
import com.xyot4.game.InternetDialog.InternetDialog;
import com.xyot4.game.PasswordTransformation.AsteriskPasswordTransformationMethod;
import com.xyot4.game.R;

public class RegistrationActivity extends AppCompatActivity {
    private TextView textView;
    private TextView textView2;
    private ImageView imageView;
    private EditText edtUsername;
    private EditText edtPassword;
    private EditText edtEmail;
    private EditText edtPhone;
    private TextView txtRegister;
    private TextView txtAlreadyAccnt;

    private void assignViews() {
        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        imageView = (ImageView) findViewById(R.id.imageView);
        edtUsername = (EditText) findViewById(R.id.edt_username);
        edtPassword = (EditText) findViewById(R.id.edt_password);
        edtEmail = (EditText) findViewById(R.id.edt_email);
        edtPhone = (EditText) findViewById(R.id.edt_phone);
        txtRegister = (TextView) findViewById(R.id.txt_register);
        txtAlreadyAccnt = (TextView) findViewById(R.id.txt_already_accnt);
    }
    String lStrUserCode = "", lStrPassword = "",lStrEmail = "", lStrPhone = "",lStrScrenName="";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_registration);

        assignViews();
        if(getIntent()!=null)
        {
            lStrScrenName = this.getIntent().getStringExtra(Constants.Screen);
        }
        Glide.with(RegistrationActivity.this).load(R.drawable.main_logo).into(imageView);

        txtAlreadyAccnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegistrationActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        });


        edtPassword.setTransformationMethod(new AsteriskPasswordTransformationMethod());

        txtRegister.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                edtUsername.setError(null);
                edtPassword.setError(null);
                edtEmail.setError(null);
                edtPhone.setError(null);

                lStrUserCode = edtUsername.getText().toString();
                lStrPassword = edtPassword.getText().toString();

                lStrEmail = edtEmail.getText().toString();
                lStrPhone = edtPhone.getText().toString();

                if (lStrUserCode.equalsIgnoreCase("")) {
                    edtUsername.setError("Enter UserName");
                } else if (lStrPassword.equalsIgnoreCase("")) {
                    edtUsername.setError(null);
                    edtPassword.setError("Enter Password");
                } else if (lStrEmail.equalsIgnoreCase("")) {
                    edtPassword.setError(null);
                    edtEmail.setError("Enter Email");
                } else if (lStrPhone.equalsIgnoreCase("")) {
                    edtEmail.setError(null);
                    edtPhone.setError("Enter Phone no");
                } else
                {
                    edtPassword.setError(null);
                    if (new InternetDialog(RegistrationActivity.this).getInternetStatus())
                    {
                        edtUsername.setError(null);
                        edtPassword.setError(null);
                        edtEmail.setError(null);
                        edtPhone.setError(null);
                        Intent i = new Intent(RegistrationActivity.this, DashboardActivity.class);
                        i.putExtra(Constants.Screen,lStrScrenName);
                        startActivity(i);
                        finish();
                        Toast.makeText(getApplicationContext(), getResources().getString(R.string.welcome), Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });
    }
}