package com.example.a.photogallerry;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;



import android.os.Bundle;

import com.example.a.photogallerry.api.FlickrAPI;
import com.example.a.photogallerry.api.ServiceAPI;
import com.example.a.photogallerry.model.Photo;
import com.example.a.photogallerry.model.PhotosResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoGallery extends AppCompatActivity {
    private final List<Photo> list_photo = new ArrayList<>();
    private final PhotoAdapter photoAdapter = new PhotoAdapter(list_photo);

    private final FlickrAPI flickrAPI = ServiceAPI.getRetrofit().create(FlickrAPI.class);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery_activity);

        final RecyclerView recyclerView  = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));

        flickrAPI.getRecent().enqueue(new Callback<PhotosResponse>() {
            @Override
            public void onResponse(Call<PhotosResponse> call, Response<PhotosResponse> response) {
                list_photo.addAll(response.body().getPhotos().getPhoto());
                photoAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<PhotosResponse> call, Throwable t) {
                AlertDialog alertDialog = new AlertDialog.Builder(PhotoGallery.this).create();
                alertDialog.setTitle("Info");
                alertDialog.setMessage("Something went wrong!");
                alertDialog.show();
            }
        });
        recyclerView.setAdapter(photoAdapter);


    }


}