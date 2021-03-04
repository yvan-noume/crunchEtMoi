package com.example.crunchetmoi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class PageConnexion extends AppCompatActivity {

    Spinner spinner;
    String name[]={"rouge","bleu","vert"};
    ArrayAdapter <String> adapter;
    String record;
    TextView text;
    NavigationView navigationView;
    Button button,buttonWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_connexion);

        spinner = findViewById(R.id.spinner);

        navigationView=findViewById(R.id.nav_view);
        button = findViewById(R.id.button);
        buttonWeb = findViewById(R.id.button2);

        buttonWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://crunch-time-utt.geniusutt.fr/"));
                startActivity(browserIntent);
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 0:
                        record="Etudiants";
                        break;
                    case 1:
                        record="Conférencier";
                        break;
                    case 2:
                        record="Coach";
                        break;
                    case 3:
                        record="Représentant d'entreprise";
                        break;
                    case 4:
                        record="Administrateur";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void displayResult(View view){
        if(record=="Etudiants"){
            Intent intent = new Intent(PageConnexion.this, MainActivity.class);
            startActivity(intent);

        }else if(record=="Conférencier") {
            Intent intent = new Intent(PageConnexion.this, pagePrincipaleConf.class);
            startActivity(intent);
        }else if(record=="Coach"){
            Intent intent = new Intent(PageConnexion.this, pagePrincipaleCoach.class);
            startActivity(intent);
        }else if(record=="Représentant d'entreprise"){
            Intent intent = new Intent(PageConnexion.this, pagePrincipaleRep.class);
            startActivity(intent);
        }else {
            Intent intent = new Intent(PageConnexion.this, pagePrincipaleAdmin.class);
            startActivity(intent);
        }
    }

}
