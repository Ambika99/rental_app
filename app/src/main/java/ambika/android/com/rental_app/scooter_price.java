package ambika.android.com.rental_app;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class scooter_price extends AppCompatActivity implements DatePickerDialog.OnDateSetListener,TimePickerDialog.OnTimeSetListener,AdapterView.OnItemSelectedListener {
    Button startDatePick,proceedBtn;
    TextView Price,startDateDisp;
    private RadioGroup radioClgGrp;
    private RadioButton radioClgBtn;
    int price_scooter;
    Spinner duration;
    int startYear,startMonth,startDay,sYearFinal,sMonthFinal,sDayFinal,startHour,startMinute,sHourFinal,sMinuteFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scooter_price);
        duration = findViewById(R.id.duration);
        radioClgGrp = findViewById(R.id.radioClg);
        startDatePick = findViewById(R.id.startDatePicker);
        startDateDisp = findViewById(R.id.startDateDisp);
        proceedBtn = findViewById(R.id.proceedBtn);
        Price = findViewById(R.id.Price);
        duration.setOnItemSelectedListener(this);

        int selectedID = radioClgGrp.getCheckedRadioButtonId();

        switch (selectedID){
            case R.id.radioVIT :
            {
                proceedBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(scooter_price.this,vitian_form.class);
                        startActivity(i);
                    }
                });
            }
            break;
            case R.id.radioNonVIT :
            {
                proceedBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i1 = new Intent(scooter_price.this,non_vitian_form.class);
                        startActivity(i1);
                    }
                });
            }
            break;
        }


        startDatePick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();
                startYear = c.get(Calendar.YEAR);
                startMonth = c.get(Calendar.MONTH);
                startDay = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(scooter_price.this,scooter_price.this,startYear,startMonth,startDay);
                datePickerDialog.show();
            }
        });

        duration.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItem = adapterView.getItemAtPosition(i).toString();
                if(selectedItem.equals("1")){
                    Price.setVisibility(View.VISIBLE);
                    Price.setText("100");
                    price_scooter = 100;
                }
                else if(selectedItem.equals("4")){
                    Price.setText("300");
                    price_scooter = 300;
                }
                else if(selectedItem.equals("8")){
                    Price.setText("550");
                    price_scooter = 550;
                }
                else if(selectedItem.equals("Day Pass")){
                    Price.setText("650");
                    price_scooter = 650;
                }
                else if (selectedItem.equals("Week Pass")){
                    Price.setText("2250");
                    price_scooter = 2250;
                }
                else if (selectedItem.equals("Month Pass")){
                    Price.setText("7250");
                    price_scooter = 7250;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        sYearFinal = i;
        sMonthFinal = i1;
        sDayFinal = i2;
        Calendar c = Calendar.getInstance();
        startHour = c.get(Calendar.HOUR_OF_DAY);
        startMinute = c.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(scooter_price.this, scooter_price.this, startHour, startMinute, DateFormat.is24HourFormat(this));
        timePickerDialog.show();
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        sHourFinal = i;
        sMinuteFinal = i1;
        startDatePick.setVisibility(View.INVISIBLE);
        startDateDisp.setVisibility(View.VISIBLE);
        startDateDisp.setText(sDayFinal + "/" + sMonthFinal + "/" + sYearFinal + " at " + sHourFinal + ":" + sMinuteFinal);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}