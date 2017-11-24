package com.example.inventoryMVP;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.inventoryMVP.ui.login.LoginViewImplement;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Francisco Javier Aranda
 * @version 1.1
 * Añadido temporizador.
 */

public class SplashActivity extends AppCompatActivity {

    private static final long DELAY = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent mainIntent = new Intent().setClass(
                        SplashActivity.this, LoginViewImplement.class);
                startActivity(mainIntent);
                finish();
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, DELAY);
    }
}
