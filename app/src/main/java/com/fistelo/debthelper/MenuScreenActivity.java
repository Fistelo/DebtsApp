package com.fistelo.debthelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MenuScreenActivity extends AppCompatActivity {

    private static final String TAG = MenuScreenActivity.class.getSimpleName();

    private Button newDebtButton, yourDebtsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_screen);

        newDebtButton = (Button) findViewById(R.id.new_debt_button);
        yourDebtsButton = (Button) findViewById(R.id.debts_button);
        yourDebtsButton.setOnClickListener(onClickListener);
        newDebtButton.setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.debts_button:
                    break;
                case R.id.new_debt_button:
                    Intent intent = new Intent(MenuScreenActivity.this, NewDebtActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };


}
