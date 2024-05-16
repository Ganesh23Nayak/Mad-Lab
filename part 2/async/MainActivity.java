package com.example.async;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ThemedSpinnerAdapter;

public class MainActivity extends AppCompatActivity {

    Button btn;
    TextView t;
    ProgressBar p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=findViewById(R.id.button);
        t=findViewById(R.id.t);
        p=findViewById(R.id.progressBar);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                T t1=new T();
                t1.execute("100");
            }
        });
    }

    class T extends AsyncTask<String,Integer,String>{

        @Override
        protected String doInBackground(String... strings) {
            int max=Integer.parseInt(strings[0]);
            int i=0;
            while(i<max)
            {
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                i++;
                publishProgress(i);
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            p.setProgress(values[0]);
            t.setText(values[0].toString());
            super.onProgressUpdate(values);
        }
    }
}