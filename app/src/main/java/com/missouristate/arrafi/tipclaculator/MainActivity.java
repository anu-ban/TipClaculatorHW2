package com.missouristate.arrafi.tipclaculator;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    private TipCalculator tipCal;
    public NumberFormat money = NumberFormat.getCurrencyInstance( );

    private EditText enterBill;
    private EditText enterTip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tipCal = new TipCalculator( 0.17f, 100.0f );
        setContentView(R.layout.activity_main);
    }

    public void btn_Click(View view) {
        enterTip = findViewById(R.id.editTextEnter_Tip);
        enterBill = findViewById(R.id.editTextEnterBill);

        String billString = enterBill.getText().toString();
        String tipString = enterTip.getText().toString();

        TextView tipTotalView = findViewById(R.id.textViewTotalTip);
        tipTotalView.setText("");
        TextView billTotalView = findViewById(R.id.textViewTotalBill);
        billTotalView.setText("");

        try{
            float billAmount = Float.parseFloat(billString);
            int tipPercent = Integer.parseInt(tipString);
            tipCal.setBill(billAmount);
            tipCal.setTip(tipPercent);

            float tipTotal = tipCal.tipAmount();
            float totalBill = tipCal.totalAmount();

            tipTotalView.setText(money.format(tipTotal));
            billTotalView.setText(money.format(totalBill));

        }
        catch (NumberFormatException nfe){

        }
    }
}
