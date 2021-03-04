package com.example.crunchetmoi;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

// activité qui correspond à la page principale des étudiants

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private GridLayout gridLayout;
    private ImageButton imageEntrprise;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNav);
        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.nav_view);
        toolbar= findViewById(R.id.toolbar);
        gridLayout = findViewById(R.id.monGrid);
        //imageEntrprise=findViewById(R.id.imageEntreprise);

        bottomNavigationView.setOnNavigationItemSelectedListener(bottomNavMethod);

        getSupportFragmentManager().beginTransaction().replace(R.id.container,new HomeFragment()).commit();
        navigationView.setNavigationItemSelectedListener(this);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar
        ,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


    }

    // methode permettant de récupérer les clics sur les items du menu du haut et afficher la page correspondante

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Intent intent;
        switch (menuItem.getItemId()){

            case R.id.nav_message:
                 intent = new Intent(MainActivity.this, reservationCoach.class);
                startActivity(intent);
                break;
            case R.id.nav_oral:
                intent = new Intent(MainActivity.this, pitch.class);
                startActivity(intent);
                break;
            case R.id.nav_entreprise:
                intent = new Intent(MainActivity.this, SalonEntreprise.class);
                startActivity(intent);
                break;
            case R.id.nav_depot:
                intent = new Intent(MainActivity.this, depot.class);
                startActivity(intent);
                break;
            case R.id.nav_deconnexion:
                AlertDialog alertDialog = new AlertDialog.Builder(this).setTitle("confirmation")
                        .setMessage("confirmation de la deconnexion").setPositiveButton("ok",null)
                        .setNegativeButton("annuler",null).show();

                Button positiveButton = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);

                positiveButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, PageConnexion.class);
                        startActivity(intent);
                    }
                });
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    // methode qui permet de gérer le clic sue le bouton retour du téléphone

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }

    }

    //méthode qui permet de gérer le clic sur les items du menu du bas et afficher le fragment correspondant

    private BottomNavigationView.OnNavigationItemSelectedListener bottomNavMethod= new
            BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                    Fragment fragment=null;
                    switch (menuItem.getItemId()){
                        case R.id.plan:
                            fragment = new AndroidFragment();
                            break;

                        case R.id.accueil:
                            fragment = new HomeFragment();
                            break;

                        case R.id.contact:
                            fragment = new ContactFragment();
                            break;
                        case R.id.profil:
                            fragment = new ProfilFragment();
                            break;
                        case R.id.aide:
                            fragment = new AideFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
                    return true;
                }
            };

}
