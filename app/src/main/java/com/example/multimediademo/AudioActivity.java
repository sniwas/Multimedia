package com.example.multimediademo;

import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class AudioActivity extends AppCompatActivity {
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.audio_activity);
    }

    public void play(View v)
    {
        if(mp==null){
            mp=MediaPlayer.create(this,R.raw.song);
            mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopplayer();
                }
            });
        }
        mp.start();
    }
    public void pause(View v)
    {
        if(mp!=null)
        {
            mp.pause();
        }
        else {
            Toast.makeText(AudioActivity.this, "Audio is not playing", Toast.LENGTH_SHORT).show();
        }
    }
    public void stop(View v)
    {
        stopplayer();
    }
    private void stopplayer(){
        if(mp!=null){
            mp.release();
            mp=null;
            Toast.makeText(AudioActivity.this, "Media Player is released", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopplayer();
    }
}