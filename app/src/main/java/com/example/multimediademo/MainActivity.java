package com.example.multimediademo;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b1,b2,b3;
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.cam);
        b2=findViewById(R.id.vid);
        b3=findViewById(R.id.aud);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Camera Activity Selected", Toast.LENGTH_SHORT).show();
                Intent camint=new Intent(MainActivity.this, CameraActivity.class);
                startActivity(camint);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Video Activity Selected", Toast.LENGTH_SHORT).show();
                Intent vidint=new Intent(MainActivity.this, VideoActivity.class);
                startActivity(vidint);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Audio Activity Selected", Toast.LENGTH_SHORT).show();
                Intent audint=new Intent(MainActivity.this, AudioActivity.class);
                startActivity(audint);
            }
        });
    }

}