package com.llh.musciapp.music;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/3/26
 */
public class SearchParser {

    public List<ResEntity> parser(InputStream in) throws XmlPullParserException, IOException {
        XmlPullParser parser = XmlPullParserFactory.newInstance().newPullParser();
        parser.setInput(in, "UTF-8");
        int eventType = parser.getEventType();
        List<ResEntity> list = null;
        ResEntity res = null;
        while(eventType != XmlPullParser.END_DOCUMENT){
            String nodeName = parser.getName();
            switch (eventType){
                case XmlPullParser.START_DOCUMENT:
                    list = new ArrayList<>();
                    break;
                case XmlPullParser.START_TAG:
                    if("res".equals(nodeName)){
                        res = new ResEntity();
                     }else if("song".equals(nodeName)){
                         res.setSong(parser.nextText());
                     }else if("song_id".equals(nodeName)){
                         res.setSongId(parser.nextText());
                     }else if("singer".equals(nodeName)){
                         res.setSinger(parser.nextText());
                     }else if("album".equals(nodeName)){
                         res.setAlbum(parser.nextText());
                     }else if("singerPicLarge".equals(nodeName)){
                         res.setSingerPicLarger(parser.nextText());
                     }else if("singerPicSmall".equals(nodeName)) {
                         res.setSingerPicSmall(parser.nextText());
                     }else if ("albumPicLarger".equals(nodeName)) {
                         res.setAlbumPicLarger(parser.nextText());
                     }else if("albumPicSmall".equals(nodeName)){
                         res.setAlbumPicSmall(parser.nextText());
                     }
                    break;
                case XmlPullParser.END_TAG:
                     if("res".equals(nodeName)){
                         list.add(res);
                     }
                eventType = parser.next();
            }
        }
        return list;
    }
}
