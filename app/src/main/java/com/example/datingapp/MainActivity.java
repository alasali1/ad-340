package com.example.datingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    Button datePicker;
    Button submit;
    int mYear, mMonth, mDay;
    TextView dateText;
    EditText name;
    EditText email;
    EditText userName;
    EditText description;
    EditText occupation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datePicker = findViewById(R.id.dateButton);
        datePicker.setOnClickListener(this);
        dateText = findViewById(R.id.dateText);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        userName = findViewById(R.id.user_name);
        submit = findViewById(R.id.submitButton);
        description = findViewById(R.id.description);
        occupation = findViewById(R.id.occupation);

        submit.setOnClickListener(this);
        //Set date to todays date automatically
        Calendar today = Calendar.getInstance();
        dateText.setText(today.get(Calendar.DAY_OF_MONTH) + "-" + (today.get(Calendar.MONTH)+ 1) + "-" + today.get(Calendar.YEAR));
    }
    @Override
    public void onClick(View v) {
        //When the date button is clicked, display a calendar dialog
        if (v.getId() == R.id.dateButton) {
            final Calendar cal = Calendar.getInstance();
            mYear = cal.get(Calendar.YEAR);
            mMonth = cal.get(Calendar.MONTH);
            mDay = cal.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                    dateText.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                }
            }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
        //When submit button is clicked. Validate form data and go to next activity
        if (v.getId() == R.id.submitButton) {
            //Create intent for ProfileActivity
            Intent secondActivity = new Intent(MainActivity.this, SecondActivity.class);
            //Create a new bundle
            Bundle bundle = new Bundle();

            //Convert all input data to strings
            String stringName = name.getText().toString();
            String stringEmail = email.getText().toString();
            String stringUserName = userName.getText().toString();
            String stringDate = dateText.getText().toString();
            String stringDescription = description.getText().toString();
            String stringOccupation = occupation.getText().toString();

            try {   //If age/name/email/username is invalid or under 18 then return
                if ( !validateEmail() || !checkAge(convertDate(stringDate)) || !validateName() || !validateUserName() || !validateDescription() || !validateOccupation()) {
                    validateEmail();
                    validateName();
                    validateUserName();
                    validateDescription();
                    validateOccupation();
                    checkAge(convertDate(stringDate));
                    return;
                    //If age/name/username/email is valid then bundle data to send to ProfileActivity
                } else {
                    //get users age
                    int age = getAge(convertDate(stringDate));
                    //add data to bundle
                    bundle.putString("name", stringName);
                    bundle.putString("email", stringEmail);
                    bundle.putString("date", stringDate);
                    bundle.putString("userName", stringUserName);
                    bundle.putString("description",stringDescription);
                    bundle.putString("occupation",stringOccupation);
                    bundle.putInt("age", age);
                    //Start activity
                    secondActivity.putExtras(bundle);
                    startActivity(secondActivity);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }
    }

    public Calendar convertDate(String stringDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        Calendar date = Calendar.getInstance();
        date.setTime(sdf.parse(stringDate));
        return date;
    }

    public boolean checkAge(Calendar date){
        Calendar today = Calendar.getInstance();
        int checkYear = today.get(Calendar.YEAR) -18;
        int yob = date.get(Calendar.YEAR);
        int mob = date.get(Calendar.MONTH);
        int dob = date.get(Calendar.DAY_OF_MONTH);
         if(dateText.getText().toString().isEmpty()) {
             dateText.requestFocus();
            dateText.setError("Date cannot be empty");
            return false;
        } else if(yob > checkYear){
           dateText.requestFocus();
           dateText.setError("Too young");
           return false;
        } else if(mob > today.get(Calendar.MONTH)){
             dateText.requestFocus();
            dateText.setError("Too young");
            return false;
        } else if(dob > today.get(Calendar.DAY_OF_MONTH)){
             dateText.requestFocus();
            dateText.setError("Too young");
            return false;
        } else
        {   dateText.setError(null);
            return true;
        }

    }
    private boolean validateEmail(){
        String emailInput = email.getText().toString().trim();

        if(emailInput.isEmpty()){
            email.setError("Email can't be empty");
            return false;
        }else if(!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()){
            email.setError("Email invalid");
            return false;
        }else{
            email.setError(null);
            return true;
        }
    }

    private boolean validateName(){
        String nameInput = name.getText().toString().trim();

        if(nameInput.isEmpty()){
            name.setError("Name can't be empty");
            return false;
        }else{
            name.setError(null);
            return true;
        }
    }

    private boolean validateUserName(){
        String userNameInput = userName.getText().toString().trim();

        if(userNameInput.isEmpty()){
            userName.setError("Username can't be empty");
            return false;
        }else{
            userName.setError(null);
            return true;
        }
    }

    private boolean validateDescription(){
        String descriptionInput = description.getText().toString().trim();

        if(descriptionInput.isEmpty()){
            description.setError("Description can't be empty");
            return false;
        }else{
            description.setError(null);
            return true;
        }
    }

    private boolean validateOccupation(){
        String occupationInput = occupation.getText().toString().trim();

        if(occupationInput.isEmpty()){
             occupation.setError("Description can't be empty");
            return false;
        }else{
            occupation.setError(null);
            return true;
        }
    }

    public int getAge(Calendar dob){
        int age =0;
        Calendar today = Calendar.getInstance();

        if(today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)){
            age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR) - 1;
        }
        else{
            age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
        }
        return age;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState){
        super.onSaveInstanceState(outState);

        Log.i(TAG,"onSaveInstanceState()");
        outState.putString("date", dateText.getText().toString());
        outState.putString("name", name.getText().toString());
        outState.putString("email", email.getText().toString());
        outState.putString("userName", userName.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "onRestoreInstanceState()");

        if (savedInstanceState.containsKey("date")){
            dateText.setText(savedInstanceState.getString("date"));
        }

        if (savedInstanceState.containsKey("name")){
            name.setText(savedInstanceState.getString("name"));
        }

        if (savedInstanceState.containsKey("email")){
            email.setText(savedInstanceState.getString("email"));
        }

        if(savedInstanceState.containsKey("userName")){
            userName.setText(savedInstanceState.getString("userName"));
        }
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i(TAG, "onStart()");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i(TAG, "onResume()");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i(TAG, "onPause()");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i(TAG, "onStop()");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }
}