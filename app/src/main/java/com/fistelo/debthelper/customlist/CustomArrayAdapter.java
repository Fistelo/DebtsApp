package com.fistelo.debthelper.customlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.fistelo.debthelper.R;

import java.util.List;

/**
 * Created by rados on 23.09.2017.
 */

public class CustomArrayAdapter extends ArrayAdapter<String> {
    private final Context context;
    private List<String> nameValues;
    private List<Fraction> tootValues;


    public CustomArrayAdapter(Context context, ListData listData) {
        super(context, R.layout.list_view_item, listData.getDebtors());
        this.context = context;
        this.nameValues = listData.getDebtors();
        this.tootValues = listData.getDebtorToot();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.list_view_item, parent, false);

        TextView name = (TextView) rowView.findViewById(R.id.list_view_name);
        TextView number = (TextView) rowView.findViewById(R.id.list_view_number);

        name.setText(nameValues.get(position));
        number.setText(tootValues.get(position).toString());

        return rowView;
    }

    public String getNameValueFromPosition(int position) {
        return nameValues.get(position);
    }

    public Fraction getTootValueFromPosition(int position) {
        return tootValues.get(position);
    }

    public void setNameValueAtPosition(int position, String value) {
        nameValues.set(position, value);
    }

    public void setTootValueAtPosition(int position, Fraction value) {
        tootValues.set(position, value);
    }
}
