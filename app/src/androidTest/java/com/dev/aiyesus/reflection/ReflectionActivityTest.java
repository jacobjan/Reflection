package com.dev.aiyesus.reflection;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class ReflectionActivityTest {

    @Rule
    public ActivityTestRule<ReflectionActivity> mActivityTestRule = new ActivityTestRule<>(ReflectionActivity.class);

    @Test
    public void reflectionActivityTest() {
        ViewInteraction button = onView(
                allOf(withId(R.id.get), withText("Run Static Mains"), isDisplayed()));
        button.perform(click());

        ViewInteraction button2 = onView(
                allOf(withId(R.id.get), withText("Run Static Mains"), isDisplayed()));
        button2.perform(click());

        ViewInteraction button3 = onView(
                allOf(withId(R.id.violet), withText("Get Movies"), isDisplayed()));
        button3.perform(click());

        pressBack();

        ViewInteraction textView = onView(
                allOf(withId(R.id.results), isDisplayed()));
        textView.perform(replaceText("(resultCode -1) \nMovie 714 rating:0.49\nMovie 266 rating:0.56\nMovie 765 rating:1.17\nMovie 877 rating:4.52\nMovie 230 rating:3.24\nMovie 418 rating:3.04\nMovie 958 rating:0.23\nMovie 823 rating:4.15\nMovie 673 rating:4.32\nMovie 328 rating:2.47\nHashMap after sorting entries by values in ascending order:\nFrom sorted SET of Hashmap :\nMovie :958  rating:0.23\nMovie :714  rating:0.49\nMovie :266  rating:0.56\nMovie :765  rating:1.17\nMovie :328  rating:2.47\nMovie :418  rating:3.04\nMovie :230  rating:3.24\nMovie :823  rating:4.15\nMovie :673  rating:4.32\nMovie :877  rating:4.52\n\n\nBottom 3 rating movies in ascending order:\nMovie :958  rating:0.23\nMovie :714  rating:0.49\nMovie :266  rating:0.56\n\n\nTop three rating movies in decending order:\nMovie :877  rating:4.52\nMovie :673  rating:4.32\nMovie :823  rating:4.15\n\n(cancelled)\n"), closeSoftKeyboard());

    }

}
