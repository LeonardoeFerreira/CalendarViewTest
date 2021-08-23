package com.playxcodes.calendarviewtest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.CalendarView;

public class Calendar_activity extends AppCompatActivity {

    private static final String TAG="CalendarActivity";
    private CalendarView mcalendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        mcalendarView = (CalendarView) findViewById(R.id.calendarView);
        mcalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {

                String date = dayOfMonth + "/" +(month +1)+ "/" +year;
                Log.d(TAG,"onSelectedDayChange: mm/dd/yyyy: "+ date);

                Intent intent = new Intent(Calendar_activity.this, MainActivity.class);
                intent.putExtra("date", date);
                startActivity(intent);
            }
        });
    }
}