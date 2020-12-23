package com.example.a.photogallerry.api;


import com.example.a.photogallerry.model.PhotosResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FlickrAPI {
    @GET("services/rest/?method=flickr.photos.getRecent&api_key=da64483446c78357e40c0136c4e68eb6&extras=url_s&format=json&nojsoncallback=1")
    Call<PhotosResponse> getRecent();
    @GET("services/rest/?method=flickr.photos.search&api_key=da64483446c78357e40c0136c4e68eb6&extras=url_s&format=json&nojsoncallback=1")
    Call<PhotosResponse> getSearchPhotos(@Query("text") String keyWord);

}