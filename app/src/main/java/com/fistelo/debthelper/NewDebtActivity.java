package com.fistelo.debthelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Integer.parseInt;

public class NewDebtActivity extends AppCompatActivity {

    private static final String TAG = NewDebtActivity.class.getSimpleName();
    private EditText numberOfPeople, prize, description;
    private ListView listView;
    private ArrayAdapter<String> adapter;

    int debtorsNumber;

    List<String> debtors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_debt);

        initialize();
        adapter = new ArrayAdapter<>(this, R.layout.list_view_item, debtors);
        listView.setAdapter(adapter);

        numberOfPeople.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (!hasFocus && !numberOfPeople.getText().toString().matches("")) {
                    debtorsNumber = Integer.parseInt(numberOfPeople.getText().toString());
                    adjustListView();
                }
            }

        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selected = ((TextView) view.findViewById(R.id.list_view_item)).getText().toString();

            }
        });
    }

    private void initialize() {
        debtors = new ArrayList<>();
        numberOfPeople = (EditText) findViewById(R.id.numofppl_edittext);
        listView = (ListView) findViewById(R.id.people_list_view);
        debtors.add(Consts.noname);
    }

    private void adjustListView() {

        if (debtorsNumber < 1)
            debtorsNumber = 1;
        else if (debtorsNumber > Consts.NUMBER_OF_DEBTORS_TO_DIVIDE)
            debtorsNumber = Consts.NUMBER_OF_DEBTORS_TO_DIVIDE;

        int diff = debtorsNumber - debtors.size();

        if (debtors.size() < debtorsNumber)
            for (int i = 0; i < diff; i++)
                debtors.add(Consts.noname);
        else
            for (int i = 0; i < -diff; i++)
                debtors.remove(debtors.size() - 1);

    }
}

