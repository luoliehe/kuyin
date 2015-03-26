package com.llh.musciapp.music;

import java.util.List;

/**
 * Created by Administrator on 2015/3/26
 */
public class Data {
    private String xcode;
    private List<SongDetail> songList;

    public String getXcode() {
        return xcode;
    }

    public void setXcode(String xcode) {
        this.xcode = xcode;
    }

    public List<SongDetail> getSongList() {
        return songList;
    }

    public void setSongList(List<SongDetail> songList) {
        this.songList = songList;
    }
}
