package com.llh.musciapp.music;

import android.print.PageRange;
import android.util.JsonReader;

import com.llh.musciapp.common.util.FirefoxClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.xmlpull.v1.XmlPullParserException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/3/26
 */
public class MusicHelper {

    private MusicHelper(){
    }

    public void search(String keyWorld){
        //String url = "http://mp3.baidu.com/dev/api/?tn=getinfo&ct=0&word=&ie=utf-8&format=json";
        String url = "http://mp3.baidu.com/dev/api";
        Map<String, Object> params = new HashMap<>();
        params.put("word", keyWorld);
        params.put("tn", "getinfo");
        params.put("ct", 0);
        params.put("ie", "utf-8");
        params.put("format", "xml");
        InputStream in = null;
        try {
            in = FirefoxClient.get(url, params);
            List<ResEntity> list = new SearchParser().parser(in);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
    }

    public Song getSong(String songId) throws IOException, JSONException {
        String url = "http://ting.baidu.com/data/music/links";
        Map<String, Object> params = new HashMap<>();
        params.put("songIds", songId);
        InputStream in = FirefoxClient.get(url, params);
        StringBuilder builder = new StringBuilder();
        BufferedReader buff = new BufferedReader(new InputStreamReader(in));
        do{
            String str = buff.readLine();
            if(str==null){
                break;
            }
            builder.append(str);
        }while(true);
        JSONObject jsonObject = new JSONObject(builder.toString());
        Object obj = JSONObject.wrap(jsonObject);
        return  ((Song)obj);
    }
}
