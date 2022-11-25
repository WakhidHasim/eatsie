package kelompok4.eatsie

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kelompok4.eatsie.databinding.ActivityMenuBinding
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {
    lateinit var binding: ActivityMenuBinding

    private lateinit var menuDetail: Menu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        menuDetail = intent.getSerializableExtra(PARAM_MENU) as Menu

        checkMenuDetail()
    }

    private fun checkMenuDetail() {
        when (menuDetail) {
            Menu.NUSANTARA -> {
                replaceFragment(MenuNusantaraFragment())
            }
            Menu.INTERNATIONAL -> {

            }
            Menu.DESERT -> {

            }
            Menu.APPETIZER -> {

            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.container, fragment)
        fragmentTransaction.commit()
    }

    companion object {
        private const val PARAM_MENU = "menu"

        fun newInstance(context: Context, menuDetail: Menu) {
            val intent = Intent(context, MenuActivity::class.java)
            intent.putExtra(PARAM_MENU, menuDetail)
            context.startActivity(intent)
        }

        enum class Menu(val value: String) {
            NUSANTARA("nusantara"),
            INTERNATIONAL("international"),
            DESERT("desert"),
            APPETIZER("appetizer")
        }
    }
}