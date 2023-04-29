package com.example.photoalbumpreview;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private final int[] photos = {R.drawable.photo1,
            R.drawable.photo2,
            R.drawable.photo3,
            R.drawable.photo4,
            R.drawable.photo5,
            R.drawable.photo6,
            R.drawable.photo7,
            R.drawable.photo8,
            R.drawable.photo9};
    private ImageView imageView;
    private int currentPhotoIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        Button rotateButton = findViewById(R.id.rotateButton);
        Button zoomInButton = findViewById(R.id.zoomInButton);
        Button zoomOutButton = findViewById(R.id.zoomOutButton);
        FloatingActionButton prevButton = findViewById(R.id.prev_button);
        FloatingActionButton nextButton = findViewById(R.id.next_button);

        // Set the initial photo
        imageView.setImageResource(photos[currentPhotoIndex]);

        // Set click listeners for the buttons
        rotateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float rotation = imageView.getRotation() + 90f;
                imageView.setRotation(rotation);
            }
        });

        zoomInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float scale = imageView.getScaleX() + 0.1f;
                imageView.setScaleX(scale);
                imageView.setScaleY(scale);
            }
        });

        zoomOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float scale = imageView.getScaleX() - 0.1f;
                imageView.setScaleX(scale);
                imageView.setScaleY(scale);
            }
        });

        // Set click listener for the next button
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Increment the photo index and set the new photo
                currentPhotoIndex = (currentPhotoIndex + 1) % photos.length;
                imageView.setImageResource(photos[currentPhotoIndex]);
            }
        });

        //set click listener to the prev button
        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Decrement the photo index
                currentPhotoIndex = (currentPhotoIndex - 1);
                if(currentPhotoIndex < 0) {
                    currentPhotoIndex += photos.length;
                }
                imageView.setImageResource(photos[currentPhotoIndex]);
            }
        });

        //set click listener to image view
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float rotation = imageView.getRotation() + 0f;
                imageView.setRotation(rotation);
            }
        });
    }
}