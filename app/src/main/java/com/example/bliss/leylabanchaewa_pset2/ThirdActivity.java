package com.example.bliss.leylabanchaewa_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_layout);

        Intent intent = getIntent();
        String story = intent.getStringExtra("text");

        TextView textView = findViewById(R.id.textView2);
        textView.setText(String.format("%s", story));
    }

    public void gotoStart(View view) {

        Intent intent = new Intent(this, FirstActivity.class);

        startActivity(intent);
        finish();
    }
}
