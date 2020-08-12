package com.melihakkose.travelbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

//import static com.melihakkose.travelbook.MainActivity.selectedImage;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ImageView imageView=findViewById(R.id.imageView);
        TextView textViewPlaceName=findViewById(R.id.textViewPlaceName);
        TextView textViewProvinceName=findViewById(R.id.textViewProvinceName);

        Intent intent=getIntent();

        String place=intent.getStringExtra("placename");
        String province=intent.getStringExtra("provincename");
        textViewPlaceName.setText(place);
        textViewProvinceName.setText(province);
        Singleton singleton=Singleton.getInstance();
        imageView.setImageBitmap(singleton.getChosenImage());



        //imageView.setImageBitmap(selectedImage);

    }
}