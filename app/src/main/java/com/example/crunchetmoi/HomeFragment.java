package com.example.crunchetmoi;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private ImageButton imageEntreprise,imageSujet,imageLoisir;
    private CardView cardEntreprise, cardLoisir,cardSujet,cardNotification;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_home, container, false);

        imageEntreprise = v.findViewById(R.id.imageEntreprise);
        imageSujet = v.findViewById(R.id.imageSujets);
        imageLoisir= v.findViewById(R.id.imageLoisirs);
        cardEntreprise = v.findViewById(R.id.entreprise);
        cardSujet = v.findViewById(R.id.sujets);
        cardLoisir = v.findViewById(R.id.loisirs);
        cardNotification = v.findViewById(R.id.notification);




        cardEntreprise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Vous pourrez aussi consulter la liste des sujets déposés par chaque entreprise", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getActivity(), OngletEntreprise.class);
                startActivity(intent);
            }
        });

        cardSujet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), OngletSujets.class);
                startActivity(intent);
            }
        });

        cardLoisir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), OngletLoisirs.class);
                startActivity(intent);
            }
        });

        cardNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), OngletNotification.class);
                startActivity(intent);
            }
        });

        imageEntreprise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), OngletEntreprise.class);
                startActivity(intent);
            }
        });

        imageSujet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), OngletSujets.class);
                startActivity(intent);
            }
        });

        imageLoisir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), OngletLoisirs.class);
                startActivity(intent);
            }
        });

        return v;
    }
}
