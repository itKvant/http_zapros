package com.example.kvantorium.http_zapros;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.TextView;

public class SecondActivity extends Activity {

    public static String JsonURL;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String HttpPost = getIntent().getStringExtra("HtpPost");
        TextView text_box = (TextView) findViewById(R.id.txt_box);
        // получим imei телефона для его идентификации
        TelephonyManager telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
        String ID_Telephone = telephonyManager.getDeviceId();
        text_box.setText(HttpPost + ID_Telephone);

    }
}
