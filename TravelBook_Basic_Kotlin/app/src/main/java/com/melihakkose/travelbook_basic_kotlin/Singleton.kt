package com.melihakkose.travelbook_basic_kotlin

import android.graphics.Bitmap

class Singleton {

    //Tek bir objesi olan sinif -> Kotlin = Companion object
    companion object Selected{
        var selectedImage : Bitmap?=null
    }

}