package com.example.task1.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Photos {

    @SerializedName("photos")
    private PhotosData photos;
    private String stat;

    public PhotosData getPhotosData() {
        return photos;
    }

    public void setPhotosData(PhotosData photosData) {
        this.photos = photosData;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

}
