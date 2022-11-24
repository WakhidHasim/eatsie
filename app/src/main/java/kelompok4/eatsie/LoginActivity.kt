package kelompok4.eatsie

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener(this)
        tvForgotPassword.setOnClickListener(this)
        tvDontHaveAccount.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnLogin -> {
                val btnLoginIntent = Intent(this@LoginActivity, DashboardActivity::class.java)
                startActivity(btnLoginIntent)
            }

            R.id.tvForgotPassword -> {
                val forgotPasswordIntent = Intent(this@LoginActivity, ForgotPasswordActivity::class.java)
                startActivity(forgotPasswordIntent)
            }

            R.id.tvDontHaveAccount -> {
                val registerIntent = Intent(this@LoginActivity, RegisterActivity::class.java)
                startActivity(registerIntent)
            }
        }
    }
}