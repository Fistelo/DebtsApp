package com.fistelo.debthelper;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.fistelo.debthelper.customlist.CustomArrayAdapter;
import com.fistelo.debthelper.customlist.Fraction;
import com.fistelo.debthelper.customlist.ListData;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class NewDebtActivity extends AppCompatActivity {

    private static final String TAG = NewDebtActivity.class.getSimpleName();
    private EditText prize, description;
    private Button plusDebtorButton, minusDebtorButton;

    private ListView listView;
    private CustomArrayAdapter adapter;
    private ListData listData;
    private Dialog AddDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_debt);

        initialize();
        adapter = new CustomArrayAdapter(this, listData);
        listView.setAdapter(adapter);

    }

    private void popUpAddWindow(){
        AddDialog = new Dialog(NewDebtActivity.this);
        AddDialog.setContentView(R.layout.debtor_details_popup);
        AddDialog.setTitle("Add new debtor");



    }

    private void initialize() {

        listData = new ListData();
        listView = (ListView) findViewById(R.id.people_list_view);

        plusDebtorButton = (Button) findViewById(R.id.plusPerson);
        minusDebtorButton = (Button) findViewById(R.id.minusPerson);
        plusDebtorButton.setOnClickListener(onClickListener);
        minusDebtorButton.setOnClickListener(onClickListener);

        listData.addDebtor(Consts.noname);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.minusPerson:
                    deletePerson();
                    break;
                case R.id.plusPerson:
                    addPerson();
                    break;
            }
        }
    };

    private void deletePerson(){
        if(listData.getDebtors().size()>1){
            Log.d(TAG, "USUWAM OSOBE");
            listData.removeLast();
            adapter.notifyDataSetChanged();
        }
    }

    private void addPerson(){
        if (listData.getDebtors().size() < Consts.NUMBER_OF_DEBTORS_TO_DIVIDE) {
            Log.d(TAG, "DODAJE OSOBE");
            listData.addDebtor(Consts.noname);
            adapter.notifyDataSetChanged();
        }
    }
}

