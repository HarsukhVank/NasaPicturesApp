package com.hv.nasapicturesapp.adapters

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hv.nasapicturesapp.activities.ImagesGreedActivity
import com.hv.nasapicturesapp.models.ImagesDataModel
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class ImagesGreedAdapterTest {
    private lateinit var activity: ImagesGreedActivity
    private lateinit var context : Context
    private var imagesList = mutableListOf<ImagesDataModel>()

    @Before
    fun setUp(){
        activity = Robolectric.buildActivity(ImagesGreedActivity::class.java).create().resume().get()
        context = activity
        imagesList.add(ImagesDataModel("explanation1", "title1", "url1"))
        imagesList.add(ImagesDataModel("explanation2", "title2", "url2"))
        imagesList.add(ImagesDataModel("explanation3", "title3", "url3"))
    }

    @Test
    fun adapterTest() {
        val imagesGreedAdapter = ImagesGreedAdapter(imagesList)
        val recyclerView = RecyclerView(context)
        recyclerView.adapter = imagesGreedAdapter
        recyclerView.layoutManager = GridLayoutManager(context, 3)
        val viewHolder = imagesGreedAdapter.onCreateViewHolder(recyclerView, 0)
        imagesGreedAdapter.onBindViewHolder(viewHolder, 0)
        Assert.assertEquals(View.VISIBLE, viewHolder.binding.imageView.visibility)
        Assert.assertEquals(3, imagesGreedAdapter.itemCount)
    }
}