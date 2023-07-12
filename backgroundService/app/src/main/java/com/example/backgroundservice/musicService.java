package com.example.backgroundservice;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.IOException;

public class musicService extends Service {

    MediaPlayer mp;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {


        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        try {
            mp= new MediaPlayer();
            mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
            try {
                mp.setDataSource("android.resource://"+getPackageName()+ R.raw.song1);
                mp.prepareAsync();
                mp.setOnPreparedListener(MediaPlayer::start);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Toast.makeText(this, "service started", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            e.printStackTrace();
        }
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        mp.stop();
        Toast.makeText(this, "service destroyed", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
}
