package com.mycaptain.fun;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.view.View;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import android.os.Bundle;

public class Activity3 extends AppCompatActivity {
    EditText phn;
    EditText msg;
    Button snd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        msg = findViewById(R.id.msg);
        phn = findViewById(R.id.recip);
    }

    public void btn_send(View view) {
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS);

        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            Mymsg();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS},
                    0);
        }
    }

    private void Mymsg() {

        String phn_num = phn.getText().toString().trim();
        String message = msg.getText().toString().trim();
        if (!phn.getText().toString().equals("") || !msg.getText().toString().equals("")) {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phn_num, null, message, null, null);
            Toast.makeText(this, "Message Sent !"
                    , Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Enter phone number or text !"
                    , Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch(requestCode) {
            case 0:
                if (grantResults.length >= 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    Mymsg();
                else {
                    Toast.makeText(this, "You dont have the required permission to perform this action !"
                            , Toast.LENGTH_SHORT).show();
                }


        }
    }
}


