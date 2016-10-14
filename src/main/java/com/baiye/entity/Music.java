package com.baiye.entity;

/**
 * Created by Baiye on 2016/10/10.
 */
public class Music {

    private String ID;

    private String Name;

    private String Artist;

    private String Album;

    private Long CommentCount;

    private String URL;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getArtist() {
        return Artist;
    }

    public void setArtist(String artist) {
        this.Artist = artist;
    }

    public String getAlbum() {
        return Album;
    }

    public void setAlbum(String album) {
        this.Album = album;
    }

    public Long getCommentCount() {
        return CommentCount;
    }

    public void setCommentCount(Long commentCount) {
        this.CommentCount = commentCount;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }



    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Name : " + this.getName() + "\t");
        sb.append("Artist : "+ this.getArtist() + "\t");
        sb.append("Album : " + this.getAlbum() + "\t");
        sb.append("CommentCount : " + this.getCommentCount() + "\t");
        sb.append("URL : " + this.getURL() + "\t");
        return sb.toString();
    }
}
