package com.example.resume;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView name, email, phone, gender, quali;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        name = findViewById(R.id.namev);
        email = findViewById(R.id.emailv);
        phone = findViewById(R.id.phonev);
        gender = findViewById(R.id.genderv);
        quali = findViewById(R.id.qulificationv);
        img = findViewById(R.id.imageView2);

        Intent i = getIntent();
        if (i != null) {
            String na = i.getStringExtra("name");
            String ema = i.getStringExtra("email");
            String gen = i.getStringExtra("gender");
            String qua = i.getStringExtra("quali");
            String pho = i.getStringExtra("phone");
            Bitmap im = i.getParcelableExtra("image");


            name.setText("Name :" + na);
            email.setText("Email :" + ema);
            phone.setText("Phone " + pho);
            gender.setText("Gender :" + gen);
            quali.setText("Quali " + qua);

            runOnUiThread(() -> {
                if (im != null) {
                    img.setImageBitmap(im);
                } else {
                    img.setVisibility(View.GONE);
                }
            });
        }
    }
}