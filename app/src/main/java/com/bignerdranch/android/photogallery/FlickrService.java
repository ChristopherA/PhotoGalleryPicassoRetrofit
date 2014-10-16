package com.bignerdranch.android.photogallery;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit.Callback;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Query;

public interface FlickrService {

    @GET(API.GET_RECENT)
    public void fetchItems(Callback<FlickrResponse> callback);

    @GET(API.GET_RECENT)
    public FlickrResponse fetchItems();

    @GET(API.SEARCH)
    public void search(@Query(API.PARAM_TEXT) String searchTerm, Callback<FlickrResponse> callback);

    @GET(API.SEARCH)
    public FlickrResponse search(@Query(API.PARAM_TEXT) String searchTerm);

    public static class API {
        private static final String ENDPOINT = "https://api.flickr.com";
        private static final String PATH_ROOT = "/services/rest?format=json&nojsoncallback=1&extras=url_s&method=";
        private static final String GET_RECENT = PATH_ROOT + "flickr.photos.getRecent";
        private static final String SEARCH = PATH_ROOT + "flickr.photos.search";
        private static final String PARAM_TEXT = "text";
        private static final String API_KEY = "41baa5dbced1f1cb39b01d34563e7d49";
    }

    public static class FlickrResponse {
        @SerializedName("photos")
        private Wrapper mWrapper;

        public List<GalleryItem> getPhotos() {
            return mWrapper.mPhotos;
        }

        private static class Wrapper {
            @SerializedName("photo")
            private List<GalleryItem> mPhotos;
        }
    }

    public static class Factory {
        public static FlickrService create() {
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint(FlickrService.API.ENDPOINT)
                    .setRequestInterceptor(new RequestInterceptor() {
                        @Override
                        public void intercept(RequestFacade request) {
                            request.addQueryParam("api_key", API.API_KEY);
                        }
                    })
                    .build();
            return restAdapter.create(FlickrService.class);
        }
    }
}
