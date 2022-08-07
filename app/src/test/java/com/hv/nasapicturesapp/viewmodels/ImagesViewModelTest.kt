package com.hv.nasapicturesapp.viewmodels

import android.app.Application
import com.hv.nasapicturesapp.models.ImagesDataModel
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment

@RunWith(RobolectricTestRunner::class)
class ImagesViewModelTest {
    private lateinit var context: Application
    @Before
    fun setUp(){
        context = RuntimeEnvironment.getApplication()
    }

    @Test
    fun getImagesDataTest(){
        val viewModel = ImagesViewModel(context)
        val imagesDataModelList : List<ImagesDataModel> = viewModel.getImagesData()
        Assert.assertNotNull(imagesDataModelList)
        Assert.assertTrue(imagesDataModelList.isNotEmpty())
    }
}