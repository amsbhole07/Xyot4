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

public class LoginActivity extends AppCompatActivity {


    private TextView textView;
    private TextView textView2;
    private ImageView imageView;
    private EditText edtUsername;
    private EditText edtPassword;
    private TextView txtLogin;
    private TextView txtForgotPassword;
    private TextView txtAlreadyAccount;
    private TextView txtRegister;

    private void assignViews() {
        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        imageView = (ImageView) findViewById(R.id.imageView);
        edtUsername = (EditText) findViewById(R.id.edt_username);
        edtPassword = (EditText) findViewById(R.id.edt_password);
        txtLogin = (TextView) findViewById(R.id.txt_login);
        txtForgotPassword = (TextView) findViewById(R.id.txt_forgot_password);
        txtAlreadyAccount = (TextView) findViewById(R.id.txt_already_account);
        txtRegister = (TextView) findViewById(R.id.txt_register);
    }

    String lStrUserCode = "", lStrPassword = "",lStrScrenName="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        assignViews();

        if(getIntent()!=null)
        {
            lStrScrenName = this.getIntent().getStringExtra(Constants.Screen);
        }

        Glide.with(LoginActivity.this).load(R.drawable.main_logo).into(imageView);

        txtAlreadyAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, RegistrationActivity.class);
                i.putExtra(Constants.Screen,lStrScrenName);
                startActivity(i);

            }
        });

        txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, RegistrationActivity.class);
                i.putExtra(Constants.Screen,lStrScrenName);
                startActivity(i);

            }
        });



        edtPassword.setTransformationMethod(new AsteriskPasswordTransformationMethod());

        txtLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                edtUsername.setError(null);
                edtPassword.setError(null);

                lStrUserCode = edtUsername.getText().toString();
                lStrPassword = edtPassword.getText().toString();

                if (lStrUserCode.equalsIgnoreCase("")) {
                    edtUsername.setError("Enter UserName");
                } else if (lStrPassword.equalsIgnoreCase("")) {
                    edtUsername.setError(null);
                    edtPassword.setError("Enter Password");
                } else {
                    edtPassword.setError(null);
                    if (new InternetDialog(LoginActivity.this).getInternetStatus()) {
                        Intent i = new Intent(LoginActivity.this, DashboardActivity.class);
                        startActivity(i);
                        finish();
                        Toast.makeText(getApplicationContext(), getResources().getString(R.string.welcome), Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });
    }
}