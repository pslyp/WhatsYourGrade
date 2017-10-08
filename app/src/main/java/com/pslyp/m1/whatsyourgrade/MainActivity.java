package com.pslyp.m1.whatsyourgrade;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.R.attr.name;

public class MainActivity extends AppCompatActivity {

    Button findGrade, exit;
    EditText nameEditText, scoreEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = (EditText) findViewById(R.id.yourName_editText);
        scoreEditText = (EditText) findViewById(R.id.score_editText);
        findGrade = (Button) findViewById(R.id.findGrade_button);
        exit = (Button) findViewById(R.id.exit_button);

        findGrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                String score = scoreEditText.getText().toString();

                if(name.length() == 0 || score.length() == 0) {
                    if(name.length() == 0)
                        nameEditText.setError("ป้อนชื่อ");
                    if(score.length() == 0)
                        scoreEditText.setError("ป้อนคะแนน");
                }
                else {
                    int scoreN = Integer.parseInt(score);

                    Intent it = new Intent(MainActivity.this, Main2Activity.class);
                    it.putExtra("nameText", name);
                    it.putExtra("gradeText", calGrade(scoreN));
                    startActivity(it);
                }
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder exitA = new AlertDialog.Builder(MainActivity.this);
                exitA.setTitle("Confirm Exit");
                exitA.setMessage("แน่ใจว่าออกจากแอพ");
                exitA.setPositiveButton("ออก", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                exitA.show();
            }
        });
    }

    public String calGrade(int grade) {
        if(grade <= 49)
            return "F";
        else if(grade <= 59)
            return "D";
        else if(grade <= 69)
            return "C";
        else if(grade <= 79)
            return "B";
        else
            return "A";
    }
}
