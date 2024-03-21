package com.example.indexmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater i=getMenuInflater();
        i.inflate(R.menu.m1,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        int id=item.getItemId();
//        switch (id)
//        {
//            case R.id.item1:
//                Intent I=new Intent(this,MainActivity1.class);
//                startActivity(I);
//                return true;
//            case R.id.item2:
//                Intent I1=new Intent(this,MainActivity2.class);
//                startActivity(I1);
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//
//        }

        if(id==R.id.item1){
            Intent I=new Intent(this,MainActivity2.class);
            startActivity(I);
               return true;
        } else if (id==R.id.item2) {
            Intent I1=new Intent(this,MainActivity3.class);
                startActivity(I1);
                return true;
        }
        else{
            return super.onOptionsItemSelected(item);
        }

    }
}