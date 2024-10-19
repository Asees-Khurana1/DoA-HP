package com.example.doa;

public class Scheme {
    private String name;
    private int image;
    private String videoUrl;
    private String description;
    private String eligibilityContent;
    private String howToApplyContent;

    public Scheme(String name, int image, String videoUrl, String description,
                  String eligibilityContent, String howToApplyContent) {
        this.name = name;
        this.image = image;
        this.videoUrl = videoUrl;
        this.description = description;
        this.eligibilityContent = eligibilityContent;
        this.howToApplyContent = howToApplyContent;
    }

    public String getName() { return name; }
    public int getImage() { return image; }
    public String getVideoUrl() { return videoUrl; }
    public String getDescription() { return description; }
    public String getEligibilityContent() { return eligibilityContent; }
    public String getHowToApplyContent() { return howToApplyContent; }
}
