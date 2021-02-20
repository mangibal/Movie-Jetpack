package com.iqbalfauzi.moviejetpack.presentation.splash

import androidx.test.core.app.ActivityScenario
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Before
import org.junit.Test

/**
 * Created by Iqbal Fauzi on 2/20/21 10:04 PM
 * iqbal.fauzi.if99@gmail.com
 */
class SplashActivityTest: TestCase() {

    @Before
    fun setup() {
        ActivityScenario.launch(SplashActivity::class.java)
    }

    @Test
    fun onSplashScreenTest() {
        run {
            step("UI Component Visibility Checking") {
                testLogger.i("Splash Screen")
                SplashScreen {
                    ivAppIcon {
                        isVisible()
                    }
                    tvTitleApp {
                        isVisible()
                    }
                }
            }
        }
    }

}