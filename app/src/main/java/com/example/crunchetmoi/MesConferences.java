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

public class MesConferences extends AppCompatActivity {

    ListView listView;
    String mTitle[] = {"conférence chaire connected", "conférence spaceX"};

    // so our images and other things are set in array

    // now paste some images in drawable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onglet_notification);

        listView = findViewById(R.id.listView);
        // now create an adapter class

        MyAdapter adapter = new MyAdapter(this, mTitle);
        listView.setAdapter(adapter);
        // there is my mistake...
        // now again check this..

        // now set item click on list view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==  0) {
                    Intent intent = new Intent(MesConferences.this, sujetConference.class);
                    startActivity(intent);
                }
                if (position ==  1) {
                    Intent intent = new Intent(MesConferences.this, sujetConference.class);
                    startActivity(intent);                }

            }
        });
        // so item click is done now check list view
    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        String rDescription[];


        MyAdapter(Context c, String[] title) {
            super(c, R.layout.rownotification, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.rownotification, parent, false);
            TextView myTitle = row.findViewById(R.id.textView1);

            // now set our resources on views
            myTitle.setText(rTitle[position]);


            return row;
        }
    }
}
