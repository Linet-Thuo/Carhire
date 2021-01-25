package com.linet.carhire;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class User extends AppCompatActivity {
    private Button mDriver, mRider;
    private TextView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        mRider = (Button) findViewById(R.id.button);
        mDriver = (Button) findViewById(R.id.button1);
        back = (TextView) findViewById(R.id.textView14);

        mRider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(User.this, Login.class);
                startActivity(intent);
                finish();
                return;
            }
        });

        mDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(User.this, Dlogin.class);
                startActivity(intent);
                finish();
                return;
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(User.this, MainActivity.class);
                startActivity(intent);
                finish();
                return;
            }
        });
    }
}
