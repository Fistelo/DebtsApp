package com.fistelo.debthelper;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_debt);

        initialize();
        adapter = new CustomArrayAdapter(this, listData);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                    final int position2 = position;
                    String debtorName = adapter.getItem(position);
                    Fraction toot = adapter.getTootValueFromPosition(position);
                    final AlertDialog.Builder alertBuilder = new AlertDialog.Builder(NewDebtActivity.this);
                    View editDebtorView = getLayoutInflater().inflate(R.layout.debtor_details_popup, null);
                    final EditText debtorNameET = (EditText) editDebtorView.findViewById(R.id.debtorNameToEdit);
                    final EditText tootCounterPart = (EditText) editDebtorView.findViewById(R.id.tootCounterPart);
                    final EditText tootDenominatorPart = (EditText) editDebtorView.findViewById(R.id.tootDenominatorPart);
                    final Button applyButton = (Button) editDebtorView.findViewById(R.id.applyEditDebtorChanges);

                    debtorNameET.setText(debtorName);
                    tootCounterPart.setText(toot.getStringCounter());
                    tootDenominatorPart.setText(toot.getStringDenominator());

                    applyButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if(!debtorNameET.getText().toString().isEmpty() && !tootCounterPart.getText().toString().isEmpty()
                                    && !tootDenominatorPart.getText().toString().isEmpty()){
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        adapter.setNameValueAtPosition(position2, debtorNameET.getText().toString());
                                        adapter.setTootValueAtPosition(position2, new Fraction(Integer.parseInt(tootCounterPart.getText().toString()),
                                                Integer.parseInt(tootDenominatorPart.getText().toString())));
                                        adapter.notifyDataSetChanged();
                                    }
                                });
                            }else
                                Toast.makeText(NewDebtActivity.this, "Fill all of the fields",Toast.LENGTH_SHORT).show();
                        }
                    });

                    alertBuilder.setView(editDebtorView);
                    AlertDialog dialog = alertBuilder.create();
                    dialog.show();
                }
            }
        );
    }

    private void popUpEditWindow(final int position){

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

