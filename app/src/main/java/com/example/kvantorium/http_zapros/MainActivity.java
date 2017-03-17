package com.example.kvantorium.http_zapros;

import android.content.Intent;
import android.os.AsyncTask;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                      new RequestTask().execute();
                    }
                }
        );
    }

    class RequestTask extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... params) {
            BufferedReader reader=null;
            try{
                // создаем запрос на сервер
                URL url = new URL("http://chebddut.ru/files/login.php");
                HttpURLConnection PostHttp = (HttpURLConnection)url.openConnection();

                PostHttp.setRequestMethod("GET");
                PostHttp.setReadTimeout(10000);
                PostHttp.connect();
                reader= new BufferedReader(new InputStreamReader(PostHttp.getInputStream()));
                StringBuilder buf = new StringBuilder();
                String line = null;
                while ((line=reader.readLine()) != null) {
                    buf.append(line + "\n");
                }
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("HtpPost", buf.toString());
                startActivity(intent);

            } catch (Exception e) {
                System.out.println("Exp = " + e);
            }
            return null;
        }
    }
}
