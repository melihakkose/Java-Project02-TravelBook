package com.melihakkose.travelbook_basic_kotlin

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val intent=intent
        val travelNames=intent.getStringExtra("name")
        textViewCity.text=travelNames

        //Global degisken ile tanimlanan bitmap i aktif etme kodu
        //imageViewCity.setImageBitmap(selectedGlobalBitmap)

        //Singleton
        /*
        val singleton=Singleton.Selected
        val selectedBitmap=singleton.selectedImage
        imageViewCity.setImageBitmap(selectedBitmap)

         */
        //Int degerleri intent ile alip bitmap ile decode ediyoruz.
        val travelImage=intent.getIntExtra("image",0)
        val selectedBitmap =BitmapFactory.decodeResource(applicationContext.resources,travelImage)
        imageViewCity.setImageBitmap(selectedBitmap)

    }
}