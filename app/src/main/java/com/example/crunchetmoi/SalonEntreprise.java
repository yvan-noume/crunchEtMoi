package com.example.crunchetmoi;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class SalonEntreprise extends AppCompatActivity {

    ListView listView;
    String mTitle[] = {"Facebook", "Safran", "PSA", "Michellin", "EDF"};
    String mDescription[] = {"Facebook sujets Crunch", "Safran sujets Crunch", "PSA sujets Crunch", "Michellin sujets Crunch", "EDF Sujets Crunch"};
    int images[] = {R.drawable.facebook, R.drawable.safran, R.drawable.psa, R.drawable.michellin, R.drawable.edf};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onglet_entreprise);

        listView = findViewById(R.id.listView);
        // now create an adapter class

        MyAdapter adapter = new MyAdapter(this, mTitle, mDescription, images);
        listView.setAdapter(adapter);
        // there is my mistake...
        // now again check this..

        // now set item click on list view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==  0) {
                    Intent intent = new Intent(SalonEntreprise.this, sujetEntreprise.class);
                    startActivity(intent);
                }
                if (position ==  1) {
                    Intent intent = new Intent(SalonEntreprise.this, sujetEntreprise.class);
                    startActivity(intent);                }
                if (position ==  2) {
                    Intent intent = new Intent(SalonEntreprise.this, sujetEntreprise.class);
                    startActivity(intent);                }
                if (position ==  3) {
                    Intent intent = new Intent(SalonEntreprise.this, sujetEntreprise.class);
                    startActivity(intent);                }
                if (position ==  4) {
                    Intent intent = new Intent(SalonEntreprise.this, sujetEntreprise.class);
                    startActivity(intent);                }
            }
        });
        // so item click is done now check list view
    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        String rDescription[];
        int rImgs[];

        MyAdapter (Context c, String title[], String description[], int imgs[]) {
            super(c, R.layout.row, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImgs = imgs;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView myDescription = row.findViewById(R.id.textView2);

            // now set our resources on views
            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);


            return row;
        }
    }
}
