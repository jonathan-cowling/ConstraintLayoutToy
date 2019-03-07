package tk.jonathancowling.constraintlayouttoy

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager?.beginTransaction()?.replace(R.id.content, HomeFragment(), "home")?.commit()
    }

    override fun onBackPressed() {
        if (supportFragmentManager?.findFragmentByTag("home") == null) {
            supportFragmentManager?.beginTransaction()?.replace(R.id.content, HomeFragment(), "home")?.commit()
        } else {
            super.onBackPressed()
        }
    }
}
