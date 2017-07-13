package com.harshalbenake.gaugeview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.sccomponents.gauges.ScArcGauge;
import com.sccomponents.gauges.ScGauge;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the components
        final ScArcGauge gauge = (ScArcGauge) this.findViewById(R.id.gauge);
        assert gauge != null;

        final ImageView indicator = (ImageView) this.findViewById(R.id.indicator);
        assert indicator != null;

        final TextView counter = (TextView) this.findViewById(R.id.counter);
        assert counter != null;

        // Set the center pivot for a right rotation
        indicator.setPivotX(30f);
        indicator.setPivotY(30f);

        // As the progress feature by default the last to be draw I must bring the notches feature
        // on top.
        gauge.bringOnTop(ScGauge.NOTCHES_IDENTIFIER);

        // If you set the value from the xml that not produce an event so I will change the
        // value from code.
        gauge.setHighValue(60);

        // Each time I will change the value I must write it inside the counter text.
        gauge.setOnEventListener(new ScGauge.OnEventListener() {
            @Override
            public void onValueChange(float lowValue, float highValue) {
                // Convert the percentage value in an angle
                float angle = gauge.percentageToAngle(highValue);
                indicator.setRotation(angle);

                // Write the value
                int value = (int) ScGauge.percentageToValue(highValue, 0.0f, 3000.0f);
                counter.setText(value + "");
            }
        });


    }
}
