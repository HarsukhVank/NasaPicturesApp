package com.hv.nasapicturesapp.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.hv.nasapicturesapp.models.ImagesDataModel
import java.io.IOException

class ImagesViewModel(private val context: Application) : ViewModel() {
    fun getImagesData(): List<ImagesDataModel> {
        val jsonString = getDataFromAssetFile()
        val gson = Gson()
        val listImageType = object : TypeToken<List<ImagesDataModel>>() {}.type
        val imagesList: List<ImagesDataModel> = gson.fromJson(jsonString, listImageType)
        return imagesList.sortedByDescending { it.date }
    }

    private fun getDataFromAssetFile(): String? {
        var jsonString : String? = null
        try {
            jsonString = context.assets.open(FILE_NAME).bufferedReader().use { it.readText() }
        } catch (exception : IOException){
            Log.v(TAG, exception.printStackTrace().toString())
        }
        return jsonString
    }

    companion object {
        private const val TAG = "ImagesViewModel"
        private const val FILE_NAME = "data.json"
    }
}