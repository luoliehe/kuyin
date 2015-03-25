package com.llh.musciapp.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.llh.musciapp.common.util.FirefoxClient;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class FindMap3Service extends Service {
    public static final String TRG = "FindMap3Service";
    public FindMap3Service() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        new Thread(new Runnable() {

            @Override
            public void run() {
                String url = "http://box.zhangmen.baidu.com/x?op=12&count=1&title=大约在冬季$$齐秦$$$$";
                String res = FirefoxClient.get(url, null);
                Log.i(TRG, res);

            }
        }).start();
        return super.onStartCommand(intent, flags, startId);
    }

    private void parse(String xml){
        try {
            XmlPullParser parser = XmlPullParserFactory.newInstance().newPullParser();


        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }

    }
}
