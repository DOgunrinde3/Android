package com.comp259.ogunrinde;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DepartmentActivity extends AppCompatActivity
{
    DepartmentClass deptotal;
    private EditText DepartmentET;
    private EditText NetInvoice;
    private TextView Surcharge;
    private TextView TotalInvoice;
    private double totalInvoice;
    //private int DepartmentNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.department_main);

        DepartmentET = (EditText) findViewById(R.id.editText);
        TotalInvoice = (TextView) findViewById(R.id.textView7);


    }

    public void activateTotalInvoice(View view) {
        //Take from EditText and RadioButton  and put it to variable

        String departmentet;

        //take from Inputs and put them to the string
        departmentet= DepartmentET.getText().toString();





        //declare new Bundle
        Bundle b = new Bundle();
        //Add those variables to Bundle
        b.putString("DepartmentNumber",departmentet);


        //declare a new intent
        Intent launchReport = new Intent(this, TotalInvoice.class);

        //put Bundle to the Intent
        launchReport.putExtras(b);

        //start activity for result
        //that means we are expecting a return
        startActivityForResult(launchReport,1000);
        onActivityResult(1000,1001,getIntent());


    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode == 1000 && resultCode == 1001){
            try {
                   TotalInvoice.setText("");
                Bundle b = data.getExtras();
                totalInvoice = b.getDouble("TotalInvoice");
                TotalInvoice.setText("Your total invoice is: " + totalInvoice);


            }
            catch(Exception e)
            {
                e.printStackTrace();
                TotalInvoice.setText("");
            }
        }
    }

}
