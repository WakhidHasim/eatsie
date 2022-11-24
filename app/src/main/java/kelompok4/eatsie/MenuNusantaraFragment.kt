package kelompok4.eatsie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MenuNusantara.newInstance] factory method to
 * create an instance of this fragment.
 */
class MenuNusantaraFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var adapter: AdapterRecyclerView
    private lateinit var recyclerView: RecyclerView
    private lateinit var foodArrayList: ArrayList<DataMenuRecyclerView>

    lateinit var imageId : Array<Int>
    lateinit var heading : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu_nusantara, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MenuNusantara.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MenuNusantaraFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recycleView)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = AdapterRecyclerView(foodArrayList)
        recyclerView.adapter = adapter
    }

    private  fun dataInitialize(){
        foodArrayList = arrayListOf<DataMenuRecyclerView>()

        imageId = arrayOf(
            R.drawable.sate,
            R.drawable.rendang,
            R.drawable.soto,
            R.drawable.pempek
        )

        heading = arrayOf(
            getString(R.string.sate_ayam),
            getString(R.string.rendang),
            getString(R.string.soto_madura),
            getString(R.string.pempek)
        )

        for (i in imageId.indices){
            val  foodMenu = DataMenuRecyclerView(imageId[i], heading[i])
            foodArrayList.add(foodMenu)
        }
    }
}