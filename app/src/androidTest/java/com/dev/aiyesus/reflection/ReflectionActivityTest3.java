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
public class ReflectionActivityTest3 {

    @Rule
    public ActivityTestRule<ReflectionActivity> mActivityTestRule = new ActivityTestRule<>(ReflectionActivity.class);

    @Test
    public void reflectionActivityTest3() {
        ViewInteraction button = onView(
                allOf(withId(R.id.get), withText("Run Static Mains"), isDisplayed()));
        button.perform(click());

        ViewInteraction button2 = onView(
                allOf(withId(R.id.corky), withText("Reflection"), isDisplayed()));
        button2.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.results), isDisplayed()));
        textView.perform(replaceText("(resultCode -1) public class android.text.style.StyleSpan extends android.text.style.MetricAffectingSpan\n implements android.text.ParcelableSpan { // Constructors\n // Fields\n // Methods\n  private static void apply(android.graphics.Paint, int);\n  public int describeContents();\n  public int getSpanTypeId();\n  public int getSpanTypeIdInternal();\n  public int getStyle();\n  public void updateDrawState(android.text.TextPaint);\n  public void updateMeasureState(android.text.TextPaint);\n  public void writeToParcel(android.os.Parcel, int);\n  public void writeToParcelInternal(android.os.Parcel, int);\n}\n\n"), closeSoftKeyboard());

        ViewInteraction button3 = onView(
                allOf(withId(R.id.get), withText("Run Static Mains"), isDisplayed()));
        button3.perform(click());

        ViewInteraction button4 = onView(
                allOf(withId(R.id.violet), withText("Get Movies"), isDisplayed()));
        button4.perform(click());

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.results), withText("(resultCode -1) public class android.text.style.StyleSpan extends android.text.style.MetricAffectingSpan\n implements android.text.ParcelableSpan { // Constructors\n // Fields\n // Methods\n  private static void apply(android.graphics.Paint, int);\n  public int describeContents();\n  public int getSpanTypeId();\n  public int getSpanTypeIdInternal();\n  public int getStyle();\n  public void updateDrawState(android.text.TextPaint);\n  public void updateMeasureState(android.text.TextPaint);\n  public void writeToParcel(android.os.Parcel, int);\n  public void writeToParcelInternal(android.os.Parcel, int);\n}\n\n"), isDisplayed()));
        textView2.perform(replaceText("(resultCode -1) public class android.text.style.StyleSpan extends android.text.style.MetricAffectingSpan\n implements android.text.ParcelableSpan { // Constructors\n // Fields\n // Methods\n  private static void apply(android.graphics.Paint, int);\n  public int describeContents();\n  public int getSpanTypeId();\n  public int getSpanTypeIdInternal();\n  public int getStyle();\n  public void updateDrawState(android.text.TextPaint);\n  public void updateMeasureState(android.text.TextPaint);\n  public void writeToParcel(android.os.Parcel, int);\n  public void writeToParcelInternal(android.os.Parcel, int);\n}\n\n(resultCode -1) \nMovie 388 rating:2.61\nMovie 729 rating:1.92\nMovie 380 rating:2.2\nMovie 993 rating:4.55\nMovie 316 rating:2.65\nMovie 796 rating:0.87\nMovie 624 rating:3.35\nMovie 704 rating:2.06\nMovie 885 rating:0.98\nMovie 282 rating:1.72\nHashMap after sorting entries by values in ascending order:\nFrom sorted SET of Hashmap :\nMovie :796  rating:0.87\nMovie :885  rating:0.98\nMovie :282  rating:1.72\nMovie :729  rating:1.92\nMovie :704  rating:2.06\nMovie :380  rating:2.2\nMovie :388  rating:2.61\nMovie :316  rating:2.65\nMovie :624  rating:3.35\nMovie :993  rating:4.55\n\n\nBottom 3 rating movies in ascending order:\nMovie :796  rating:0.87\nMovie :885  rating:0.98\nMovie :282  rating:1.72\n\n\nTop three rating movies in decending order:\nMovie :993  rating:4.55\nMovie :624  rating:3.35\nMovie :316  rating:2.65\n\n"), closeSoftKeyboard());

        ViewInteraction button5 = onView(
                allOf(withId(R.id.clear), withText("clear Result"), isDisplayed()));
        button5.perform(click());

        pressBack();

    }

}
