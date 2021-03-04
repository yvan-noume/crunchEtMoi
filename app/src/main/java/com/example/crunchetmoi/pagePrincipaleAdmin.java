package com.example.crunchetmoi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class pagePrincipaleAdmin extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_principale_admin);

        bottomNavigationView = findViewById(R.id.bottomNav);
        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.nav_view);
        toolbar= findViewById(R.id.toolbar);

        bottomNavigationView.setOnNavigationItemSelectedListener(bottomNavMethod);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new HomeFragment()).commit();
        navigationView.setNavigationItemSelectedListener(this);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar
                ,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Intent intent;
        switch (menuItem.getItemId()){


            case R.id.nav_message:
                intent = new Intent(pagePrincipaleAdmin.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_chat:
                intent = new Intent(pagePrincipaleAdmin.this, pagePrincipaleRep.class);
                startActivity(intent);
                break;
            case R.id.nav_profile:
                intent = new Intent(pagePrincipaleAdmin.this, pagePrincipaleConf.class);
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
                        Intent intent = new Intent(pagePrincipaleAdmin.this, PageConnexion.class);
                        startActivity(intent);
                    }
                });
                break;

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }

    }

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
