package com.example.unimate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Attendence extends AppCompatActivity {
     ImageView back;
     TextView current_date, course_title, year, semester;
     Spinner course_code;

     ToggleButton status;

    private boolean isButtonAEnabled = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendence);
       current_date = findViewById(R.id.date);
       course_code = findViewById(R.id.courses_code);
       year = findViewById(R.id.year);
       semester = findViewById(R.id.semester);
       course_title = findViewById(R.id.course_title);
      status = findViewById(R.id.status);


        back = findViewById(R.id.arrow_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Attendence.this, MainActivity.class);
                startActivity(intent );
            }
        });

        //set current date automatically
        Calendar  calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat= new SimpleDateFormat("dd/MM/yyyy");
        String date = dateFormat.format(calendar.getTime()).toString();
        current_date.setText(date);


       course_code.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               String course_name = (String) adapterView.getItemAtPosition(i);
               if(i == 1)
               {
                   course_title.setText("SOFTWARE ENGINEERING");
                   yearSemester();
               }
               else if(i == 2)
               {
                   course_title.setText("SOFTWARE ENGINEERING SESSIONAL");
                   yearSemester();
               }
               else if(i == 3)
               {
                   course_title.setText("SYSTEM ANALYSIS AND DESIGN");
                   yearSemester();
               }
               else if(i == 4)
               {
                   course_title.setText("DIGITAL IMAGE PROCESSING");
                   yearSemester();
               }
               else if(i == 5)
               {
                   course_title.setText("DIGITAL IMAGE PROCESSING SESSIONAL");
                   yearSemester();

               }
           }

           @Override
           public void onNothingSelected(AdapterView<?> adapterView) {

           }
       });
        //set Course Title

    }
        public void toggleState(View view) {
            boolean toggle = status.isChecked();
            if (toggle){
                status.setTextOn("P");
                status.setBackgroundColor(R.drawable.present_btn);
            } else {
                status.setTextOff("A");
                status.setBackgroundColor(R.drawable.absent_btn);
            }
        }

    public void yearSemester()
    {
        year.setText("4th YEAR");
        semester.setText("2nd SEMESTER");
    }



}