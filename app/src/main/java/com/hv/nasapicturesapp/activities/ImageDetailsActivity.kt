package com.hv.nasapicturesapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.hv.nasapicturesapp.R
import com.hv.nasapicturesapp.databinding.ActivityImageDetailsBinding
import com.hv.nasapicturesapp.models.ImagesDataModel
import com.hv.nasapicturesapp.utilities.Constants.KEY_IMAGE_DATA

class ImageDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityImageDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_image_details)
        val imagesDataModel: ImagesDataModel? = intent.getParcelableExtra(KEY_IMAGE_DATA)
        imagesDataModel?.let {
            binding.title.text = imagesDataModel.title
            binding.explanation.text = imagesDataModel.explanation
            Glide.with(this).load(imagesDataModel.url).fitCenter().into(binding.imageView)
        }
    }
}