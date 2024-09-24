package com.example.workshopregistration;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.view.animation.Animation;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView=findViewById(R.id.textView);
        TextView textViewDetails=findViewById(R.id.textViewDetails);

        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);

        textView.startAnimation(fadeIn);
        textViewDetails.startAnimation(fadeIn);

        new Handler().postDelayed(() ->{
            {
                Intent intent=new Intent(MainActivity.this,RegistrationActivity.class);
                startActivity(intent);
                finish();
            }

        },3000);

    }
}