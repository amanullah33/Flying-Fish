package com.amanullah.flyingfish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {

    String[] age, area, gender, softDrink;

    Spinner ageSpinner, areaSpinner, genderSpinner, softDrinkSpinner;
    Button showButton;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    SharedPreferences sharedPreferences;
    String firstTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        SharedPreferences sharedPreferences = getSharedPreferences("PREFERENCE", MODE_PRIVATE);

        firstTime = sharedPreferences.getString("firstTime", "");

        if (firstTime.equals("Yes")){

            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }else {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("firstTime", "Yes");
            editor.apply();
        }

        this.setTitle("Signup");

        age = getResources().getStringArray(R.array.age);
        area = getResources().getStringArray(R.array.area);
        gender = getResources().getStringArray(R.array.gender);
        softDrink = getResources().getStringArray(R.array.softDrink);

        ageSpinner = findViewById(R.id.ageSpinnerId);
        areaSpinner = findViewById(R.id.areaSpinnerId);
        genderSpinner = findViewById(R.id.genderSpinnerId);
        softDrinkSpinner = findViewById(R.id.softDrinkSpinnerId);

        showButton = findViewById(R.id.signUpBtnId);

        populateSpinnerAge();
        populateSpinnerGender();
        populateSpinnerArea();
        populateSpinnerSoftDrink();

        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("User");

                String age = ageSpinner.getSelectedItem().toString();
                String gender = genderSpinner.getSelectedItem().toString();
                String area = areaSpinner.getSelectedItem().toString();
                String softDrink = softDrinkSpinner.getSelectedItem().toString();

                String key = reference.push().getKey();

                UserHelperClass helperClass = new UserHelperClass(age, gender, area, softDrink);

                reference.child(key).setValue(helperClass);

                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void populateSpinnerAge() {

        ArrayAdapter<String> ageAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.age));
        ageAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ageSpinner.setAdapter(ageAdapter);

    }

    private void populateSpinnerGender() {

        ArrayAdapter<String> genderAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.gender));
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderSpinner.setAdapter(genderAdapter);

    }

    private void populateSpinnerArea() {

        ArrayAdapter<String> areaAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.area));
        areaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        areaSpinner.setAdapter(areaAdapter);

    }

    private void populateSpinnerSoftDrink() {

        ArrayAdapter<String> softDrinkAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.softDrink));
        softDrinkAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        softDrinkSpinner.setAdapter(softDrinkAdapter);

    }

}