package com.example.components;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtUsername, edtPassword;
    Button btnLogin;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName= edtUsername.getText().toString();
                String passWord=edtPassword.getText().toString();
                Log.d("TAG", "onClick: Usernname:  "+ userName +
                        "\tPaass: "+ passWord);
//                tvResult.setText("User name: "+ userName
//                        + "\nPassword:*******"  );

                Toast.makeText( getBaseContext(), "Đăng nhập thành công", Toast.LENGTH_LONG ).show();

            }
        });
    }

    public void AnhXa(){
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword= findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvResult=findViewById(R.id.tvResult);
    }
}