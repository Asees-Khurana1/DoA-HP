package com.example.doa;

public class Scheme {
    private final String name;
    private final int thumbnail;
    private final int gifPlaceholder;
    private final String videoUrl;
    private final String content;

    public Scheme(String name, int thumbnail, int gifPlaceholder, String videoUrl, String content) {
        this.name = name;
        this.thumbnail = thumbnail;
        this.gifPlaceholder = gifPlaceholder;
        this.videoUrl = videoUrl;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public int getGifPlaceholder() {
        return gifPlaceholder;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public String getContent() {
        return content;
    }
}
