package com.example.crunchetmoi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class disponibiliteCoach extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disponibilite_coach);


        button = findViewById(R.id.reservationconf);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(disponibiliteCoach.this, "votre reservation a été enregistrée", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(disponibiliteCoach.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }
}
