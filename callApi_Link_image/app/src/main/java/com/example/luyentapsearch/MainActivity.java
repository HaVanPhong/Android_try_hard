package com.example.luyentapsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.luyentapsearch.Adapter.productAdapter;
import com.example.luyentapsearch.Model.product;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String URL="https://categoryandproduct.herokuapp.com/api/products";
    List<product> listProduct=new ArrayList<>();
    EditText edtSearch;
    String arrayProduct="";
    productAdapter productAdapter;
    ListView lvProduct;
    FloatingActionButton fabChangeBg;
    RelativeLayout rootRelativeLayout;
    int checkBgColor=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtSearch=findViewById(R.id.edtSearch);
        lvProduct=findViewById(R.id.lvShow);
        fabChangeBg=findViewById(R.id.fabChangeBg);
        rootRelativeLayout=findViewById(R.id.rootRelaytiveLayout);

        fabChangeBg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBgColor==1){
                    lvProduct.setBackgroundColor(getResources().getColor(R.color.black));
                    checkBgColor=-1;
                }else{
                    lvProduct.setBackgroundColor(getResources().getColor(R.color.white));
                    checkBgColor=1;
                }


//                rootRelativeLayout.setBackgroundColor(getResources().getColor(R.color.black));
            }
        });

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        StringRequest stringRequest=new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                arrayProduct=response;
                try {
                    JSONArray jsonArray=new JSONArray(arrayProduct);
                    int size=jsonArray.length();
                    for (int i=0; i<size; i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String imageLink = jsonObject.getString("imageLink");
                        String title = jsonObject.getString("title");
                        long price = jsonObject.getLong("price");


                        listProduct.add(new product(title, imageLink, price));
                        productAdapter = new productAdapter(listProduct, MainActivity.this, R.layout.custom_product_item);
                        lvProduct.setAdapter(productAdapter);


                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                arrayProduct="error";
            }
        });
        requestQueue.add(stringRequest);

        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String str=s.toString();
                if(str.compareTo("")==0){
                    productAdapter =new productAdapter(listProduct, MainActivity.this, R.layout.custom_product_item);
                    lvProduct.setAdapter(productAdapter);
                    return;
                }
                List<product> listTemp=new ArrayList<>();
                for (int i=0; i<listProduct.size(); i++){
                    if (listProduct.get(i).getTitle().toLowerCase().contains(str.toLowerCase())){
                        listTemp.add(listProduct.get(i));
                    }
                }
                productAdapter =new productAdapter(listTemp, MainActivity.this, R.layout.custom_product_item);
                lvProduct.setAdapter(productAdapter);



            }
        });




    }
}