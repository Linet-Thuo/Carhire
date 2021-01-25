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

public class Signup extends AppCompatActivity {
    private Button mSignup;
    private TextView mterms, back;
    private EditText fullname, dob, phonenumber, email, password, password1;
    private CheckBox terms;
    Rusers user;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mAuth = FirebaseAuth.getInstance();
        firebaseAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if(user!=null){
                    Intent intent = new Intent(Signup.this, Rmap.class);
                    startActivity(intent);
                    finish();
                    return;
                }
            }
        };

        mSignup = (Button) findViewById(R.id.button4);
        fullname = (EditText) findViewById(R.id.editText3);
        dob = (EditText) findViewById(R.id.editText5);
        phonenumber = (EditText) findViewById(R.id.editText4);
        email = (EditText) findViewById(R.id.email2);
        password = (EditText) findViewById(R.id.password2);
        password1 = (EditText) findViewById(R.id.password3);
        terms = (CheckBox) findViewById(R.id.checkBox);
        user = new Rusers();

        mSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String mfullname = fullname.getText().toString();
                final String mdob = dob.getText().toString();
                final String mphonenumber = phonenumber.getText().toString();
                final String memail = email.getText().toString();
                final String mpassword = password.getText().toString();
                final String mpassword1 = password1.getText().toString();
                if (TextUtils.isEmpty(mfullname)) {
                    Toast.makeText(Signup.this, "Please enter your Full Name!", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(mdob)) {
                    Toast.makeText(Signup.this, "Please enter your Date of Birth!", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(mphonenumber)) {
                    Toast.makeText(Signup.this, "Please enter your Phone Number!", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(memail)) {
                    Toast.makeText(Signup.this, "Please enter your Email!", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(mpassword)) {
                    Toast.makeText(Signup.this, "Please enter your Password!", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(mpassword1)) {
                    Toast.makeText(Signup.this, "Please confirm your Password!", Toast.LENGTH_SHORT).show();
                } else {
                    if (TextUtils.equals(mpassword, mpassword1)) {
                        if (terms.isChecked()) {
                            mAuth.createUserWithEmailAndPassword(memail, mpassword)
                                    .addOnCompleteListener(Signup.this, new OnCompleteListener<AuthResult>() {
                                        @Override
                                        public void onComplete(@NonNull Task<AuthResult> task) {
                                            if (!task.isSuccessful()) {
                                                Toast.makeText(Signup.this, "sign up error", Toast.LENGTH_SHORT).show();
                                            } else {
                                                String user_id = mAuth.getCurrentUser().getUid();
                                                DatabaseReference reff;
                                                reff= FirebaseDatabase.getInstance().getReference().child("Details").child("Users").child("Riders").child(user_id);
                                                user.setFullname(mfullname);
                                                user.setDob(mdob);
                                                user.setPhonenumber(mphonenumber);
                                                user.setEmail(memail);
                                                user.setPassword(mpassword);
                                                reff.push().setValue(user);
                                                Toast.makeText(Signup.this, "Signup Sucessfully!", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });
                        } else {
                            Toast.makeText(Signup.this, "Please read and accept the Terms and Conditions applied!", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(Signup.this, "The passwords don't match!", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });


        mterms = (TextView) findViewById(R.id.textView6);

        mterms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Signup.this, Rterms.class);
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
