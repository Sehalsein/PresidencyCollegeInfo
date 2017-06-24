package com.sehalsein.presidencycollegeinfo.Activity;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.sehalsein.presidencycollegeinfo.Model.Users;
import com.sehalsein.presidencycollegeinfo.R;

import me.alexrs.prefs.lib.Prefs;

public class Login extends AppCompatActivity {

    TextInputEditText nameEditText;
    private DatabaseReference mDatabase;
    RadioGroup course;
    String name = null;
    String courseName = null;
    String prefsKey = "logged_in";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // [START initialize_database_ref]
        mDatabase = FirebaseDatabase.getInstance().getReference();
        // [END initialize_database_ref]

        nameEditText = (TextInputEditText) findViewById(R.id.name);
        course = (RadioGroup) findViewById(R.id.radioCourse);

    }


    public void login(View view){

        String key = mDatabase.child("users").push().getKey();

        int selectedId = course.getCheckedRadioButtonId();

        switch (selectedId){
            case R.id.radioBCA:
                courseName = "BCA";
                break;
            case R.id.radioBBA:
                courseName = "BBA";
                break;
            case R.id.radioBA:
                courseName = "BA";
                break;
            case R.id.radioBCOM:
                courseName = "BCOM";
        }

        if(nameEditText.length() != 0 && courseName != null){
            Prefs.with(getApplicationContext()).save(prefsKey, true);

            name = nameEditText.getText().toString();
            Users users = new Users();
            users.setName(name);
            users.setCourse(courseName);
            mDatabase.child("users").child(key).setValue(users);

            Intent i = new Intent(Login.this, MainActivity.class);
            startActivity(i);
            finish();
        }else{
            Toast.makeText(Login.this,"Please enter all the fields!",Toast.LENGTH_SHORT).show();
        }

    }

}
