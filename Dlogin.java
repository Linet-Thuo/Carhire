package com.linet.carhire;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Dlogin extends AppCompatActivity {
    private Button login;
    private TextView signup;
    private EditText email, password;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dlogin);

        mAuth = FirebaseAuth.getInstance();
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        firebaseAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if(user!=null){
                    Intent intent = new Intent(Dlogin.this, Dmap.class);
                    startActivity(intent);
                    finish();
                    return;
                }
            }
        };

        login = (Button) findViewById(R.id.button3);
        password = (EditText) findViewById(R.id.password1);
        email = (EditText) findViewById(R.id.email1);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String memail = email.getText().toString();
                final String mpassword = password.getText().toString();
                if (TextUtils.isEmpty(memail)) {
                    Toast.makeText(Dlogin.this, "Please enter Email!", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(mpassword)) {
                    Toast.makeText(Dlogin.this, "Please enter password!", Toast.LENGTH_SHORT).show();
                } else {
                    mAuth.signInWithEmailAndPassword(memail, mpassword).addOnCompleteListener(Dlogin.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(Dlogin.this, "sign in error", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

        signup = (TextView) findViewById(R.id.textView5);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dlogin.this, Dsignup.class);
                startActivity(intent);
                finish();
                return;
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
