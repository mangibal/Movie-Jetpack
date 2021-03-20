package com.iqbalfauzi.moviejetpack.presentation.main.view

import androidx.test.core.app.ActivityScenario
import com.iqbalfauzi.moviejetpack.R
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Before

import org.junit.Test

/**
 * Created by Iqbal Fauzi on 2/20/21 10:47 PM
 * iqbal.fauzi.if99@gmail.com
 */
class MainActivityTest: TestCase() {

    @Before
    fun setUp() {
        ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun mainActivityTest() {
        run {
            step("Main Screen Test") {
                testLogger.i("Main Screen")
                MainScreen {
                    tvAppTitle {
                        isVisible()
                        hasText(R.string.app_name)
                    }
                }
            }
        }
    }
}