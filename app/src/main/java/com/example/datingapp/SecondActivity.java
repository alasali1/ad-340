package com.example.datingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class SecondActivity extends AppCompatActivity {
private TabLayout tabLayout;
private ViewPager2 viewPager2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tabLayout = findViewById(R.id.tablayout);
        viewPager2 = findViewById(R.id.viewpager2);

        viewPager2.setAdapter(createAdapter());

        //create profilefragment
        ProfileFragment profileFragment = new ProfileFragment();

        //get bundle from MainActivity
            Bundle bundle = getIntent().getExtras();
            if(bundle != null) {
            String stringDate = bundle.getString("date");
            String stringName = bundle.getString("name");
            String stringEmail = bundle.getString("email");
            String stringUserName = bundle.getString("userName");
            String stringDescription = bundle.getString("description");
            String stringOccupation = bundle.getString("occupation");
            int userAge = bundle.getInt("age");

            //set arguments
            profileFragment.setArguments(bundle);
        }
    }

    private VpAdapter createAdapter(){
        VpAdapter adapter = new VpAdapter(this);
        return adapter;
    }
}

class VpAdapter extends FragmentStateAdapter {
    public VpAdapter(FragmentActivity fa){
        super(fa);
    }
    private static int NUM_ITEMS = 1;
    @Override
    public Fragment createFragment(int position){
        Fragment fragment = null;

        switch(position){
            case 0:
                fragment = new ProfileFragment();
                break;
        }
        return fragment;
    }
    @Override
    public int getItemCount() {
        return NUM_ITEMS;
    }
}