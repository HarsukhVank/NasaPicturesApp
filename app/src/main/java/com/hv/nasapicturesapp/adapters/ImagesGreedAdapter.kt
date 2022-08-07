package com.hv.nasapicturesapp.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hv.nasapicturesapp.activities.ImageDetailsActivity
import com.hv.nasapicturesapp.databinding.ItemViewImageBinding
import com.hv.nasapicturesapp.models.ImagesDataModel
import com.hv.nasapicturesapp.utilities.Constants.KEY_IMAGE_DATA


class ImagesGreedAdapter(private val imagesList: List<ImagesDataModel>) :
    RecyclerView.Adapter<MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemViewImageBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val context = holder.itemView.context
        val url = imagesList[position].url
        Glide.with(context)
            .load(url)
            .override(IMAGE_SIZE, IMAGE_SIZE)
            .fitCenter()
            .into(holder.binding.imageView)

        holder.binding.imageView.setOnClickListener{
            startImageDetailsActivity(context, imagesList[position])
        }
    }

    override fun getItemCount(): Int {
        return imagesList.size
    }

    companion object {
        private const val IMAGE_SIZE = 100
    }
}

class MainViewHolder(val binding: ItemViewImageBinding) : RecyclerView.ViewHolder(binding.root)


private fun startImageDetailsActivity(context: Context, imageDataItem: ImagesDataModel) {
    val intent = Intent(context, ImageDetailsActivity::class.java)
    intent.putExtra(KEY_IMAGE_DATA, imageDataItem)
    context.startActivity(intent)
}


