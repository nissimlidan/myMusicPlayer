package com.example.musicplayer;

public class Song {

    String songImageUrl;
    String addressUrl;
    String songName;
    String songLength;
    String singer;

    public Song(String songImageUrl, String addressUrl, String songName, String songLength, String singer) {
        this.songImageUrl = songImageUrl;
        this.addressUrl = addressUrl;
        this.songName = songName;
        this.songLength = songLength;
        this.singer = singer;
    }

    public Song(String songImageUrl, String songName, String songLength, String singer) {
        this.songImageUrl = songImageUrl;
        this.songName = songName;
        this.songLength = songLength;
        this.singer = singer;
    }

    public String getSongImageUrl() {
        return songImageUrl;
    }

    public void setSongImageUrl(String songImageUrl) {
        this.songImageUrl = songImageUrl;
    }

    public String getAddressUrl() {
        return addressUrl;
    }

    public void setAddressUrl(String addressUrl) {
        this.addressUrl = addressUrl;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongLength() {
        return songLength;
    }

    public void setSongLength(String songLength) {
        this.songLength = songLength;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }
}

