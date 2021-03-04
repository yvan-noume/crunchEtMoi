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
import android.widget.ListView;
import android.widget.TextView;

public class OngletSujets extends AppCompatActivity {

    ListView listView;
    String mTitle[] = {"conférence chaire connected", "conférence spaceX", "conférence innavation", "conférence datascience", "conférence big data"};
    String mDescription[] = {"inscrit", "non inscrit", "non inscrit", "non inscrit", "inscrit"};

    // so our images and other things are set in array

    // now paste some images in drawable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onglet_sujets);

        listView = findViewById(R.id.listView);
        // now create an adapter class

        MyAdapter adapter = new MyAdapter(this, mTitle, mDescription);
        listView.setAdapter(adapter);
        // there is my mistake...
        // now again check this..

        // now set item click on list view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==  0) {
                    Intent intent = new Intent(OngletSujets.this, sujetConference.class);
                    startActivity(intent);
                }
                if (position ==  1) {
                    Intent intent = new Intent(OngletSujets.this, sujetConference.class);
                    startActivity(intent);                }
                if (position ==  2) {
                    Intent intent = new Intent(OngletSujets.this, sujetConference.class);
                    startActivity(intent);                }
                if (position ==  3) {
                    Intent intent = new Intent(OngletSujets.this, sujetConference.class);
                    startActivity(intent);                }
                if (position ==  4) {
                    Intent intent = new Intent(OngletSujets.this, sujetConference.class);
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

        MyAdapter(Context c, String[] title, String description[]) {
            super(c, R.layout.rownotification, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;


        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.rownotification, parent, false);

            TextView myTitle = row.findViewById(R.id.textView1);
            TextView myDescription = row.findViewById(R.id.textView2);

            // now set our resources on views
            //images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);

            return row;
        }
    }
}
