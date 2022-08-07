package com.hv.nasapicturesapp.activities

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class ImageDetailsActivityTest {
    private lateinit var activity: ImageDetailsActivity

    @Before
    fun setUp() {
        activity = Robolectric.buildActivity(ImageDetailsActivity::class.java).create().resume().get()
    }

    @Test
    fun activityTest(){
        Assert.assertNotNull(activity)
    }
}