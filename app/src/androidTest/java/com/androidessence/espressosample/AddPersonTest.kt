package com.androidessence.espressosample

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AddPersonTest {

    @Rule @JvmField val rule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    val testPerson = Person("Adam", "McNeilly", 24, "adam@adam.com")

    @Test
    fun addPersonSuccess() {
        onView(withId(R.id.fab)).perform(click())

        AddPersonRobot()
                .firstName(testPerson.firstName)
                .lastName(testPerson.lastName)
                .age(testPerson.age)
                .emailAddress(testPerson.emailAddress)
                .submit()

        // Make sure we came back, check for item to be displayed
        onView(withId(R.id.fab)).check(matches(isDisplayed()))
        onView(withText(testPerson.fullName)).check(matches(isDisplayed()))
    }

    @Test
    fun checkFirstNameError() {
        onView(withId(R.id.fab)).perform(click())

        AddPersonRobot()
                .lastName(testPerson.lastName)
                .age(testPerson.age)
                .emailAddress(testPerson.emailAddress)
                .submit()
                .matchFirstNameError(rule.activity.getString(R.string.err_first_name_blank))
    }

    @Test
    fun checkLastNameError() {
        onView(withId(R.id.fab)).perform(click())

        AddPersonRobot()
                .firstName(testPerson.firstName)
                .age(testPerson.age)
                .emailAddress(testPerson.emailAddress)
                .submit()
                .matchLastNameError(rule.activity.getString(R.string.err_last_name_blank))
    }

    @Test
    fun checkAgeError() {
        onView(withId(R.id.fab)).perform(click())

        AddPersonRobot()
                .firstName(testPerson.firstName)
                .lastName(testPerson.lastName)
                .emailAddress(testPerson.emailAddress)
                .submit()
                .matchAgeError(rule.activity.getString(R.string.err_age_blank))
    }

    @Test
    fun checkEmailAddressError() {
        onView(withId(R.id.fab)).perform(click())

        AddPersonRobot()
                .firstName(testPerson.firstName)
                .lastName(testPerson.lastName)
                .age(testPerson.age)
                .submit()
                .matchEmailAddressError(rule.activity.getString(R.string.err_email_address_blank))
    }
}