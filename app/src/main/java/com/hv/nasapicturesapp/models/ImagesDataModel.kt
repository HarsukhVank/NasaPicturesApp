package com.hv.nasapicturesapp.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ImagesDataModel(val explanation: String, val title: String, val url: String) : Parcelable

