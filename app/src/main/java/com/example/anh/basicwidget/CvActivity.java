package com.example.anh.basicwidget;


import android.app.DatePickerDialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.app.DatePickerDialog.OnDateSetListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class CvActivity extends AppCompatActivity implements OnClickListener {
    private Button btnSave;
    private EditText birthDayEtxt;

    private Spinner spinner;

    private String arr[] = {
            "Ha Noi",
            "Nam Dinh",
            "Hung Yen",
            "Hai Phong",
            "Bac Giang"
    };

    private DatePickerDialog birthDayDatePickerDialog;
    private SimpleDateFormat dateFormatter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cv);
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        findViewById();
        setDateTimeField();
        setBirthPlace();
        autoCompleteTextView();
    }
    private void findViewById() {
        btnSave = (Button)findViewById(R.id.btnSave) ;
        birthDayEtxt =(EditText)findViewById(R.id.birthDay);
        birthDayEtxt.setInputType(InputType.TYPE_NULL);
        spinner = (Spinner)findViewById(R.id.spinner);
    }
    private void setDateTimeField() {
        birthDayEtxt.setOnClickListener(this);
        Calendar newCalendar = Calendar.getInstance();
        birthDayDatePickerDialog = new DatePickerDialog(this, new OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                birthDayEtxt.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
    }
    private void setBirthPlace(){
        ArrayAdapter<String> adapter=new ArrayAdapter<String>
                (
                        this, android.R.layout.simple_spinner_item, arr
                );
        //phải gọi lệnh này để hiển thị danh sách cho Spinner
        adapter.setDropDownViewResource
                (android.R.layout.simple_list_item_single_choice);
        //Thiết lập adapter cho Spinner
        spinner.setAdapter(adapter);
        //thiết lập sự kiện chọn phần tử cho Spinner
        spinner.setOnItemSelectedListener(new MyProcessEvent());
    }
    //Class tạo sự kiện
    private class MyProcessEvent implements AdapterView.OnItemSelectedListener
    {
        //Khi có chọn lựa thì vào hàm này
        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
            //arg2 là phần tử được chọn trong data source
        }
        //Nếu không chọn gì cả
        public void onNothingSelected(AdapterView<?> arg0) {
        }
    }
    @Override
    public void onClick(View v) {
        birthDayDatePickerDialog.show();
    }
    private void autoCompleteTextView(){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (
                        this,android.R.layout.simple_dropdown_item_1line,arr
                );
        AutoCompleteTextView editText = (AutoCompleteTextView)findViewById(R.id.edittext);
            editText.setAdapter(adapter);

    }
}
