package com.example.amit.datetimepicker;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b1,b2;
    TextView tv1,tv2,tv3,tv4;
    int day,month,year,hour,minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1= (TextView) findViewById(R.id.tv1);
        tv2= (TextView) findViewById(R.id.tv2);
        tv3= (TextView) findViewById(R.id.tv3);
        tv4= (TextView) findViewById(R.id.tv4);
        b1= (Button) findViewById(R.id.b1);
        b2= (Button) findViewById(R.id.b2);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);


//        DateFormat dateyear = new SimpleDateFormat("yyyy");
//        DateFormat datemonth = new SimpleDateFormat("MM");
//        DateFormat dateday = new SimpleDateFormat("dd");
//        DateFormat datehour = new SimpleDateFormat("hh");
//        DateFormat dateminuts = new SimpleDateFormat("mm");
//        DateFormat dateseconds = new SimpleDateFormat("ss");
//        Date date = new Date();
//        String year = dateyear.format(date);
//        String month = datemonth.format(date);
//        String day = dateday.format(date);
//        String hours = datehour.format(date);
//        String minuts = dateminuts.format(date);
//        String seconds = dateseconds.format(date);

        Calendar c = Calendar.getInstance();
         day= c.get(Calendar.DAY_OF_MONTH);
         month = c.get(Calendar.MONTH);
         year = c.get(Calendar.YEAR);
         hour = c.get(Calendar.HOUR_OF_DAY);
         minute = c.get(Calendar.MINUTE);


        String todaydate = day+"-"+(month+1)+"-"+year;
        tv1.setText(todaydate);

        String time = hour+":"+minute;
        tv2.setText(time);

    }

    @Override
    public void onClick(View view) {


        if (view==b1)
        {
            DatePickerDialog dp = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int yr, int m, int d) {

                    tv3.setText(d+"-"+(m+1)+"-"+yr);

                }
            },year,month,day);

            dp.show();


        }
        else if (view==b2)
        {
            TimePickerDialog tp = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int i, int i1) {

                    if (i>=12)
                    {
                        if (i>12)
                        {
                        int hou = (i%12);
                        tv4.setText(hou+":"+i1+"pm");
                    }
                    else {
                            tv4.setText(i+":"+i1+"pm");

                        }

                    }
                    else {if (i==00)
                    {
                        tv4.setText("12:"+i1+"am");
                    }
                    else
                        tv4.setText(i+":"+i1+"am");
                    }


                }
            },hour,minute,false);

            tp.show();

        }




    }
}
