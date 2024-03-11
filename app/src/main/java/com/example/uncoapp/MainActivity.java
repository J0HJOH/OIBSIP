package com.example.uncoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity
        extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener {

    String[] units = {
           " cm","yard","mm","foot","meters","miles", "nanometer", "inches","kilometer"
    };

//Declaring the Widgets
    EditText editText;
    TextView cm,foot,mm,nm,meters,miles, yard, inches,kilometer;
    Spinner  convertTo;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Instantiating Widgets
        cm = findViewById(R.id.cm);
        foot = findViewById(R.id.foot);
        mm = findViewById(R.id.mm);
        yard = findViewById(R.id.yard);
        meters = findViewById(R.id.meters);
        miles = findViewById(R.id.mile);
        nm = findViewById(R.id.nm);
        inches = findViewById(R.id.inches);
        kilometer = findViewById(R.id.km);

        editText = findViewById(R.id.num_Input);
//        convertFrom = findViewById(R.id.convert_from);
        convertTo = findViewById(R.id.convert_to);

//        This tells the app which item of the spinner is clicked
        convertTo.setOnItemSelectedListener(this);
//        convertFrom.setOnItemSelectedListener(this);

//        Creating an instance of Array adapter and this appends the
//        list of items to a spinner layout so the adapter can manage it
        ArrayAdapter ad = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item,
                units);

//sets simple layout for each spinner item
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

//        sets adapter which binds data to the spinner
//        convertFrom.setAdapter(ad);
        convertTo.setAdapter(ad);


////        Storing the user input as a string
//        String input  = editText.getText().toString();




        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                updateFig();
            }

        });



    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        updateFig();
    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


public void updateFig(){
        String input = editText.getText().toString();
//        String selectedUnit = convertFrom.getSelectedItem().toString();
        String convertingUnit = convertTo.getSelectedItem().toString();
    if(!input.equals("")
//            && !selectedUnit.equals("")
            && !convertingUnit.equals("")
    ){
        //        Changing the string to a double
        double num = Double.parseDouble(input);

//        Convert to these different cases
        switch (convertingUnit){
            case "meters" :
            case "yard" :
            case "kilometer" :
            case "inches" :
            case "miles" :
            case "cm" :
            case "foot" :
            case "nanometer" :
                setM(num);
                break;
        }

    }else {
        Toast.makeText(this, "Please select the units" , Toast.LENGTH_SHORT).show();
    }

}

    private void setM(double m_num) {
        meters.setText(String.valueOf(m_num + "cm"));
        kilometer.setText(String.valueOf(m_num/1000 + "cm"));
        inches.setText(String.valueOf(m_num *39.37 + "cm"));
        foot.setText(String.valueOf(m_num* 3.281 + "cm"));
        cm.setText(String.valueOf(m_num * 100 + "cm"));
        nm.setText(String.valueOf(m_num * 1000000000 + "cm"));
        miles.setText(String.valueOf(m_num/1609 + "cm"));
        mm.setText(String.valueOf(m_num * 1000 + "cm"));
        yard.setText(String.valueOf(m_num * 1.094 + "cm"));
    }
}