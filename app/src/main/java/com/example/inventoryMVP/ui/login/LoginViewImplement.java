package com.example.inventoryMVP.ui.login;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.inventoryMVP.DashboardActivity;
import com.example.inventoryMVP.R;
import com.example.inventoryMVP.ui.base.BaseActivity;

/**
 * @author Francisco Javier Aranda
 * @version 1.0
 */

public class LoginViewImplement extends BaseActivity implements LoginView {
    private TextView tvSignUp;
    private Button btnSignIn;
    private EditText etUser, etPassword;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginPresenter = new LoginPresenterImplement(this);
        setContentView(R.layout.activity_login);
        tvSignUp = (TextView)findViewById(R.id.tvSignUp);
        btnSignIn = (Button)findViewById(R.id.btnSignIn);
        etUser = (EditText)findViewById(R.id.etUser);
        etPassword = (EditText)findViewById(R.id.etPassword);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.validateCredentials(etUser.getText().toString(), etPassword.getText().toString());
            }
        });

    }

    @Override
    public void navigateToHome() {
        Intent intent = new Intent(LoginViewImplement.this, DashboardActivity.class);
        startActivity(intent);
    }

    @Override
    public void setUserEmptyError() {
        onError(R.string.errorUserEmpty);
    }

    @Override
    public void setPasswordEmptyError() {
        onError(R.string.errorPasswordEmpty);
    }

    @Override
    public void setPasswordError() {
        onError(R.string.errorPassword);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.onDestroy();
    }
}
