package com.example.crunchetmoi;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class AndroidFragment extends Fragment {

    public AndroidFragment() {
        // Required empty public constructor
    }

    private Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_android, container, false);

        button = v.findViewById(R.id.android);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.fr/maps/place/Universit%C3%A9+de+Technologie+de+Troyes/@48.283221,3.9805813,11.75z/data=!4m8!1m2!2m1!1sutt!3m4!1s0x47ee99a0cb4a3a57:0x42148ce859fa2d02!8m2!3d48.269162!4d4.0667761"));
                startActivity(browserIntent);
            }
        });
        return v;
    }
}
