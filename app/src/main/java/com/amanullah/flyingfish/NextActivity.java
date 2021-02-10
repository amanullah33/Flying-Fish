package com.amanullah.flyingfish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class NextActivity extends AppCompatActivity {

    ImageView imageView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        imageView = findViewById(R.id.img);
        button = findViewById(R.id.playAgainButtonId);

        String vv = getIntent().getStringExtra("key");

        if (vv.equals("7up")){
            imageView.setImageResource(R.drawable.one);
        }
        if (vv.equals("Coca Cola")){
            imageView.setImageResource(R.drawable.two);
        }
        if (vv.equals("Clemon")){
            imageView.setImageResource(R.drawable.three);
        }

        if (vv.equals("Fanta")){
            imageView.setImageResource(R.drawable.four);
        }
        if (vv.equals("Pran Up")){
            imageView.setImageResource(R.drawable.five);
        }

        if (vv.equals("Pepsi")){
            imageView.setImageResource(R.drawable.six);
        }
        if (vv.equals("Sprite")){
            imageView.setImageResource(R.drawable.seven);
        }

        if (vv.equals("Tiger")){
            imageView.setImageResource(R.drawable.eight);
        }
        if (vv.equals("Speed")){
            imageView.setImageResource(R.drawable.nine);
        }

        if (vv.equals("Black Horse")){
            imageView.setImageResource(R.drawable.ten);
        }
        if (vv.equals("Mountain Dew")){
            imageView.setImageResource(R.drawable.eleven);
        }

        if (vv.equals("Mojo")){
            imageView.setImageResource(R.drawable.twelve);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), StartActivity.class);
        startActivity(intent);
    }
}