package com.machinecode.testandroidproject.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.machinecode.testandroidproject.R
import com.machinecode.testandroidproject.data.Person
import de.hdodenhof.circleimageview.CircleImageView

class PersonAdapter(private val mListPerson: List<Person>) :
    RecyclerView.Adapter<PersonAdapter.VHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHolder {
        return VHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.person_view_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: VHolder, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount(): Int {
        return mListPerson.size
    }

    @SuppressLint("SetTextI18n")
    inner class VHolder(val viewItem: View) : BaseViewHolder(viewItem) {
        val civProfileImage: CircleImageView = itemView.findViewById(R.id.civ_profile_image)
        val tvPersonName: TextView = itemView.findViewById(R.id.tv_person_name)

        override fun onBind(position: Int) {
            super.onBind(position)
            val mSigPerson = mListPerson[position]
            civProfileImage.setImageResource(R.color.light_yellow)
            tvPersonName.text = mSigPerson.firstName + " " + mSigPerson.lastName
        }
    }
}