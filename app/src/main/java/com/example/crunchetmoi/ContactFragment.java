package com.example.crunchetmoi;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContactFragment extends Fragment {

    ListView listView;
    String mTitle[] = {"Mr Nigro", "Mr Dupont", "Mr Durant", "Mr jacques Pythagore", "Mr pierre ange"};
    String mDescription[] = {"Enseignant IHM, 0325715690", "Enseignant developpement web, 0325715690", "Enseignant developpement mobile, 0325715690", "Enseignant modélisation mécanique, 0325715690", "Enseignant traitement, 0325715690"};


    public ContactFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_contact, container, false);

        listView = v.findViewById(R.id.listView);
        // now create an adapter class

        MyAdapter adapter = new MyAdapter(getActivity(), mTitle, mDescription);
        listView.setAdapter(adapter);
        // there is my mistake...
        // now again check this..

        // now set item click on list view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==  0) {

                }
                if (position ==  1) {
            }
                if (position ==  2) {
              }
                if (position ==  3) {
              }
                if (position ==  4) {
                 }
            }
        });
        // so item click is done now check list view
        return v;
    }


    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        String rDescription[];

        MyAdapter(Context c, String[] title, String[] description) {
            super(c, R.layout.rownotification, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.rownotification, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView myDescription = row.findViewById(R.id.textView2);

            // now set our resources on views
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);


            return row;
        }
    }
}
