package com.example.bobo.xamxam;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class LoginActivity extends AppCompatActivity {

    private Button button;

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        button = findViewById(R.id.button);

        imageView = findViewById(R.id.imageView);
//
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.xamxam);
//
//        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
//
//        roundedBitmapDrawable.setCircular(true);
//
//        imageView.setImageDrawable(roundedBitmapDrawable);

    }

    public void action(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
