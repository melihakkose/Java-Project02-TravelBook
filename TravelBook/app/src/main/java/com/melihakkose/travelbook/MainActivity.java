package com.melihakkose.travelbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
     //static Bitmap selectedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView=findViewById(R.id.listView);
        //DATA

        final ArrayList<String> placeNames=new ArrayList<>();
        placeNames.add("Saat Kulesi");
        placeNames.add("Galata Kulesi");
        placeNames.add("Ayasofya Cami");
        placeNames.add("Efes Antik Kenti");

        final ArrayList<String>provinceNames=new ArrayList<>();
        provinceNames.add("İzmir");
        provinceNames.add("İstanbul");
        provinceNames.add("İstanbul");
        provinceNames.add("İzmir");

        Bitmap saatkulesi= BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.saatkulesi);
        Bitmap galata= BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.galata);
        Bitmap cami= BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.cami);
        Bitmap efes= BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.efes);

        final ArrayList<Bitmap> placeImages=new ArrayList<>();
        placeImages.add(saatkulesi);
        placeImages.add(galata);
        placeImages.add(cami);
        placeImages.add(efes);


        //LISTVIEW

        ArrayAdapter arrayAdapter=new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,placeNames);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println(placeNames.get(i));
                System.out.println(provinceNames.get(i));
                Intent intent=new Intent(getApplicationContext(),DetailActivity.class);
                intent.putExtra("placename",placeNames.get(i));
                intent.putExtra("provincename",provinceNames.get(i));
                //selectedImage=placeImages.get(i);
                Singleton singleton=Singleton.getInstance();
                singleton.setChosenImage(placeImages.get(i));







                startActivity(intent);


            }
        });


    }
}