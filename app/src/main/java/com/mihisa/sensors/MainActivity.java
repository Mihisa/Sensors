package com.mihisa.sensors;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    public ImageButton info, one, three, location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        one = (ImageButton) findViewById(R.id.magnet);
        three = (ImageButton) findViewById(R.id.compassView);
        info = (ImageButton) findViewById(R.id.info);
        location = (ImageButton) findViewById(R.id.location);
    }

    public void onClickInfo(View view) {
        Intent intent = new Intent(MainActivity.this, InfoActivity.class);
        startActivity(intent);
    }

    public void onClickMagnet(View view) {
        Intent intent = new Intent(MainActivity.this, MagnetActivity.class);
        startActivity(intent);
    }
    public void onClickCompass(View view) {
        Intent intent = new Intent(MainActivity.this, CompassActivity.class);
        startActivity(intent);
    }
    public void onClickLocation(View view) {
        Intent intent = new Intent(MainActivity.this, LocationActivity.class);
        startActivity(intent);
    }
}
