package com.example.order;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox pizza,burger,pepsi,coke;
    TextView bill;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pizza=findViewById(R.id.pizza);
        burger=findViewById(R.id.burger);
        pepsi=findViewById(R.id.pepsi);
        coke=findViewById(R.id.coke);

        btn=findViewById(R.id.button);
        bill=findViewById(R.id.bill);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int t=0;
                String msg="Your total Bill \n";

                if(pizza.isChecked())
                {
                    msg+="Pizza 200\n";
                    t+=200;
                }
                if(burger.isChecked())
                {
                    msg+="Burger 100\n";
                    t+=100;
                }
                if(pepsi.isChecked())
                {
                    msg+="pepsi 70\n";
                    t+=70;
                }
                if(coke.isChecked())
                {
                    msg+="Coke 50\n";
                    t+=50;
                }

               msg+="Total "+t+"\n";
                bill.setText(msg);
                Toast.makeText(MainActivity.this, "Order Placed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}