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
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class SecondActivity extends AppCompatActivity {
    static ProfileFragment profileFragment;
private TabLayout tabLayout;
private ViewPager2 viewPager2;
private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //toolbar
        toolbar = findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        //tablayout
        tabLayout = findViewById(R.id.tablayout);

        //viewpager
        viewPager2 = findViewById(R.id.viewpager2);
        viewPager2.setAdapter(createAdapter());

        //tablayout mediator to join viewpager and tabs together
        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if(position == 0)
                    tab.setText("Profile");
                else if(position == 1)
                    tab.setText("Matches");
                else
                    tab.setText("Settings");
            }
        }).attach();

        //create profilefragment
        profileFragment = new ProfileFragment();

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

            //prepare arguments for fragment
                Bundle arguments = new Bundle();
                arguments.putString("date", stringDate);
                arguments.putString("name", stringName);
                arguments.putString("email", stringEmail);
                arguments.putString("userName", stringUserName);
                arguments.putString("description", stringDescription);
                arguments.putString("occupation", stringOccupation);
                arguments.putInt("age", userAge);

                //set arguments
            profileFragment.setArguments(arguments);
            }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.profile_item:
                viewPager2.setCurrentItem(0);
                return true;

            case R.id.matches_item:
                viewPager2.setCurrentItem(1);
                return true;

            case R.id.settings_item:
                viewPager2.setCurrentItem(2);
                return true;

            default:
                return super.onOptionsItemSelected(item);
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
    private static int NUM_ITEMS = 3;
    @Override
    public Fragment createFragment(int position){
        Fragment fragment = null;

        switch(position){
            case 0:
                fragment = SecondActivity.profileFragment;
                break;
            case 1:
                fragment = new MatchesFragment();
                break;
            case 2:
                fragment = new SettingsFragment();
                break;
        }
        return fragment;
    }
    @Override
    public int getItemCount() {
        return NUM_ITEMS;
    }
}