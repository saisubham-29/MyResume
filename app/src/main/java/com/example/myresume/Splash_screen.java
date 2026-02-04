package com.example.myresume;

import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.auth.api.signin.GoogleSignIn;

public class Splash_screen extends AppCompatActivity {
TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        textView=findViewById(R.id.textViewSplashscreen);
        Animation rotateAnimation = AnimationUtils.loadAnimation(this,R.anim.rotate);
        textView.startAnimation(rotateAnimation);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (GoogleSignIn.getLastSignedInAccount(Splash_screen.this)!=null){
                    Intent intent = new Intent(Splash_screen.this, MainActivity.class);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(Splash_screen.this, SiginAcitvity.class);
                    startActivity(intent);
                }

            }
        },1000);
    }
}