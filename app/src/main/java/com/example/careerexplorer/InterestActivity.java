package com.example.careerexplorer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class InterestActivity extends AppCompatActivity {

    Button btnEngineering, btnMedical, btnArts, btnCommerce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest);

        btnEngineering = findViewById(R.id.btnEngineering);
        btnMedical = findViewById(R.id.btnMedical);
        btnArts = findViewById(R.id.btnArts);
        btnCommerce = findViewById(R.id.btnCommerce);

        // Set click listeners to open CareerListActivity with selected interest
        btnEngineering.setOnClickListener(v -> openCareerList("Engineering"));
        btnMedical.setOnClickListener(v -> openCareerList("Medical"));
        btnArts.setOnClickListener(v -> openCareerList("Arts"));
        btnCommerce.setOnClickListener(v -> openCareerList("Commerce"));
    }

    // This function sends selected interest to CareerListActivity
    private void openCareerList(String interest) {
        Intent intent = new Intent(InterestActivity.this, CareerListActivity.class);
        intent.putExtra("selectedInterest", interest);
        startActivity(intent);
    }
}
