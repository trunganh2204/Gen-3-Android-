package com.example.anh.basicwidget;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.view.View.OnClickListener;



public class MainActivity extends AppCompatActivity implements OnClickListener {
    TextView textview_countries;
    private String[] countries_list = {"Philippines", "Japan", "Australia"};

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview_countries = (TextView) findViewById(R.id.txtview_countries);
        textview_countries.setInputType(InputType.TYPE_NULL); //To hide the softkeyboard


        final ArrayAdapter<String> spinner_countries = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, countries_list);

        textview_countries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Select Countries")
                        .setAdapter(spinner_countries, new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int which) {
                                textview_countries.setText(countries_list[which].toString());
                                dialog.dismiss();
                            }
                        }).create().show();
            }
        });

    }

    @Override
    public void onClick(View v) {

    }
}

