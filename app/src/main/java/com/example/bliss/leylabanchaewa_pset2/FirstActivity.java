package com.example.bliss.leylabanchaewa_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;
import java.io.InputStream;

public class FirstActivity extends AppCompatActivity {

    InputStream stream = null;
    Story story;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);

        Intent intent = getIntent();
        intent.getStringExtra("clear");
    }

    public void gotoThird() {

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("story", story);

        startActivity(intent);
        finish();
    }

    public void getSimple(){
        try {
            stream = getAssets().open("madlib0_simple.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        story = new Story(stream);

        gotoThird();
    }

    public void getTarzan(){
        try {
            stream = getAssets().open("madlib1_tarzan.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        story = new Story(stream);

        gotoThird();
    }

    public void getUniversity(){
        try {
            stream = getAssets().open("madlib2_university.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        story = new Story(stream);
        gotoThird();
    }

    public void getClothes(){
        try {
            stream = getAssets().open("madlib3_clothes.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        story = new Story(stream);

        gotoThird();
    }

    public void getDance(){
        try {
            stream = getAssets().open("madlib4_dance.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        story = new Story(stream);

        gotoThird();
    }


}
