package com.example.task2;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;

import static com.example.task2.VariableStorage.DefOperationTags.*;
import static com.example.task2.VariableStorage.*;


import android.os.RemoteException;
import android.view.View;
import android.widget.ProgressBar;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.uiautomator.UiDevice;

import com.example.task2.customView.TextWithPB;
import com.google.android.material.textview.MaterialTextView;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityScenarioRule rule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void application_working_changing_orientation() throws RemoteException {
        UiDevice device = UiDevice.getInstance(getInstrumentation());

        onView(withId(R.id.et_operation_number)).perform(clearText());
        onView(withId(R.id.et_operation_number)).perform(typeText("60000"),
                closeSoftKeyboard());
        onView(withId(R.id.et_threads_number)).perform(clearText());
        onView(withId(R.id.et_threads_number)).perform(typeText("8"),
                closeSoftKeyboard());
        onView(withId(R.id.btn_start_collections)).perform(click());

        onView(withId(R.id.tv_add_to_middle_linkedlist)).perform(swipeLeft());

        device.setOrientationLeft();

        onView(withId(R.id.et_operation_number)).perform(clearText());
        onView(withId(R.id.et_operation_number)).perform(typeText("200000"),
                closeSoftKeyboard());
        onView(withId(R.id.et_threads_number)).perform(clearText());
        onView(withId(R.id.et_threads_number)).perform(typeText("8"),
                closeSoftKeyboard());
        onView(withId(R.id.btn_start_maps)).perform(click());

        onView(withId(R.id.tv_search_in_treeMap)).perform(swipeRight());

        device.setOrientationNatural();

        onView(withId(R.id.et_operation_number)).check(matches(withText("60000")));
    }

    public static Matcher<View> withTextInCustomView(final Matcher<View> parentMatcher,
                                                     DefOperationTags operationTag) {
        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {}

            @Override
            public boolean matchesSafely(View view) {
                if (view.getParent().getParent() != null
                        && view.getParent().getParent() instanceof TextWithPB
                        && view instanceof MaterialTextView) {
                    if ((((TextWithPB) view.getParent().getParent()).getTag()).equals(operationTag)) {
                        return parentMatcher.matches(view.getParent().getParent());
                    }
                }
                return false;
            }
        };
    }

    public static Matcher<View> withProgressBarInCustomView(final Matcher<View> parentMatcher,
                                                            DefOperationTags operationTag) {
        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {}

            @Override
            public boolean matchesSafely(View view) {
                if (view.getParent().getParent() != null
                        && view.getParent().getParent() instanceof TextWithPB
                        && view instanceof ProgressBar) {
                    if ((((TextWithPB) view.getParent().getParent()).getTag()).equals(operationTag)) {
                        return parentMatcher.matches(view.getParent().getParent());
                    }
                }
                return false;
            }
        };
    }

    @Test
    public void test_check_single_view() throws InterruptedException {
        onView(withId(R.id.et_operation_number)).perform(clearText());
        onView(withId(R.id.et_operation_number)).perform(typeText("2000000"),
                closeSoftKeyboard());

        onView(withId(R.id.btn_start_collections)).perform(click());

        onView(withProgressBarInCustomView(withId(R.id.tv_add_to_start_arraylist), ADD_TO_START_ARRAYLIST))
                .check(matches(isDisplayed()));

        Thread.sleep(1000);

        onView(withTextInCustomView(withId(R.id.tv_add_to_start_arraylist), ADD_TO_START_ARRAYLIST))
                .check(matches(withSubstring(widgets_texts.get(ADD_TO_START_ARRAYLIST))));
    }
}