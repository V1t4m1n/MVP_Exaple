package ua.vitamin.mvp_example

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class PeopleListAdapter (val listPeople: List<User>) :
    RecyclerView.Adapter<PeopleListAdapter.PeopleListViewHolder>() {

    override fun getItemCount(): Int {
        return listPeople.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleListViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return PeopleListViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PeopleListViewHolder, position: Int) {
        holder.fist.text = listPeople[position].fistName
        holder.last.text = listPeople[position].lastName
        Picasso.get().load(listPeople[position].avatar).into(holder.avatar)
    }

    inner class PeopleListViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        val fist: TextView = itemView.findViewById(R.id.fistName)
        val last: TextView = itemView.findViewById(R.id.lastName)
        val avatar: ImageView = itemView.findViewById(R.id.avatar)
    }
}