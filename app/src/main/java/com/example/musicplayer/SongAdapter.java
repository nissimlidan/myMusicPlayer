package com.example.musicplayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.RequestManager;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {
    private Context context;
    private ArrayList<Song> songArrayList;

    public SongAdapter(Context context, ArrayList<Song> songArrayList) {
        this.context = context;
        this.songArrayList = songArrayList;
    }

    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.song_card, parent, false);
        return new SongViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return songArrayList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull SongViewHolder holder, int position) {
        Song currentSong = songArrayList.get(position);

        String songName = currentSong.songName;
        String singerName = currentSong.singer;
        String songTime = currentSong.songLength;
        String songImageUrl = currentSong.songImageUrl;
        RequestManager requestManager;
        ProgressBar progressBar;
        View parent;

        holder.songNameTv.setText(songName);
        holder.songLengthTv.setText(songTime);
        holder.singerNameTv.setText(singerName);
        Picasso.with(context).load(songImageUrl).fit().centerInside().into(holder.songImageUrl);
    }

    public class SongViewHolder extends RecyclerView.ViewHolder {

        public TextView songNameTv;
        public TextView singerNameTv;
        public TextView songLengthTv;
        public ImageView songImageUrl;

        public SongViewHolder(@NonNull View itemView) {
            super(itemView);
            songNameTv = itemView.findViewById(R.id.songName);
            singerNameTv = itemView.findViewById(R.id.singerName);
            songLengthTv = itemView.findViewById(R.id.songLength);
            songImageUrl = itemView.findViewById(R.id.songImageIv);
        }
    }

    public void onBind(Song songObject, RequestManager requestManager) {
        this.requestManager = requestManager;
        parent.setTag(this);
        title.setText(mediaObject.getTitle());
        this.requestManager
                .load(mediaObject.getThumbnail())
                .into(thumbnail);
    }
}
