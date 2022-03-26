package com.niro.android.kotlinapplication.adapters

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.niro.android.kotlinapplication.R
import com.niro.android.kotlinapplication.model.Photo
import java.net.URI
import java.net.URL

class PhotoAdapter (private val mList: List<Photo>): RecyclerView.Adapter<PhotoAdapter.ViewHolder>() {
    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]

        // sets the image to the imageview from our itemHolder class
//        var newurl = URL(ItemsViewModel.thumbnailUrl)
//        val mIcon_val = BitmapFactory.decodeStream(newurl.openConnection().getInputStream())
//        holder.imageView.setImageBitmap(mIcon_val)

        // sets the text to the textview from our itemHolder class
        holder.textView.text = ItemsViewModel.title
        holder.textViewUrl.text = ItemsViewModel.url

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val textView: TextView = itemView.findViewById(R.id.textView)
        val textViewUrl = itemView.findViewById<TextView>(R.id.textview_url)
    }
}