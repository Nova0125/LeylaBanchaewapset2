package com.example.bliss.leylabanchaewa_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    InputStream stream = null;
    Story story;
    String story_text;
    String[] file_list = new String[] {"madlib0_simple.txt", "madlib1_tarzan.txt",
            "madlib2_university.txt", "madlib3_clothes.txt", "madlib4_dance.txt"};
    Random generator = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        if (stream == null) {

            int randomIndex = generator.nextInt(file_list.length);

            try {
                stream = getAssets().open(file_list[randomIndex]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        story = new Story(stream);

        TextView textView = findViewById(R.id.textView4);
        textView.setText(String.format("%d words left!", story.getPlaceholderRemainingCount()));

        TextView textHint = findViewById(R.id.textView5);
        textHint.setText(story.getNextPlaceholder());

    }

    public void nextPlaceholder (View view) {

        TextView textView = findViewById(R.id.textView4);
        TextView textHint = findViewById(R.id.textView5);
        EditText editText = findViewById(R.id.editText4);

        if (story.getPlaceholderRemainingCount() > 1) {
            String word = editText.getText().toString();
            story.fillInPlaceholder(word);

            textHint.setText(story.getNextPlaceholder());
            textView.setText(String.format("%d words left!", story.getPlaceholderRemainingCount()));
            editText.setText("");
        }
        else {
            String word = editText.getText().toString();
            story.fillInPlaceholder(word);
            textView.setText(String.format("%d words left!", story.getPlaceholderRemainingCount()));
            editText.setText("");

            gotoThird();
        }
    }

    public void gotoThird() {

        story_text = story.toString();

        Intent intent = new Intent(this, ThirdActivity.class);
        intent.putExtra("text", story_text);

        startActivity(intent);
        finish();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putSerializable("stored_story", story);
    }

    @Override
    public void onRestoreInstanceState(Bundle inState) {
        super.onRestoreInstanceState(inState);

        inState.getSerializable("stored_story");

        TextView textView = findViewById(R.id.textView4);
        textView.setText(String.format("%d words left!", story.getPlaceholderRemainingCount()));
    }

}
