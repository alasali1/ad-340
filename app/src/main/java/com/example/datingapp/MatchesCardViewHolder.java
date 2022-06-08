package com.example.datingapp;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.annotation.NonNull;

public class MatchesCardViewHolder extends RecyclerView.ViewHolder {

    public ImageView matchImage;
    public TextView matchName;
    public TextView matchDescription;
    public ImageButton likeButton;

    public MatchesCardViewHolder(@NonNull View itemView){
        super(itemView);
        matchImage = itemView.findViewById(R.id.match_profile_pic);
        matchName = itemView.findViewById(R.id.match_name);
        matchDescription = itemView.findViewById(R.id.match_description);
        likeButton = itemView.findViewById(R.id.like_button);
    }
}
