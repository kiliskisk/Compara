package com.curso.android.app.practica.compara.view

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.curso.android.app.practica.compara.R
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get: Rule
    var rule: ActivityScenarioRule<*> = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        Assert.assertEquals("com.curso.android.app.practica.compara", appContext.packageName)
    }

    @Test
    fun mainActivity_BtnComparar() {
        Espresso.onView(
            ViewMatchers.withId(R.id.btnComparar)
        ).perform(
            ViewActions.click()
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.textViewResultado)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText("Texto 1 es diferente de Texto 2")
            )
        )
}}