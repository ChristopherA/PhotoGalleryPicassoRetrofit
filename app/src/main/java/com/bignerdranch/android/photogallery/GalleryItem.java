package com.bignerdranch.android.photogallery;

import com.google.gson.annotations.SerializedName;

public class GalleryItem {
    @SerializedName("title")
    private String mCaption;
    @SerializedName("id")
    private String mId;
    @SerializedName("url_s")
    private String mUrl;
    @SerializedName("owner")
    private String mOwner;
    
    public String getCaption() {
        return mCaption;
    }
    public void setCaption(String caption) {
        mCaption = caption;
    }
    public String getId() {
        return mId;
    }
    public void setId(String id) {
        mId = id;
    }
    
    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public String getOwner() {
        return mOwner;
    }

    public void setOwner(String owner) {
        mOwner = owner;
    }
    
    public String getPhotoPageUrl() {
        return "http://www.flickr.com/photos/" + mOwner + "/" + mId;
    }

    public String toString() {
        return mCaption;
    }

}
