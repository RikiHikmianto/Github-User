package id.rikihikmianto.githubuser

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashScreen : AppCompatActivity() {
    val SPLASH_SCREEN = 4000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()

        setContentView(R.layout.splash_screen)
        Handler().postDelayed(
            {
                intent = Intent(this@SplashScreen, MainActivity::class.java)
                startActivity(intent)
                finish()
            }, SPLASH_SCREEN.toLong()
        )
    }
}