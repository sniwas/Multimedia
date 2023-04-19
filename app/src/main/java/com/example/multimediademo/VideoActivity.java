package com.example.multimediademo;

import androidx.appcompat.app.AppCompatActivity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;
public class VideoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_activity);
        VideoView vv=findViewById(R.id.videoView);
        String videopath="android.resource://"+getPackageName()+"/"+R.raw.video;
        Uri uri=Uri.parse(videopath);
        vv.setVideoURI(uri);
        MediaController mc=new MediaController(this);
        vv.setMediaController(mc);
        mc.setAnchorView(vv);
    }
}