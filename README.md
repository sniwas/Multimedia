# Multimedia
AIM:
	To develop an android application that uses camera, audio and video controls.

CODE:
Activity_main.xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:layout_margin="10dp"
    tools:context=".MainActivity">

    <Button
        android:id="@+id/aud"
        android:layout_width="200dp"
        android:layout_height="50dp"
        android:text="Audio Activity"
        android:textSize="20sp"
        app:layout_constraintBottom_toTopOf="@+id/vid"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.5"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/cam"
        app:layout_constraintVertical_bias="0.5" />

    <Button
        android:id="@+id/vid"
        android:layout_width="200dp"
        android:layout_height="50dp"
        android:text="Video Activity"
        android:textSize="20sp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.5"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/aud"
        app:layout_constraintVertical_bias="0.5" />

    <Button
        android:id="@+id/cam"
        android:layout_width="200dp"
        android:layout_height="50dp"
        android:text="Camera Activity"
        android:textSize="20sp"
        app:layout_constraintBottom_toTopOf="@+id/aud"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.5"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.5" />
</androidx.constraintlayout.widget.ConstraintLayout>

MainActivity.java
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
 

camera_activity.xml:
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".CameraActivity">

    <TextView
        android:id="@+id/textView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Click on Camera Button to start Camera"
        android:layout_centerHorizontal="true"
        android:textSize="20sp" />
    <Button
        android:id="@+id/button"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Camera"
        android:layout_below="@+id/textView"
        android:layout_centerHorizontal="true"/>

    <ImageView
        android:id="@+id/imageView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_below="@+id/button"
        />


</RelativeLayout>

CameraActivity.java:
package com.example.multimediademo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class CameraActivity extends AppCompatActivity {
    Button b;
    private static final int REQUEST_CODE=1;//Any number above 0
    ImageView iv;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera_activity);
        b=findViewById(R.id.button);
        iv=findViewById(R.id.imageView);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,REQUEST_CODE);

            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if((requestCode==REQUEST_CODE)&&(resultCode==RESULT_OK))
        {
            Bitmap photo=(Bitmap) data.getExtras().get("data");
            //gets the thumbnail of the image
            iv.setImageBitmap(photo);
        }
        else {
            Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show();
        }
        super.onActivityResult(requestCode, resultCode, data);

    }
}

audio_activity.xml:
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".AudioActivity">

    <TextView
        android:id="@+id/textView2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Audio Controller"
        android:textSize="34sp"
        app:layout_constraintBottom_toTopOf="@+id/bplay"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.5"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.5"
        />

    <Button
        android:id="@+id/bplay"
        android:layout_width="200dp"
        android:layout_height="wrap_content"
        android:text="Play"
        android:textSize="20sp"
        app:layout_constraintBottom_toTopOf="@+id/bpause"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.5"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/textView2"
        app:layout_constraintVertical_bias="0.5"
        android:onClick="play"/>

    <Button
        android:id="@+id/bpause"
        android:layout_width="200dp"
        android:layout_height="wrap_content"
        android:text="Pause"
        android:textSize="20sp"
        app:layout_constraintBottom_toTopOf="@+id/bstop"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.5"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/bplay"
        app:layout_constraintVertical_bias="0.5"
        android:onClick="pause"/>

    <Button
        android:id="@+id/bstop"
        android:layout_width="200dp"
        android:layout_height="wrap_content"
        android:text="Stop"
        android:textSize="20sp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.5"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/bpause"
        app:layout_constraintVertical_bias="0.5"
        android:onClick="stop"/>
</androidx.constraintlayout.widget.ConstraintLayout>

AudioActivity.java :
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

video_activity.xml:
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".VideoActivity">

    <VideoView
        android:id="@+id/videoView"
        android:layout_width="match_parent"
        android:layout_height="400dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.5"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/textView3"
        app:layout_constraintVertical_bias="0.5" />

    <TextView
        android:id="@+id/textView3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Video Controller"
        android:textSize="34sp"
        app:layout_constraintBottom_toTopOf="@+id/videoView"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.5"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.5" />
</androidx.constraintlayout.widget.ConstraintLayout>


VideoActivity.java :
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


 
Output:
1.MainActivity.java
![Screenshot (10)](https://user-images.githubusercontent.com/122344020/233141448-0f3ffe51-8358-43bc-8bf5-5349024002d5.png)

2.CameraActivity.java
![Screenshot (11)](https://user-images.githubusercontent.com/122344020/233141499-fd9441f0-9bfc-4d82-a73e-6edd09e607ee.png)

3. On clicking camera button and after capturing image
![Screenshot (12)](https://user-images.githubusercontent.com/122344020/233141529-b00ee225-ce24-4dd8-9802-8f2e3941601d.png)

4. AudioActivity.java
![Screenshot (13)](https://user-images.githubusercontent.com/122344020/233141552-0e1fe31b-aed2-4093-9ee7-1904cd4b03fc.png)

5.VideoActivity.java
![Screenshot (14)](https://user-images.githubusercontent.com/122344020/233141572-f90b056b-0755-48fa-88a6-5e6caba6f068.png)

 
Result:
Thus, the application use camera, audio and video controls has been build and executed successfully. 
