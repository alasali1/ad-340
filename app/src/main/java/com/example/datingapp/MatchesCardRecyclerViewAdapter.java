package com.example.datingapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.function.Consumer;

public class MatchesCardRecyclerViewAdapter extends RecyclerView.Adapter<MatchesCardViewHolder> {
    private List<Matches> matchesList;
    private Consumer<Matches> onClickCallback;


    MatchesCardRecyclerViewAdapter(List<Matches> matchesList){
        this.matchesList = matchesList;
    }

    MatchesCardRecyclerViewAdapter(List<Matches> matchesList, Consumer<Matches> onClickCallback) {
        this.matchesList = matchesList;
        this.onClickCallback = onClickCallback;
    }

    @NonNull
    @Override
    public MatchesCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.match_card, parent, false);
        return new MatchesCardViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull MatchesCardViewHolder holder,  int position) {
        if (matchesList != null && position < matchesList.size()){
            Matches match = matchesList.get(position);
            holder.matchName.setText(match.getName());
            if(match.isLiked()){
                holder.likeButton.setImageResource((R.drawable.filled_heart_icon));
            }
            else {
                holder.likeButton.setImageResource(R.drawable.heart_icon);
            }
            holder.likeButton.setOnClickListener((view) -> {
                Toast.makeText(view.getContext(), "You liked " + match.getName(), Toast.LENGTH_LONG).show();
                onClickCallback.accept(match);
            });
        }
    }

    @Override
    public int getItemCount() {
        return matchesList.size();
    }
}
