package kelompok4.eatsie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kelompok4.eatsie.databinding.ActivityDashboardBinding


class DashboardActivity : AppCompatActivity() {
    lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Home())

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.itemMenuHome -> replaceFragment(Home())
                R.id.itemMenuFavorites -> replaceFragment(Favorites())
                R.id.itemMenuProfile -> replaceFragment(Profile())

                else ->{

                }
            }
            true
        }
    }

    private fun replaceFragment (fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.frameLayoutContainer, fragment)
        fragmentTransaction.commit()
    }
}