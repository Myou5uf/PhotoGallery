package com.example.a.photogallerry;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a.photogallerry.model.Photo;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter <PhotoAdapter.ViewHolder> {

    private View.OnLongClickListener onLongClickListener;
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
    }

    @Override
    public int getItemCount() {
        return list_photo.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        final ImageView imageView;

        ViewHolder(View view ){
            super(view);
            imageView = view.findViewById(R.id.image);
            /*imageView.setOnLongClickListener(v -> {
                onLongClickListener.onLongClickListener(photo.get(getAdapterPosition()));
                return true;
            });*/
        }


    }


}
