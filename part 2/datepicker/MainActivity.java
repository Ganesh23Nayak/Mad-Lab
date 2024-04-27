package com.example.datepicker;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
DatePicker dp;
ArrayAdapter ad;

String s1,date;
String s2[]={"cse","ise","me","aiml","ri"};



Spinner sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EdgeToEdge.enable(this);
        dp=findViewById(R.id.datep);
        sp=findViewById(R.id.spinner);
        sp.setOnItemSelectedListener(this);
        ad=new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,s2);
        sp.setAdapter(ad);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
 s1=ad.getItem(position).toString();
 date=dp.getDayOfMonth()+"-"+(dp.getMonth()+1)+"-"+dp.getYear();

    String t="Joined on "+date+" Branch "+s1;

    Toast.makeText(getApplicationContext(), t, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}