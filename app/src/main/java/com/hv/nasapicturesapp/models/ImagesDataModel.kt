package com.hv.nasapicturesapp.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ImagesDataModel(val date: String, val explanation: String, val title: String, val url: String) : Parcelable

