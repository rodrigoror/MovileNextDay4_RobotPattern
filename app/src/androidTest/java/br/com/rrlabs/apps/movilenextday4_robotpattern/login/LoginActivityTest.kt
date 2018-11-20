package br.com.rrlabs.apps.movilenextday4_robotpattern.login

import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import br.com.rrlabs.apps.movilenextday4_robotpattern.LoginActivity
import br.com.rrlabs.apps.movilenextday4_robotpattern.R
import org.junit.Before

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginActivityTest {

    @get:Rule
    val rule = ActivityTestRule(LoginActivity::class.java)

    private lateinit var robot: LoginRobot

    @Before
    fun setUp() {
        robot = LoginRobot(rule.activity)
    }

    @Test
    fun loginSuccess() {
        robot.setEmail("rodrigoror@gmail.com")
            .setPassword("admin")
            .clickLogin()
            .matchText(R.id.tvNameSurname, rule.activity.getString( R.string.name_surname))
    }

    @Test
    fun loginMissingEmailPassword() {
        robot
            .clickLogin()
            .matchErrorText( R.string.missing_fields)
    }

    @Test
    fun loginMissingPassword() {

        robot.setEmail("rodrigoror@gmail.com")
            .clickLogin()
            .matchErrorText( R.string.missing_fields)
    }

    @Test
    fun loginWrongPassword() {
        robot.setEmail("rodrigoror@gmail.com")
            .setPassword("admimn")
            .clickLogin()
            .matchErrorText( R.string.error_login)
    }
}