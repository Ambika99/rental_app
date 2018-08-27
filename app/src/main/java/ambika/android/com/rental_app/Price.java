package ambika.android.com.rental_app;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class Price extends AppCompatActivity implements DatePickerDialog.OnDateSetListener,TimePickerDialog.OnTimeSetListener{
    Intent extras = getIntent();
    Button datePick,fare;
    TextView dateDisp;
    FirebaseUser user;
    int day,month,year,hour,minute;
    int dayFinal,monthFinal,yearFinal,hourFinal,minuteFinal;
    FirebaseDatabase database;
    DatabaseReference myref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price);

        datePick = findViewById(R.id.datePicker);
        dateDisp = findViewById(R.id.date);
        fare = (Button)findViewById(R.id.fare);
        fare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(minuteFinal!=30||minuteFinal!=00){
                    if(minuteFinal<30){
                        minuteFinal=30;
                    }
                    else{
                        minuteFinal=00;
                        hourFinal=hourFinal+1;
                    }
                }

            }
        });

        datePick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();
                year = c.get(Calendar.YEAR);
                month = c.get(Calendar.MONTH);
                day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(Price.this,Price.this,year,month,day);
                datePickerDialog.show();
            }
        });

        if(extras!=null){
            int ID = extras.getIntExtra("ID",0);
            switch (ID){
                case 1:
                    scooter();
                    break;
                case 2:
                    bike();
                    break;
                case 3:
                    royalEnfield();
                    break;
            }
        }
    }

    private void scooter() {

    }
    private void bike(){

    }
    private void royalEnfield(){

    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        yearFinal = i;
        monthFinal = i1+1;
        dayFinal = i2;

        Calendar c = Calendar.getInstance();
        hour = c.get(Calendar.HOUR_OF_DAY);
        minute = c.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(Price.this,Price.this,hour,minute, android.text.format.DateFormat.is24HourFormat(this));
        timePickerDialog.show();
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        hourFinal = i;
        minuteFinal = i1;

        dateDisp.setText("Year: "+yearFinal+"\n"+"Month: "+monthFinal+"\n"+"Day: "+dayFinal+"\n"+"Time: "+hourFinal+":"+minuteFinal);
    }
}