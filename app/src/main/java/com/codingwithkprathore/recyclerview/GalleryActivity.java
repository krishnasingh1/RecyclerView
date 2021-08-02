package com.codingwithkprathore.recyclerview;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class GalleryActivity extends AppCompatActivity {

    private static final String TAG = "GalleryActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        Log.d(TAG, "onCreate: Started");

        getIncomimngIntant();


    }

    private void getIncomimngIntant() {

        Log.d(TAG, "getIncomimngIntant: checking for incoming intants");

        if (getIntent().hasExtra("image_url") && getIntent().hasExtra("image_name")){
            Log.d(TAG, "getIncomimngIntant: Found Intant extras");
            String imageUrl = getIntent().getStringExtra("image_url");
            String imageName = getIntent().getStringExtra("image_name");

            setImage(imageUrl, imageName);

        }
    }
    private void setImage( String imageUrl , String imageName) {
        Log.d(TAG, "setImage: setting to image and name to widgets");

        TextView name = findViewById(R.id.image_discription);
        name.setText(imageName);

        ImageView image = findViewById(R.id.image);
        Glide.with(this).asBitmap()
                .load(imageUrl)
                .into(image);



    }

}
