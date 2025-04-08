package com.example.careerexplorer;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CareerListActivity extends AppCompatActivity {

    TextView interestTitle;
    LinearLayout careerContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_career_list);

        interestTitle = findViewById(R.id.interestTitle);
        careerContainer = findViewById(R.id.careerContainer);

        String interest = getIntent().getStringExtra("selectedInterest");
        interestTitle.setText("Interest: " + interest);

        String[] careers = getCareersForInterest(interest);

        // Dynamically add each career as a button
        for (String career : careers) {
            Button btn = new Button(this);
            btn.setText(career.replace("• ", "").trim());
            btn.setAllCaps(false);
            btn.setTextSize(16);
            btn.setBackgroundColor(Color.parseColor("#E0F7FA"));
            btn.setTextColor(Color.BLACK);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(0, 10, 0, 10);
            btn.setLayoutParams(params);

            btn.setOnClickListener(v -> {
                Intent intent = new Intent(CareerListActivity.this, CareerDetailActivity.class);
                intent.putExtra("career", btn.getText().toString());
                startActivity(intent);
            });

            careerContainer.addView(btn);
        }
    }

    private String[] getCareersForInterest(String interest) {
        switch (interest) {
            case "Engineering":
                return new String[]{"• Software Engineer", "• Mechanical Engineer", "• Civil Engineer", "• Data Scientist"};
            case "Medical":
                return new String[]{"• Doctor", "• Dentist", "• Pharmacist", "• Nurse"};
            case "Arts":
                return new String[]{"• Graphic Designer", "• Animator", "• Writer", "• Photographer"};
            case "Commerce":
                return new String[]{"• Accountant", "• Business Analyst", "• Economist", "• Stock Broker"};
            default:
                return new String[]{"No careers found."};
        }
    }
}
