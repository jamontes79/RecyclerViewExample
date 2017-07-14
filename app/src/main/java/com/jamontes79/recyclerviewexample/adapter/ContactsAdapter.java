package com.jamontes79.recyclerviewexample.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jamontes79.recyclerviewexample.R;
import com.jamontes79.recyclerviewexample.data.Contact;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class ContactsAdapter extends
        RecyclerView.Adapter<ContactsAdapter.MyViewHolder> {

    private final OnItemClickListener listener;
    private List<Contact> contactList;
    private DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

    public interface OnItemClickListener {
        void onItemClick(Contact item);
    }
    /**
     * View holder class
     * */
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView contactText;
        public TextView birthdayText;

        public MyViewHolder(View view) {
            super(view);
            contactText = (TextView) view.findViewById(R.id.contactName);
            birthdayText = (TextView) view.findViewById(R.id.birthday);

        }
    }

    public ContactsAdapter(List<Contact> contactLists, OnItemClickListener listener) {
        this.contactList = contactLists;
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final Contact c = contactList.get(position);
        holder.contactText.setText(c.name);
        holder.birthdayText.setText(df.format(c.birthday));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(c);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row,parent, false);

        return new MyViewHolder(v);
    }
}
