package com.example.datingapp;

import android.widget.DatePicker;

import androidx.test.espresso.contrib.PickerActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.action.ViewActions.typeText;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static androidx.test.espresso.Espresso.onView;
import static org.junit.Assert.*;
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityTestRule = new ActivityScenarioRule<>(MainActivity.class);


    @Test
    public void checkName(){
        onView(withId(R.id.email)).perform(replaceText("test@gmail.com"));
        onView(withId(R.id.user_name)).perform(replaceText("alasali"));
        onView(withId(R.id.description)).perform(replaceText("This is a test"));
        onView(withId(R.id.occupation)).perform(replaceText("I work at test"));


        onView(withId(R.id.dateButton)).perform(click());

        onView(withClassName(Matchers.equalTo(DatePicker.class.getName())))
                .perform(PickerActions.setDate(2000, 2 + 1, 5));

        onView(withId(android.R.id.button1)).perform(click());

        onView(withId(R.id.submitButton)).perform(click());

        onView(withId(R.id.name)).check(matches(withText("")));
    }

    @Test
    public void checkEmail(){
        onView(withId(R.id.user_name)).perform(replaceText("alasali"));
        onView(withId(R.id.name)).perform(replaceText("Alas Ali"));
        onView(withId(R.id.description)).perform(replaceText("This is a test"));
        onView(withId(R.id.occupation)).perform(replaceText("I work at test"));

        onView(withId(R.id.dateButton)).perform(click());

        onView(withClassName(Matchers.equalTo(DatePicker.class.getName())))
                .perform(PickerActions.setDate(2000, 2 + 1, 5));

        onView(withId(android.R.id.button1)).perform(click());

        onView(withId(R.id.submitButton)).perform(click());

        onView(withText("test@gmail.com")).check(doesNotExist());
    }

    @Test
    public void checkUserName(){
        onView(withId(R.id.email)).perform(replaceText("test@gmail.com"));
        onView(withId(R.id.name)).perform(replaceText("Alas Ali"));
        onView(withId(R.id.description)).perform(replaceText("This is a test"));
        onView(withId(R.id.occupation)).perform(replaceText("I work at test"));

        onView(withId(R.id.dateButton)).perform(click());

        onView(isRoot()).perform(HelpersViewMatcher.waitView(withClassName(Matchers.equalTo(DatePicker.class.getName())), 5000));

        onView(withClassName(Matchers.equalTo(DatePicker.class.getName()))).perform(PickerActions.setDate(2000, 2 + 1, 5));

        onView(withId(android.R.id.button1)).perform(click());

        onView(withId(R.id.submitButton)).perform(click());

        onView(withText("alasali")).check(doesNotExist());
    }

    @Test
    public void checkBadEmail(){

            onView(withId(R.id.name)).perform(replaceText("Alas Ali"));
            onView(withId(R.id.email)).perform(replaceText("test@gmail."));
            onView(withId(R.id.user_name)).perform(replaceText("alasali"));
            onView(withId(R.id.description)).perform(replaceText("This is a test"));
         onView(withId(R.id.occupation)).perform(replaceText("I work at test"));

            onView(withId(R.id.dateButton)).perform(click());

            onView(withClassName(Matchers.equalTo(DatePicker.class.getName())))
                    .perform(PickerActions.setDate(2000, 2 + 1, 5));

            onView(withId(android.R.id.button1)).perform(click());

            onView(withId(R.id.submitButton)).perform(click());

            onView(withText("test@gmail.com")).check(doesNotExist());

    }

    @Test
    public void checkDob(){
        onView(withId(R.id.name)).perform(replaceText("Alas Ali"));
        onView(withId(R.id.email)).perform(replaceText("test@gmail.com"));
        onView(withId(R.id.user_name)).perform(replaceText("alasali"));
        onView(withId(R.id.description)).perform(replaceText("This is a test"));
        onView(withId(R.id.occupation)).perform(replaceText("I work at test"));

        onView(withId(R.id.dateButton)).perform(click());

        onView(withClassName(Matchers.equalTo(DatePicker.class.getName())))
                .perform(PickerActions.setDate(2021, 2 + 1, 5));

        onView(withId(android.R.id.button1)).perform(click());

        onView(withId(R.id.submitButton)).perform(click());

        onView(withText("3/5/2000")).check(doesNotExist());
    }

    @Test
    public void checkDescription(){
        onView(withId(R.id.name)).perform(replaceText("Alas Ali"));
        onView(withId(R.id.email)).perform(replaceText("test@gmail.com"));
        onView(withId(R.id.user_name)).perform(replaceText("alasali"));

        onView(withId(R.id.occupation)).perform(replaceText("I work at test"));

        onView(withId(R.id.dateButton)).perform(click());

        onView(withClassName(Matchers.equalTo(DatePicker.class.getName())))
                .perform(PickerActions.setDate(2000, 2 + 1, 5));

        onView(withId(android.R.id.button1)).perform(click());

        onView(withId(R.id.submitButton)).perform(click());

        onView(withText("This is a test")).check(doesNotExist());
    }

    @Test
    public void checkOccupation(){
        onView(withId(R.id.name)).perform(replaceText("Alas Ali"));
        onView(withId(R.id.email)).perform(replaceText("test@gmail.com"));
        onView(withId(R.id.user_name)).perform(replaceText("alasali"));
        onView(withId(R.id.description)).perform(replaceText("This is a test"));


        onView(withId(R.id.dateButton)).perform(click());

        onView(withClassName(Matchers.equalTo(DatePicker.class.getName())))
                .perform(PickerActions.setDate(2000, 2 + 1, 5));

        onView(withId(android.R.id.button1)).perform(click());

        onView(withId(R.id.submitButton)).perform(click());

        onView(withText("I work at test")).check(doesNotExist());
    }

    @Test
    public void properCredentials(){
        onView(withId(R.id.name)).perform(replaceText("Alas Ali"));
        onView(withId(R.id.email)).perform(replaceText("test@gmail.com"));
        onView(withId(R.id.user_name)).perform(replaceText("alasali"));
        onView(withId(R.id.description)).perform(replaceText("This is a test"));
        onView(withId(R.id.occupation)).perform(replaceText("I work at test"));

        onView(withId(R.id.dateButton)).perform(click());

        onView(withClassName(Matchers.equalTo(DatePicker.class.getName())))
                .perform(PickerActions.setDate(2000, 2 + 1, 5));

        onView(withId(android.R.id.button1)).perform(click());

        onView(withId(R.id.submitButton)).perform(click());

        onView(withId(R.id.welcome)).check(matches(isDisplayed()));
    }

    @Test
    public void ageDisplayed(){
        onView(withId(R.id.name)).perform(replaceText("Alas Ali"));
        onView(withId(R.id.email)).perform(replaceText("test@gmail.com"));
        onView(withId(R.id.user_name)).perform(replaceText("alasali"));
        onView(withId(R.id.description)).perform(replaceText("This is a test"));
        onView(withId(R.id.occupation)).perform(replaceText("I work at test"));

        onView(withId(R.id.dateButton)).perform(click());

        onView(withClassName(Matchers.equalTo(DatePicker.class.getName())))
                .perform(PickerActions.setDate(2000, 2 + 1, 5));

        onView(withId(android.R.id.button1)).perform(click());

        onView(withId(R.id.submitButton)).perform(click());

        onView(withId(R.id.age)).check(matches(withText("age: 22")));
    }

    @Test
    public void imageDisplayed(){
        onView(withId(R.id.name)).perform(replaceText("Alas Ali"));
        onView(withId(R.id.email)).perform(replaceText("test@gmail.com"));
        onView(withId(R.id.user_name)).perform(replaceText("alasali"));
        onView(withId(R.id.description)).perform(replaceText("This is a test"));
        onView(withId(R.id.occupation)).perform(replaceText("I work at test"));

        onView(withId(R.id.dateButton)).perform(click());

        onView(withClassName(Matchers.equalTo(DatePicker.class.getName())))
                .perform(PickerActions.setDate(2000, 2 + 1, 5));

        onView(withId(android.R.id.button1)).perform(click());

        onView(withId(R.id.submitButton)).perform(click());

        onView(withId(R.id.profile_picture)).check(matches(isDisplayed()));
    }
}