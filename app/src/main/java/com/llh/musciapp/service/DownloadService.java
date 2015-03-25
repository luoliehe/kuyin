package com.llh.musciapp.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * 下载MP3文件service
 */
public class DownloadService extends Service {
    public DownloadService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
