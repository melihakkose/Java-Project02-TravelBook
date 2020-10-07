package com.melihakkose.travelbook_basic_kotlin

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
//Global tanimlamalar cok tercih edilmez
//var selectedGlobalBitmap:Bitmap?=null

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Cities
        var travelNames=ArrayList<String>()
        travelNames.add("Izmir Saat Kulesi")
        travelNames.add("Central Park")
        travelNames.add("Galata Kulesi")
        travelNames.add("Empire State")

        //Image -> Bitmap sayesinde degisken olarak saklama
        /*
        val saatKulesi=BitmapFactory.decodeResource(applicationContext.resources,R.drawable.izmirsaat)
        val central=BitmapFactory.decodeResource(applicationContext.resources,R.drawable.central)
        val galata=BitmapFactory.decodeResource(applicationContext.resources,R.drawable.galata)
        val empire=BitmapFactory.decodeResource(applicationContext.resources,R.drawable.empire)

        var travelImages=ArrayList<Bitmap>()
        travelImages.add(saatKulesi)
        travelImages.add(central)
        travelImages.add(galata)
        travelImages.add(empire)

         */

        //Bitmap' i imagelerin ID' si olarak atmak için degiskenlere atiyoruz
        val saatKulesi=R.drawable.izmirsaat
        val central=R.drawable.central
        val galata=R.drawable.galata
        val empire=R.drawable.empire

        //Int degiskenleri listeye atiyoruz
        var travelImagesID=ArrayList<Int>()
        travelImagesID.add(saatKulesi)
        travelImagesID.add(central)
        travelImagesID.add(galata)
        travelImagesID.add(empire)




        //Adapter (Tasarım - Veri Iliskisi)
        //val adapter =ArrayAdapter(this,android.R.layout.simple_list_item_1,travelNames)
        val adapter =ArrayAdapter(this,R.layout.list_row,R.id.textView,travelNames)

        listView.adapter=adapter

        //ListView click ozelligi verip DetailActivity' e gitmek
        listView.onItemClickListener=AdapterView.OnItemClickListener { parent, view, position, id ->
            val intent=Intent(applicationContext,DetailActivity::class.java)

            intent.putExtra("name",travelNames[position])

            //Int ile alinan verileri intent ile yolluyoruz.
            intent.putExtra("image",travelImagesID[position])

            val singleton=Singleton.Selected
            //singleton.selectedImage=travelImages[position]
            //Global tanimlamalar cok tercih edilmez
            //selectedGlobalBitmap=travelImages[position]
            startActivity(intent)
        }

    }
}