package com.hv.nasapicturesapp.models

import org.junit.Assert
import org.junit.Test

class ImagesDataModelTest {

    @Test
    fun getSetDataTest() {
        val imagesDataModel = ImagesDataModel("date", "explanation", "title", "url")
        Assert.assertNotNull(imagesDataModel)
        Assert.assertEquals("date", imagesDataModel.date)
        Assert.assertEquals("explanation", imagesDataModel.explanation)
        Assert.assertEquals("title", imagesDataModel.title)
        Assert.assertEquals("url", imagesDataModel.url)
    }
}