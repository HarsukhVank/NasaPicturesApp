package com.hv.nasapicturesapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.hv.nasapicturesapp.R
import com.hv.nasapicturesapp.adapters.ImagesGreedAdapter
import com.hv.nasapicturesapp.databinding.ActivityImagesGreedBinding
import com.hv.nasapicturesapp.viewmodels.ImagesViewModel

class ImagesGreedActivity : AppCompatActivity()  {
    private lateinit var binding: ActivityImagesGreedBinding
    private lateinit var viewModel: ImagesViewModel
    private lateinit var adapter: ImagesGreedAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_images_greed)
        viewModel = ImagesViewModel(application)
        val imagesList = viewModel.getImagesData()
        if (imagesList.isNotEmpty()) {
            adapter = ImagesGreedAdapter(imagesList)
            binding.recyclerView.layoutManager = GridLayoutManager(this, SPAN_COUNT)
            binding.recyclerView.adapter = adapter
        }
    }

    companion object {
        private const val SPAN_COUNT = 3
    }
}