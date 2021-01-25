package com.linet.carhire;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Rsignup extends AppCompatActivity {
    private Button mGmail1, mManual1;
    private TextView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rsignup);

        mGmail1 = (Button) findViewById(R.id.button6);
        mManual1 = (Button) findViewById(R.id.button7);
        back = (TextView) findViewById(R.id.back);

        mGmail1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Rsignup.this, Rgmail.class);
                startActivity(intent);
                finish();
                return;
            }
        });

        mManual1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Rsignup.this, Signup.class);
                startActivity(intent);
                finish();
                return;
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Rsignup.this, Login.class);
                startActivity(intent);
                finish();
                return;
            }
        });
    }
}
