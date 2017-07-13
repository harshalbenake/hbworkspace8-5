package com.harshalbenake.odometer;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.harshalbenake.odometer.views.Odometer;

public class MainActivity extends AppCompatActivity {
    private Odometer odometer;
    private TextView tvOutPut;
    private Button btn_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        odometer = (Odometer) findViewById(R.id.odometer);
        tvOutPut = (TextView) findViewById(R.id.tvOutPut);
        btn_submit = (Button) findViewById(R.id.btn_submit);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOutPut.setText(odometer.getFinalOdometerValue());
            }
        });

    }
}
