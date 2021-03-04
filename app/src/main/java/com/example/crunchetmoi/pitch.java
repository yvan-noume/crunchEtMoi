package com.example.crunchetmoi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class pitch extends AppCompatActivity {
    private Switch aSwitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pitch);

        aSwitch = findViewById(R.id.switch1);

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true){
                    Toast.makeText(getBaseContext(), "vous participerez au pitch", Toast.LENGTH_LONG).show();

                }else {
                    Toast.makeText(getBaseContext(), "vous ne participerez pas au pitch", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
