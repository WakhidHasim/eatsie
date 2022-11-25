package kelompok4.eatsie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class AdapterRecyclerView(private val foodMenuList:ArrayList<DataMenuRecyclerView>) : RecyclerView.Adapter<AdapterRecyclerView.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.menu_nusantara_template, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = foodMenuList[position]
        holder.ivFoodMenu.setImageResource(currentItem.foodMenuImage)
        holder.tvFoodMenu.text = currentItem.foodMenu
    }

    override fun getItemCount(): Int {
        return  foodMenuList.size
    }

    class  MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)
    {
        val ivFoodMenu : ShapeableImageView = itemView.findViewById(R.id.ivFoodMenu)
        val tvFoodMenu : TextView = itemView.findViewById(R.id.tvFoodMenu)
    }
}