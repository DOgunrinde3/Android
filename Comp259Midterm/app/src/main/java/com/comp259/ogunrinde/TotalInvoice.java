package com.comp259.ogunrinde;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import org.w3c.dom.Text;


public class TotalInvoice extends Activity
{
    DepartmentClass deptotal;
    private EditText NetInvoice;
    private TextView Surcharge;
    private TextView TotalInvoice;
   private double surcharge;
    private double totalinvoice;
    private TextView DepartmentET2;
    private String departmentnum;
    private int depnum;



    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.totalinvoice_main);

        //auto object delcaration
        DepartmentET2 = (TextView) findViewById(R.id.textView10);
        NetInvoice = (EditText) findViewById(R.id.editText6);
        Surcharge = (TextView) findViewById(R.id.textView8);
        TotalInvoice =(TextView) findViewById(R.id.textView9);
        deptotal = new DepartmentClass();

       // netinvoice = NetInvoice.getText().toString();

        //this is for later
        //monthlyPayET = (TextView) findViewById(R.id.textView2);

        Button btnBack = (Button) findViewById(R.id.button);

        // PASS DATA
        //1. Create a intent with getIntent() method
        Intent intent = getIntent();
        //create an empty bundle
        Bundle result = new Bundle();

        //pull the Bundle from the intent to the empty bundle
        result = intent.getExtras();
        //pull data from intent
        departmentnum = result.getString("DepartmentNumber");
        depnum= Integer.valueOf(departmentnum);
        deptotal.setDepartmentNum(depnum);

        NetInvoice.addTextChangedListener(FindNetInvoice);

     if (depnum > 2500) {
            DepartmentET2.setText("Your Department Number is: " + departmentnum+ " You will have a Surcharge");

       }
        else
           {
               DepartmentET2.setText("Your Department Number is: " + departmentnum);

           }

        btnBack.setOnClickListener(btnListener);

    }

    public void goDataEntry(View view) {
        finish();
    }

    private TextWatcher FindNetInvoice = new TextWatcher() {
        //THE INPUT ELEMENT IS ATTACHED TO AN EDITABLE,
        //THEREFORE THESE METHODS ARE CALLED WHEN THE TEXT IS CHANGED

        public void onTextChanged(CharSequence s,
                                  int start, int before, int count){
            //CATCH AN EXCEPTION WHEN THE INPUT IS NOT A NUMBER
            try {

                deptotal.setNetInvoice(Double.parseDouble(NetInvoice.getText().toString()));
            }catch (NumberFormatException e){
                deptotal.setNetInvoice(0);
            }
            collectInvoiceInputData();
            displayTotal();
        }
        public void afterTextChanged(Editable s) {}
        public void beforeTextChanged(CharSequence s,
                                      int start, int count, int after){}
    };

    private void collectInvoiceInputData() {


        //TASK 1 SET THE Surcharge
        deptotal.setSurcharge();
//TASK 2: SET THE Total Invoice
        deptotal.setTotalInvoice();
;
    }

    private void displayTotal() {
        //DISPLAY THE Surcharge and Total Invoice

        Surcharge.setText("$" + String.format("%.02f",
                deptotal.getSurcharge()));
        TotalInvoice.setText("$" + String.format("%.02f",
                deptotal.getTotalInvoice()));


    }


    View.OnClickListener btnListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View view)
        {

            Bundle returnBundle = new Bundle();
            returnBundle.putDouble("TotalInvoice",deptotal.getTotalInvoice());
            //declare intent that will go back to the first class
            Intent res = new Intent();

            //put bundle into the intent
            res.putExtras(returnBundle);
            //set target class for the intent
            // res.setClass(getApplicationContext(),PurchaseActivity.class);

            //send back the results
            setResult(1001,res);
            finish();


        }
    };


}
