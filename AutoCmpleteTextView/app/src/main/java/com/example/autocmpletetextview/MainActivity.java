package com.example.autocmpletetextview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    AutoCompleteTextView autoCompleteTextView;
    TextView textView, item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        autoCompleteTextView=findViewById(R.id.autoCpl);
        textView=findViewById(R.id.tvTitle);
        item=findViewById(R.id.tv_ct_name);

        String[] conntries= getResources().getStringArray(R.array.countries);
        ArrayAdapter arrayAdapter=  new ArrayAdapter(this, R.layout.custom_item, R.id.tv_ct_name, conntries);
        autoCompleteTextView.setAdapter(arrayAdapter);


        autoCompleteTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(count==0 | autoCompleteTextView.getText().toString().length()==count )
                    textView.setVisibility(View.GONE);
                else
                    textView.setVisibility(View.VISIBLE);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



    }
}