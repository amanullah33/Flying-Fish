package com.amanullah.flyingfish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class InsertActivity extends AppCompatActivity {

    Spinner insertSpinner;
    Button insertButton;

    TextView scoreTextView;


    String value, score1;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        insertSpinner = findViewById(R.id.insertSpinnerId);
        insertButton = findViewById(R.id.insertButtonId);
        scoreTextView = findViewById(R.id.displayScoreTextViewId2);

        score1 = getIntent().getExtras().get("score").toString();

        scoreTextView.setText("Score = "+score1);

        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                value = insertSpinner.getSelectedItem().toString();

                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("SoftDrink");

                String softDrink = insertSpinner.getSelectedItem().toString();

                String key = reference.push().getKey();

                SoftDrink softDrink1 = new SoftDrink(softDrink);

                reference.child(key).setValue(softDrink1);

                Intent intent = new Intent(getApplicationContext(), NextActivity.class);
                intent.putExtra("key", value);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        onDestroy();
    }

}