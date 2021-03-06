package com.example.a.photogallerry;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a.photogallerry.model.Photo;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter <PhotoAdapter.ViewHolder> {

    private OnClickListener onClickListener;
    private final List<Photo> list_photo;

    public PhotoAdapter(List<Photo> items){
        list_photo= items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_items, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Photo photo = list_photo.get(position);
        Picasso.get().load(photo.getUrlS()).into(holder.imageView);
        holder.itemView.setTag(photo);
        holder.image_name.setText(photo.getTitle());
    }

    @Override
    public int getItemCount() {
        return list_photo.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        final ImageView imageView;
        final TextView image_name;

        ViewHolder(View view ){
            super(view);
            imageView = view.findViewById(R.id.image);
            image_name = view.findViewById(R.id.image_name);
            imageView.setOnClickListener(v -> {
                onClickListener.onClickListener(list_photo.get(getAdapterPosition()));
            });
        }
    }


    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }


}
