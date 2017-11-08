package net.epictimes.chameleon.features.list;

import android.content.Context;
import android.support.annotation.Nullable;
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
import java.util.List;

public class PhotosRecyclerViewAdapter
        extends RecyclerView.Adapter<PhotosRecyclerViewAdapter.PhotoViewHolder> {
    private final List<Photo> photoList = new ArrayList<>();

    @Nullable
    private ClickListener clickListener;

    @Override
    public PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext())
                .inflate(PhotoViewHolder.LAYOUT_ID, parent, false);
        return new PhotoViewHolder(view, clickListener);
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

    public void setClickListener(@Nullable ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    interface ClickListener {

        void onRecyclerViewItemClicked(View view, int position);

    }

    static class PhotoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public static final int LAYOUT_ID = R.layout.row_photo;

        @Nullable
        private final ClickListener clickListener;

        private final ImageView imageViewUser;
        private final TextView textViewUserName;
        private final ImageView imageViewPhoto;
        private final TextView textViewPhotoName;

        PhotoViewHolder(View itemView, @Nullable ClickListener clickListener) {
            super(itemView);

            this.clickListener = clickListener;

            imageViewPhoto = itemView.findViewById(R.id.imageViewPhoto);
            imageViewUser = itemView.findViewById(R.id.imageViewUser);
            textViewUserName = itemView.findViewById(R.id.textViewUserName);
            textViewPhotoName = itemView.findViewById(R.id.textViewPhotoName);

            itemView.setOnClickListener(this);
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

        @Override
        public void onClick(View v) {
            if (clickListener != null) {
                final int adapterPosition = getAdapterPosition();

                if (adapterPosition != RecyclerView.NO_POSITION) {
                    clickListener.onRecyclerViewItemClicked(v, adapterPosition);
                }
            }
        }
    }

}
