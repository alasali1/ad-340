package com.example.datingapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {
    TextView welcome;
    TextView name;
    TextView age;
    TextView description;
    TextView occupation;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
   public static ProfileFragment newInstance(String date, String name, String email, String userName, String description, String occupation, int age) {
       ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString("date", date);
        args.putString("name",name);
       args.putString("email",email);
       args.putString("userName",userName);
       args.putString("description",description);
       args.putString("occupation",occupation);
       args.putInt("age",age);
       fragment.setArguments(args);
       return fragment;

   }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_profile, container, false);

        //Receive data from secondActivity through getArguments

        String mStringDate = getArguments().getString("date");
        String mStringName = getArguments().getString("name");
        String mStringEmail = getArguments().getString("email");
        String mStringUserName = getArguments().getString("userName");
        String mStringDescription = getArguments().getString("description");
        String mStringOccupation = getArguments().getString("occupation");
        int mUserAge = getArguments().getInt("age");

        welcome = v.findViewById(R.id.welcome);
        name = v.findViewById(R.id.user_name);
        age = v.findViewById(R.id.age);
        description = v.findViewById(R.id.description);
        occupation = v.findViewById(R.id.occupation);


        //set username in welcome message.
        welcome.setText("Welcome " + mStringUserName);

        //set username, age, description, and job into the profile fields
        name.append(mStringUserName);
        age.append(String.valueOf(mUserAge));
        description.append(mStringDescription);
        occupation.append(mStringOccupation);

        // Inflate the layout for this fragment
        return v;
    }

    @Override
    public void onViewCreated(View view,  Bundle savedInstanceState){



    }
}