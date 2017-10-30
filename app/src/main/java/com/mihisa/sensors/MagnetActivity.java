package com.mihisa.sensors;

import android.app.Service;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

/**
 * Created by Mihisa on 29-Oct-17.
 */

public class MagnetActivity extends AppCompatActivity implements SensorEventListener {

    private static SensorManager mSensorManager;
    private Sensor mSensor;

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magnet);

        mTextView = (TextView) findViewById(R.id.textView);

        mSensorManager = (SensorManager) getSystemService(Service.SENSOR_SERVICE);
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);

    }

    @Override
    protected void onResume() {
        super.onResume();

        if(mSensor != null) {
            mSensorManager.registerListener(this, mSensor, SensorManager.SENSOR_DELAY_NORMAL);
        } else {
            System.out.println("Не поддерживается");
            finish();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float azimuth = Math.round(event.values[0]);
        float pitch = Math.round(event.values[1]);
        float roll = Math.round(event.values[2]);

        double tesla = Math.sqrt((azimuth * azimuth) + (pitch * pitch) + (roll * roll));

        String result = String.format(Locale.getDefault(), "%.0f", tesla) + "µT";

        mTextView.setText(result);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
