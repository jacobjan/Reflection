package com.dev.aiyesus.reflection;


import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class ReflectionActivityTest2 {

    @Rule
    public ActivityTestRule<ReflectionActivity> mActivityTestRule = new ActivityTestRule<>(ReflectionActivity.class);

    @Test
    public void reflectionActivityTest2() {
    }

}
