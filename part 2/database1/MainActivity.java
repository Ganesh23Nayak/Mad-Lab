package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.ContentInfo;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
EditText name,age,address;
TextView res;
Button submit,display;
SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.name);
        age=findViewById(R.id.age);
        address=findViewById(R.id.address);
        res=findViewById(R.id.res);

        submit=findViewById(R.id.submit);
        display=findViewById(R.id.diplay);

        db=openOrCreateDatabase("mydb",MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS users (name TEXT, age TEXT, address TEXT)");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n,ad,ag;
                n=name.getText().toString();
                ad=address.getText().toString();
                ag=age.getText().toString();
                try{
                    ContentValues values=new ContentValues();
                    values.put("name",n);
                    values.put("age",ag);
                    values.put("address",ad);
                    db.insert("users",null,values);
                    Toast.makeText(MainActivity.this, "DataAdded Sucessfully", Toast.LENGTH_SHORT).show();
                    name.setText("");
                    address.setText("");
                    age.setText("");
                }catch (SQLException e)
                {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });


        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Cursor cursor=db.rawQuery("SELECT * FROM users",null);
                    StringBuilder sb=new StringBuilder();
                    if(cursor.moveToFirst()){
                        do{
                            String name = cursor.getString(0);
                            String age = cursor.getString(1);
                            String address = cursor.getString(2);
                            sb.append("Name: ").append(name).append(", Age: ").append(age).append(", Address: ").append(address).append("\n");
                        }while(cursor.moveToNext());
                        res.setText(sb.toString());
                        cursor.close();
                    }

                }catch (SQLException e)
                {
                    res.setText("Error displaying data: " + e.getMessage());
                }

            }
        });
    }
}