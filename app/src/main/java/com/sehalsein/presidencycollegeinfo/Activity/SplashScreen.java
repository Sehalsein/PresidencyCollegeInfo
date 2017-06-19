package com.sehalsein.presidencycollegeinfo.Activity;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.sehalsein.presidencycollegeinfo.R;

public class SplashScreen extends AppCompatActivity {


    private PendingIntent pendingIntent;
    boolean myBoolean;
    public ImageView logo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        logo = (ImageView) findViewById(R.id.logo);
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                // Code here will run in UI thread

//                ObjectAnimator anim = (ObjectAnimator) AnimatorInflater.loadAnimator(SplashScreen.this, R.animator.flipping);
//                anim.setTarget(logo);
//                anim.setDuration(2000);
//                anim.start();
//
//                final Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.login_logo_heartbeat);
//                logo.startAnimation(animation);
            }
        });
        int myTimer = 2000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

               // Toast.makeText(SplashScreen.this,"DONE",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(i);
                finish();

            }
        }, myTimer);


    }
}
