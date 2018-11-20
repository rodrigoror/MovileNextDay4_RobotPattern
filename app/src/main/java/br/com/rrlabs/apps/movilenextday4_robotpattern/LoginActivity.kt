package br.com.rrlabs.apps.movilenextday4_robotpattern

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.longToast
import org.jetbrains.anko.yesButton

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btLogin.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            //atribui o valor ao

            if (email == "rodrigoror@gmail.com" && password == "admin") {
                tvNameSurname.text = getString(R.string.name_surname)
                longToast("Hooray!")
            }else if (email.isEmpty() || password.isEmpty()){
                alert ( R.string.missing_fields ){yesButton {  }}.show()
            }else {
                alert (R.string.error_login){yesButton {  }}.show()
            }
        }
    }
}
