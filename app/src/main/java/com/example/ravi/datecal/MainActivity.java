package com.example.ravi.datecal;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;

import com.example.ravi.datecal.service.Example;
import com.example.ravi.datecal.service.Util;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Util util;
    private int pYear,pMonth,pDay;
    Calendar calendar;
    DatePickerDialog dpd = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        util = new Util();
                      calendar = Calendar.getInstance();

        dpd = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)
            {
                pYear = year;
                pMonth = monthOfYear +1;
                pDay = dayOfMonth;


            }
        },calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DATE));






    }
                      //for selecting date
    public void selectDate(View veiw) {
        dpd.show();
    }


                                           // post data to service
    public void postDate(View view) {
        Call<Example> exampleCall = util.getBaseClassService(this,"").bookAppointment("85","82","2:30:02",pYear+"-"+pDay+1+pMonth);

        exampleCall.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Log.d("Lokesh",response.message());
                Log.d("Lokesh",""+response.body().getMessage());
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.d("Lokesh","failuer"+t.getMessage());

            }
        });

    }

}
