package com.sehalsein.presidencycollegeinfo.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.sehalsein.presidencycollegeinfo.R;
import com.sehalsein.presidencycollegeinfo.UserData;

public class Solutions extends AppCompatActivity {

    private TextView solutions;

    public String answers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solutions);

        solutions = (TextView) findViewById(R.id.answers);

        answers = UserData.answers;
        solutions.setText(answers);


    }
}
