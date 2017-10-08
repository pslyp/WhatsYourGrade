package com.pslyp.m1.whatsyourgrade;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView nameTV, gradeTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        nameTV = (TextView) findViewById(R.id.nameTextView);
        gradeTV = (TextView) findViewById(R.id.gradeTextView);

        Intent it = getIntent();
        String name = it.getStringExtra("nameText");
        String grade = it.getStringExtra("gradeText");

        nameTV.setText(name);
        gradeTV.setText(grade);
    }
}
