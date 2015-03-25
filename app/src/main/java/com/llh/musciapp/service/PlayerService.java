package com.llh.musciapp.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.IBinder;

import com.llh.musciapp.MusicApplication;

import java.io.IOException;

/**
 * 播放MP3的Service
 */
public class PlayerService extends Service {
    public static final String MUSIC_NAME = "music_name";
    private MediaPlayer player = new MediaPlayer();
    public PlayerService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        return super.onStartCommand(intent, flags, startId);
    }
}
