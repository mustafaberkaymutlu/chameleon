package net.epictimes.chameleon.features.list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import net.epictimes.chameleon.R;
import net.epictimes.chameleon.data.model.Photo;
import net.epictimes.chameleon.util.GlideApp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PhotosRecyclerViewAdapter extends RecyclerView.Adapter<PhotosRecyclerViewAdapter.PhotoViewHolder> {
    private final List<Photo> photoList = new ArrayList<>();

    @Override
    public PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext())
                .inflate(PhotoViewHolder.LAYOUT_ID, parent, false);
        return new PhotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PhotoViewHolder holder, int position) {
        final Photo photo = photoList.get(position);
        holder.bindTo(photo);
    }

    @Override
    public int getItemCount() {
        return photoList.size();
    }

    public List<Photo> getPhotoList() {
        return photoList;
    }

    public void addAll(Collection<Photo> photoList) {
        this.photoList.addAll(photoList);
    }

    static class PhotoViewHolder extends RecyclerView.ViewHolder {
        public static final int LAYOUT_ID = R.layout.row_photo;

        private ImageView imageViewUser;
        private TextView textViewUserName;
        private ImageView imageViewPhoto;
        private TextView textViewPhotoName;

        PhotoViewHolder(View itemView) {
            super(itemView);

            imageViewUser = itemView.findViewById(R.id.imageViewUser);
            textViewUserName = itemView.findViewById(R.id.textViewUserName);
            imageViewPhoto = itemView.findViewById(R.id.imageViewPhoto);
            textViewPhotoName = itemView.findViewById(R.id.textViewPhotoName);
        }

        void bindTo(Photo photo) {
            final Context context = imageViewUser.getContext();

            GlideApp.with(context)
                    .load(photo.getUser().getUserPicUrl())
                    .into(imageViewUser);

            GlideApp.with(context)
                    .load(photo.getImageUrl())
                    .into(imageViewPhoto);

            textViewUserName.setText(photo.getUser().getFullName());
            textViewPhotoName.setText(photo.getName());
        }

    }

}
