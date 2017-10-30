package com.mihisa.sensors;

import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Mihisa on 28-Oct-17.
 */

public class InfoActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_info);

        textView = (TextView) findViewById(R.id.textViewInfo);
        textView.setText("System info \n \n" + getTextInfo());
        textView.setTextSize(22);
    }

    private String getTextInfo() {
        StringBuffer buffer = new StringBuffer();
        getProperty("os.name", "os.name", buffer);
        getProperty("os.version", "os.version", buffer);
        getProperty("java.vendor.url", "java.vendor.url", buffer);
        getProperty("java.version", "java.version", buffer);
        getProperty("java.class.path", "java.class.path", buffer);
        getProperty("java.class.version", "java.class.version", buffer);
        getProperty("java.vendor", "java.vendor", buffer);
        getProperty("java.home", "java.home", buffer);

        getProperty("user.name", "user.name", buffer);
        getProperty("user.home", "user.home", buffer);
        getProperty("user.dir", "user.dir", buffer);

        return buffer.toString();
    }

    private void getProperty(String key, String property, StringBuffer buffer) {
        buffer.append(key);
        buffer.append(" : ");
        buffer.append(System.getProperty(property));
        buffer.append("\n \n");
    }
}
