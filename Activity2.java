package com.mycaptain.fun;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.net.Uri;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import android.os.Bundle;

public class Activity2 extends AppCompatActivity {
    EditText call_et;
    ImageButton call_bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        call_et = findViewById(R.id.call_func);
        call_bt = findViewById(R.id.call_bt);

        call_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = call_et.getText().toString();
                if(phone.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please Enter Number !"
                            , Toast.LENGTH_SHORT).show();
                }
                else {
                    String s = "tel:" + phone;
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse(s));
                    startActivity(intent);
                }
                }

        });
    }

}
