package com.hv.nasapicturesapp.activities

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class ImagesGreedActivityTest {
    private lateinit var activity: ImagesGreedActivity
    @Before
    fun setUp() {
        activity = Robolectric.buildActivity(ImagesGreedActivity::class.java).create().resume().get()
    }

    @Test
    fun activityTest(){
        Assert.assertNotNull(activity)
    }
}