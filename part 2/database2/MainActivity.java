package com.example.calldb;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button add,b2;
    EditText name, usn,phone,callusn;
    SQLiteDatabase db = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add=findViewById(R.id.add);
        b2=findViewById(R.id.b2);

        name=findViewById(R.id.name);
        usn=findViewById(R.id.usn);
        phone=findViewById(R.id.phone);

        callusn=findViewById(R.id.call);

        db=openOrCreateDatabase("mydb",MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS users (name TEXT,usn TEXT,phone TEXT)");

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n,u,p;
                n=name.getText().toString();
                u=usn.getText().toString();
                p=phone.getText().toString();
                try{
                    ContentValues values=new ContentValues();
                    values.put("name",n);
                    values.put("usn",u);
                    values.put("phone",p);
                    db.insert("users",null,values);
                    Toast.makeText(MainActivity.this, "Added Sucessfully", Toast.LENGTH_SHORT).show();
                    name.setText("");
                    usn.setText("");
                    phone.setText("");
                }catch(SQLException e)
                {
                    Toast.makeText(MainActivity.this, "ERror", Toast.LENGTH_SHORT).show();
                }
            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usn = callusn.getText().toString();
                Cursor cursor = db.rawQuery("SELECT * FROM users WHERE usn=?", new String[]{usn});
                if (cursor.getCount() != 1) {
                    Toast.makeText(MainActivity.this, "Invalid", Toast.LENGTH_SHORT).show();
                } else {
                    cursor.moveToNext();
                    String ph = cursor.getString(2);

                    Intent i = new Intent(Intent.ACTION_DIAL);
                    i.setData(Uri.parse("tel:" + ph));
                    startActivity(i);
                }
            }
        });

    }

}