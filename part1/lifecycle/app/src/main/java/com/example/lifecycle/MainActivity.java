package com.example.lifecycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.ShowableListMenu;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("LifeCycle","OnCreate invoked");
        showToast("On start Created");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LifeCycle","OnStop invoked");
        showToast("On Stop Created");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LifeCycle","OnPause invoked");
        showToast("On Pause Created");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LifeCycle","OnDestroy invoked");
        showToast("On Destroy Created");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("LifeCycle","OnRestart invoked");
        showToast("On Restart Created");
    }

    private void showToast(String message)
    {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}