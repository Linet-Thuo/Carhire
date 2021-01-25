package com.linet.carhire;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Dmanual extends AppCompatActivity {

    private Button mSignup;
    private TextView mterms, back;
    private EditText email, password, password1;
    private CheckBox terms;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dmanual);

        mAuth = FirebaseAuth.getInstance();

        firebaseAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if(user!=null){
                    Intent intent = new Intent(Dmanual.this, Ddetails.class);
                    startActivity(intent);
                    finish();
                    return;
                }
            }
        };

        mSignup = (Button) findViewById(R.id.button5);
        password = (EditText) findViewById(R.id.password4);
        password1 = (EditText) findViewById(R.id.password5);
        email = (EditText) findViewById(R.id.email3);
        terms = (CheckBox) findViewById(R.id.checkBox1);

        mSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String memail = email.getText().toString();
                final String mpassword = password.getText().toString();
                final String mpassword1 = password1.getText().toString();

                if (TextUtils.isEmpty(memail)) {
                    Toast.makeText(Dmanual.this, "Please enter Email!", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(mpassword)) {
                    Toast.makeText(Dmanual.this, "Please enter password!", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(mpassword1)) {
                    Toast.makeText(Dmanual.this, "Please confirm password!", Toast.LENGTH_SHORT).show();
                } else if (mpassword != mpassword1) {
                    Toast.makeText(Dmanual.this, "The passwords don't match!", Toast.LENGTH_SHORT).show();
                } else {
                    if (terms.isChecked()) {
                        mAuth.createUserWithEmailAndPassword(memail, mpassword)
                                .addOnCompleteListener(Dmanual.this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if (!task.isSuccessful()) {
                                            Toast.makeText(Dmanual.this, "sign up error", Toast.LENGTH_SHORT).show();
                                        } else {
                                            String user_id = mAuth.getCurrentUser().getUid();
                                            DatabaseReference current_user_db = FirebaseDatabase.getInstance()
                                                    .getReference().child("Details").child("Users").child("DriverID").child(user_id);
                                            current_user_db.setValue(true);
                                        }
                                    }
                                });
                    } else {
                        Toast.makeText(Dmanual.this, "Please read and accept the Terms and Conditions applied!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        mterms = (TextView) findViewById(R.id.textView6);

        mterms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dmanual.this, Dterms.class);
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
