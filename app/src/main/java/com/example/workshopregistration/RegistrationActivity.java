package com.example.workshopregistration;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegistrationActivity extends AppCompatActivity {
    private EditText editTextName, editTextAge, editTextEmail;
    private RadioGroup radioGroupGender;
    private SeekBar seekBarFitnessLevel;
    private RatingBar ratingBarInterest;
    private Switch switchEmailReminders;
    private CheckBox checkBoxTerms;
    private Button buttonSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        editTextName = findViewById(R.id.editTextName);
        editTextAge = findViewById(R.id.editTextAge);
        editTextEmail = findViewById(R.id.editTextEmail);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        seekBarFitnessLevel = findViewById(R.id.seekBarFitnessLevel);
        ratingBarInterest = findViewById(R.id.ratingBarInterest);
        switchEmailReminders = findViewById(R.id.switchEmailReminders);
        checkBoxTerms = findViewById(R.id.checkBoxTerms);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                String age = editTextAge.getText().toString();
                String email = editTextEmail.getText().toString();
                int selectedGenderId = radioGroupGender.getCheckedRadioButtonId();
                RadioButton selectedGenderButton = findViewById(selectedGenderId);
                String gender = (selectedGenderButton != null) ? selectedGenderButton.getText().toString() : "Not selected";

                int fitnessLevel = seekBarFitnessLevel.getProgress();

                float interestRating = ratingBarInterest.getRating();

                boolean emailReminders = switchEmailReminders.isChecked();


                boolean termsAccepted = checkBoxTerms.isChecked();

                if (!termsAccepted) {
                    Toast.makeText(RegistrationActivity.this, "Please agree to the Terms and Conditions", Toast.LENGTH_SHORT).show();
                    return;
                }

                Log.d("Registration", "Name: " + name);
                Log.d("Registration", "Age: " + age);
                Log.d("Registration", "Email: " + email);
                Log.d("Registration", "Gender: " + gender);
                Log.d("Registration", "Fitness Level: " + fitnessLevel);
                Log.d("Registration", "Interest Rating: " + interestRating);
                Log.d("Registration", "Email Reminders: " + (emailReminders ? "Yes" : "No"));
                Log.d("Registration", "Terms Accepted: " + (termsAccepted ? "Yes" : "No"));


                Toast.makeText(RegistrationActivity.this, "Registrated", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(RegistrationActivity.this,LastActivity.class);
                startActivity(intent);
                finish();

            }
        });



    }
}