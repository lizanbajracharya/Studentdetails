package com.example.studentdetails;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Spinner spinCountry;
    AutoCompleteTextView autoCompleteTextView;
    TextView tvOutput;
    Button btnSave;
    EditText etName;
    RadioButton rdoMale,rdoFemale,rdoOthers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     spinCountry=findViewById(R.id.spinCountry);
     rdoMale=findViewById(R.id.rdoMale);
     rdoFemale=findViewById(R.id.rdoFemale);
     rdoOthers=findViewById(R.id.rdoOthers);
     btnSave=findViewById(R.id.btnSave);
     tvOutput=findViewById(R.id.tvOutput);
     etName=findViewById(R.id.etName);

     String countries[]={"Nepal","India","China","UK","USA"};
        ArrayAdapter adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,countries);
        spinCountry.setAdapter(adapter);

        autoCompleteTextView=findViewById(R.id.autoCompleteTextView);

        String Batch[]={"Batch 22A","Batch 22B","Batch 22C"};
        ArrayAdapter adapter1=new ArrayAdapter<>(this,android.R.layout.select_dialog_item,Batch);

        autoCompleteTextView.setAdapter(adapter1);
        autoCompleteTextView.setThreshold(1);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=etName.getText().toString();
                String gender;
                if(rdoMale.isChecked())
                {
                    gender="Male";
                }
                else if(rdoFemale.isChecked())
                {
                    gender="Female";
                }
                else
                {
                    gender="Others";
                }
                String country=spinCountry.getSelectedItem().toString();
                String batch=autoCompleteTextView.getText().toString();
                tvOutput.setText("Name :"+ " " +name);
                tvOutput.append("Gender :"+ " " +gender);
                tvOutput.append("Country :"+ " " +country);
                tvOutput.append("Batch :"+ " " +batch);

            }
        });



    }
}
