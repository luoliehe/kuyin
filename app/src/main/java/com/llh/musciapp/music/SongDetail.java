package com.llh.musciapp.music;

/**
 * Created by Administrator on 2015/3/26
 */
public class SongDetail {
    private String queryId;
    private Long songId;
    private String songName;
    private String artistId;
    private String artistName;
    private Long albumId;
    private String albumName;
    private String songPicSmall;
    private String songPicBig;
    private String lrcLink;
    private String version;
    private Integer copyType;
    private Integer time;
    private Long linkCode;

    public String getQueryId() {

        return queryId;
    }

    public void setQueryId(String queryId) {
        this.queryId = queryId;
    }

    public Long getSongId() {
        return songId;
    }

    public void setSongId(Long songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtistId() {
        return artistId;
    }

    public void setArtistId(String artistId) {
        this.artistId = artistId;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getSongPicSmall() {
        return songPicSmall;
    }

    public void setSongPicSmall(String songPicSmall) {
        this.songPicSmall = songPicSmall;
    }

    public String getSongPicBig() {
        return songPicBig;
    }

    public void setSongPicBig(String songPicBig) {
        this.songPicBig = songPicBig;
    }

    public String getLrcLink() {
        return lrcLink;
    }

    public void setLrcLink(String lrcLink) {
        this.lrcLink = lrcLink;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Integer getCopyType() {
        return copyType;
    }

    public void setCopyType(Integer copyType) {
        this.copyType = copyType;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Long getLinkCode() {
        return linkCode;
    }

    public void setLinkCode(Long linkCode) {
        this.linkCode = linkCode;
    }
}
