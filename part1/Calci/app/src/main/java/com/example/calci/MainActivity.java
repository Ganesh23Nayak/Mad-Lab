package com.example.calci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{
Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,badd,bsub,bmul,bdiv,bans,bac;
String op1="";
String op2="";

String Ans="";

String opt="";
EditText t1,t2,t3,t4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        assignID(b0,R.id.btn_0);
        assignID(b1,R.id.btn_1);
        assignID(b2,R.id.btn_2);
        assignID(b3,R.id.btn_3);
        assignID(b4,R.id.btn_4);
        assignID(b5,R.id.btn_5);
        assignID(b6,R.id.btn_6);
        assignID(b7,R.id.btn_7);
        assignID(b8,R.id.btn_8);
        assignID(b9,R.id.btn_9);

        assignID(badd,R.id.btn_add);
        assignID(bsub,R.id.btn_sub);
        assignID(bdiv,R.id.btn_div);
        assignID(bmul,R.id.btn_mul);

        assignID(bac,R.id.btn_AC);
        assignID(bans,R.id.btn_equal);

        t1=findViewById(R.id.op1);
        t2=findViewById(R.id.op2);
        t3=findViewById(R.id.ans);
        t4=findViewById(R.id.opt);

    }

    void assignID(Button btn, int id){
        btn=findViewById(id);
        btn.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        Button btn = (Button) v;
        String btntxt = btn.getText().toString();

        if(btntxt.matches("[0-9]"))
        {
           if(opt.isEmpty())
           {
               op1+=btntxt;
               t1.setText(op1);
           }
           else{
               op2+=btntxt;
               t2.setText(op2);
           }

        }else{

            if(btntxt.equals("="))
            {
                if(!op1.isEmpty() && !op2.isEmpty() && !opt.isEmpty())
                {
//                    Log.d("oprea :" +op1 +op2 + opt,"done");
                    double res=calculate(Double.parseDouble(op1),Double.parseDouble(op2),opt);
                    t3.setText(Double.toString(res));
                    op1="";
                    op2="";
                    opt="";
                    t1.setText("");
                    t2.setText("");
                    t4.setText("");
                }
            }

            if(!op1.isEmpty() || btntxt.equals("*") || btntxt.equals("-") || btntxt.equals("/") || btntxt.equals("+") )
            {
              opt+=btntxt;
              t4.setText(opt);
            }
            if(btntxt.equals("AC"))
            {
                op1="";
                op2="";
                opt="";
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");

            }


        }

    }

    private double calculate(double operand1, double operand2, String operator) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 == 0) {
                    // Handle division by zero error
                    return Double.NaN; // Not a Number
                }
                return operand1/operand2;
            default:
                return Double.NaN; // Not a Number
        }
    }


}