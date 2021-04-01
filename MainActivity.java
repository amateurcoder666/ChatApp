package com.mycaptain.fun;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    ImageView mycap;
    TextView text;
    TextView call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.text);
        call = findViewById(R.id.call);
        mycap = findViewById(R.id.mycaptain);
        mycap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.mycaptain.in/");
            }
        });
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View k) {
                openActivity2();
            }
        });
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View j) {
                openActivity3();
            }
        });

    }
    private void openActivity2() {
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }

    private void openActivity3() {
        Intent intent = new Intent(this, Activity3.class);
        startActivity(intent);
    }


    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }
}
