package com.example.bliss.leylabanchaewa_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.io.InputStream;

public class SecondActivity extends AppCompatActivity {

    Story story;
    String story_text;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

//        Intent intent = getIntent();
//        story = intent.getParcelableExtra("story");

        TextView textView = findViewById(R.id.textView4);
        textView.setText(String.format("%d words left!", story.getPlaceholderRemainingCount()));

        EditText editText = findViewById(R.id.editText4);
        editText.setHint(story.getNextPlaceholder());

    }

    public void nextPlaceholder (View view) {

        TextView textView = findViewById(R.id.textView4);
        EditText editText = findViewById(R.id.editText4);

        String word = editText.getText().toString();
        story.fillInPlaceholder(word);

        editText.setHint(story.getNextPlaceholder());
        textView.setText(String.format("%d words left!", story.getPlaceholderRemainingCount()));
        editText.setText("");
    }

    public void gotoThird(View view) {

        story_text = story.toString();

        Intent intent = new Intent(this, ThirdActivity.class);
        intent.putExtra("text", story_text);

        startActivity(intent);
        finish();
    }

}
