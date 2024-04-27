package com.example.resume;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText name, email, phone, quali;
    Button upload, submit;
    RadioGroup r;
    RadioButton male, female;
    ImageView imgv;
    Bitmap ibit;
    static final int REQUEST_IMAGE_CAPTURE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        quali = findViewById(R.id.quali);
        imgv = findViewById(R.id.imageView);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        r = findViewById(R.id.gender);
        upload = findViewById(R.id.upload);
        submit = findViewById(R.id.button);

        upload.setOnClickListener(v -> dispatchTakePictureIntent());

        submit.setOnClickListener(v -> {
            String n = name.getText().toString();
            String e = email.getText().toString();
            String p = phone.getText().toString();
            String q = quali.getText().toString();
            String g = male.isChecked() ? "Male" : "Female";

            Intent i = new Intent(MainActivity.this, MainActivity2.class);
            i.putExtra("name", n);
            i.putExtra("email", e);
            i.putExtra("gender", g);
            i.putExtra("phone", p);
            i.putExtra("quali", q);
            i.putExtra("image", ibit);

            startActivity(i);
        });
    }

    private void dispatchTakePictureIntent() {
        Intent pickPhoto = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        pickPhoto.setType("image/*");
        startActivityForResult(pickPhoto, REQUEST_IMAGE_CAPTURE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            try {
                Uri selectedImage = data.getData();
                Bitmap originalBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImage);
                Bitmap resizedBitmap = Bitmap.createScaledBitmap(originalBitmap, 200, 200, false);
                ibit = resizedBitmap;
                imgv.setImageBitmap(ibit);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}