package com.linet.carhire;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Dsignup extends AppCompatActivity {
    private Button mGmail, mManual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dsignup);

        mGmail = (Button) findViewById(R.id.button8);
        mManual = (Button) findViewById(R.id.button9);

        mGmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dsignup.this, Dgmail.class);
                startActivity(intent);
                finish();
                return;
            }
        });

        mManual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dsignup.this, Dmanual.class);
                startActivity(intent);
                finish();
                return;
            }
        });
    }
}
