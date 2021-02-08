package com.amanullah.flyingfish2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameOverActivity extends AppCompatActivity {

    private Button aboutUsBtn, prizeBtn;
    private TextView displayScoreTextView;
    private String score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        score = getIntent().getExtras().get("score").toString();

        aboutUsBtn = findViewById(R.id.aboutUsBtnId);
        prizeBtn = findViewById(R.id.prizeBtnId);
        displayScoreTextView = findViewById(R.id.displayScoreTextViewId);

        prizeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(getApplicationContext(), InsertActivity.class);
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        aboutUsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AboutUsActivity.class);
                startActivity(intent);
            }
        });

        displayScoreTextView.setText("Score = "+score);
    }

    @Override
    public void onBackPressed() {
        onDestroy();
    }
}