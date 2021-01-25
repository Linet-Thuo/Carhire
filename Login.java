package com.linet.carhire;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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

public class Login extends AppCompatActivity {
    private Button login;
    private TextView signup, driver;
    private EditText email, password;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

       mAuth = FirebaseAuth.getInstance();

       firebaseAuthListener = new FirebaseAuth.AuthStateListener() {
                @Override
                public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    if (user != null) {
                        Intent intent = new Intent(Login.this, Rmap.class);
                        startActivity(intent);
                        finish();
                        return;
                    }
                }
            };

        login = (Button) findViewById(R.id.button2);
        password = (EditText) findViewById(R.id.password);
        email = (EditText) findViewById(R.id.email);

        login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final String memail = email.getText().toString();
                    final String mpassword = password.getText().toString();
                    if (TextUtils.isEmpty(memail)) {
                        Toast.makeText(Login.this, "Please enter Email!", Toast.LENGTH_SHORT).show();
                    } else if (TextUtils.isEmpty(mpassword)) {
                        Toast.makeText(Login.this, "Please enter password!", Toast.LENGTH_SHORT).show();
                    } else {
                        mAuth.signInWithEmailAndPassword(memail, mpassword).addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (!task.isSuccessful()) {
                                    Toast.makeText(Login.this, "Sign in error", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                }
            });


        driver = (TextView) findViewById(R.id.textView15);

        driver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Dlogin.class);
                startActivity(intent);
                finish();
                return;
            }
        });
        signup = (TextView) findViewById(R.id.textView4);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Signup.class);
                startActivity(intent);
                finish();
                return;
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(firebaseAuthListener);
    }
    @Override
    protected void onStop() {
        super.onStop();
        mAuth.removeAuthStateListener(firebaseAuthListener);
    }

}
