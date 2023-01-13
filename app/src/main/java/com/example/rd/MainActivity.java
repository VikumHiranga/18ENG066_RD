package com.example.rd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {


    @SuppressLint("WrongThread")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.green_1)));

        new HttpCall().execute("http://192.168.43.19:3000/");

        // This part will check whether there is an anomaly or not. If anomaly is present, emergency will be 1 and it starts to indicate about the emergency to the train driver.
        // if (emergency == 1){
         //   getSupportFragmentManager().beginTransaction().setReorderingAllowed(true).add(R.id.fragmentContainerView,FirstFragment.class,null).commit();
       // }

    }

    public void pressCall (View view) throws IOException {

        Intent intent = new Intent(this,SecondActivity.class);
        startActivity(intent);
    }
}