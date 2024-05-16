package com.example.sms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
Button btn;
EditText t1,t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.button);
        t1=findViewById(R.id.phone);
        t2=findViewById(R.id.msg);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message=t2.getText().toString();
                String phone=t1.getText().toString();
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("sms:"+phone));
                i.putExtra("sms_body",message);
                startActivity(i);


            }
        });
    }
}