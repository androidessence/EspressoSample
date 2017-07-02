package com.androidessence.espressosample

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.hasErrorText
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.view.View
import org.hamcrest.Matcher

class AddPersonRobot {
    fun firstName(firstName: String): AddPersonRobot {
        onView(FIRST_NAME_MATCHER).perform(clearText(), typeText(firstName), ViewActions.closeSoftKeyboard())
        return this
    }

    fun lastName(lastName: String): AddPersonRobot {
        onView(LAST_NAME_MATCHER).perform(clearText(), typeText(lastName), ViewActions.closeSoftKeyboard())
        return this
    }

    fun age(age: Int): AddPersonRobot {
        onView(AGE_MATCHER).perform(clearText(), typeText(age.toString()), ViewActions.closeSoftKeyboard())
        return this
    }

    fun emailAddress(emailAddress: String): AddPersonRobot {
        onView(EMAIL_ADDRESS_MATCHER).perform(clearText(), typeText(emailAddress), ViewActions.closeSoftKeyboard())
        return this
    }

    fun submit(): AddPersonRobot {
        onView(SUBMIT_MATCHER).perform(click())
        return this
    }

    fun matchFirstNameError(error: String): AddPersonRobot {
        onView(FIRST_NAME_MATCHER).check(matches(hasErrorText(error)))
        return this
    }

    fun matchLastNameError(error: String): AddPersonRobot {
        onView(LAST_NAME_MATCHER).check(matches(hasErrorText(error)))
        return this
    }

    fun matchAgeError(error: String): AddPersonRobot {
        onView(AGE_MATCHER).check(matches(hasErrorText(error)))
        return this
    }

    fun matchEmailAddressError(error: String): AddPersonRobot {
        onView(EMAIL_ADDRESS_MATCHER).check(matches(hasErrorText(error)))
        return this
    }

    companion object {
        val FIRST_NAME_MATCHER: Matcher<View> = withId(R.id.first_name)
        val LAST_NAME_MATCHER: Matcher<View> = withId(R.id.last_name)
        val AGE_MATCHER: Matcher<View> = withId(R.id.age)
        val EMAIL_ADDRESS_MATCHER: Matcher<View> = withId(R.id.email_address)
        val SUBMIT_MATCHER: Matcher<View> = withId(R.id.submit)
    }
}