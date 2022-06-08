package com.example.datingapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class MatchesGridFragment extends Fragment {
String[] localDataSet;
List<Matches> matchesList = new ArrayList<>();

    public MatchesGridFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataSet();
    }

//    private void initDataSet(){
//        localDataSet = new String[10];
//        for(int i = 0; i < 10; i++){
//            localDataSet[i]= "Name # "+ i;
//        }
//    }
    private void initDataSet(){
        Matches m1 = new Matches("name1");
        Matches m2 = new Matches("name2");
        Matches m3 = new Matches("name3");
        Matches m4 = new Matches("name4");
        Matches m5 = new Matches("name5");
        Matches m6 = new Matches("name6");
        m1.setLiked(false);
        m2.setLiked(false);
        m3.setLiked(false);
        m4.setLiked(false);
        m5.setLiked(false);
        m6.setLiked(false);
        this.matchesList.add(m1);
        this.matchesList.add(m2);
        this.matchesList.add(m3);
        this.matchesList.add(m4);
        this.matchesList.add(m5);
        this.matchesList.add(m6);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_matches, container, false);

        //Set up recyclerView
        RecyclerView recyclerView = v.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false));
        MatchesCardRecyclerViewAdapter adapter = new MatchesCardRecyclerViewAdapter(matchesList);
        recyclerView.setAdapter(adapter);
        int largePadding = getResources().getDimensionPixelSize(R.dimen.grid_spacing);
        int smallPadding = getResources().getDimensionPixelSize(R.dimen.grid_spacing);
        return v;
    }
}