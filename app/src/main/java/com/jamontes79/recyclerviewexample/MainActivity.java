package com.jamontes79.recyclerviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.jamontes79.recyclerviewexample.adapter.ContactsAdapter;
import com.jamontes79.recyclerviewexample.data.Contact;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rv = (RecyclerView) findViewById(R.id.recycler_view);

        ArrayList<Contact> contactList = Contact.GenerateContacts() ;
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(mLayoutManager);
        rv.setAdapter(new ContactsAdapter(contactList, new ContactsAdapter.OnItemClickListener() {
            @Override public void onItemClick(Contact item) {
                Toast.makeText(MainActivity.this, "Contact Clicked:" + item.name, Toast.LENGTH_LONG).show();
            }
        }));
    }
}
