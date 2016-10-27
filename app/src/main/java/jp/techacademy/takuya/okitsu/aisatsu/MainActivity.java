package jp.techacademy.takuya.okitsu.aisatsu;

import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.textView);

    }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button1) {
            showTimePickerDialog();
        } else if (v.getId() == R.id.button2) {

           if (hour >= 2 && hour < 10){
               mTextView.setText("おはよう");
           }else if (hour >=10 && hour < 18)
           {
               mTextView.setText("こんにちは");
           }else
           {
               mTextView.setText("こんばんは");
           }

        }
    }





   final Calendar calendar = Calendar.getInstance();
     int hour = calendar.get(Calendar.HOUR_OF_DAY);
     int minute = calendar.get(Calendar.MINUTE);



    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        Log.d("UI-PARTS",String.valueOf(hourOfDay) + ":" + String.valueOf(minute));
                    }
                },
        hour,
                minute,
                true);

        timePickerDialog.show();


    }


    }

