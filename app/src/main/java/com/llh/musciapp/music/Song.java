package com.llh.musciapp.music;

import java.util.List;

/**
 * Created by Administrator on 2015/3/26
 */
public class Song {
    private Long errorCode;
    private Data data;

    public Long getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Long errorCode) {
        this.errorCode = errorCode;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}