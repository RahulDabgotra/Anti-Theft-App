package com.example.anti_theft;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.gsm.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Confirm_Number extends Activity implements View.OnClickListener {
    Button btn;
    ImageView image;
    EditText text;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm__number);
        this.image = (ImageView) findViewById(R.id.imageView1);
        this.text = (EditText) findViewById(R.id.text1);
        this.btn = (Button) findViewById(R.id.button);
        this.btn.setOnClickListener(this);
        this.text.setText(getIntent().getExtras().getString(RegisterData.KEY_NUMBER));
    }

    public void onClick(View v) {
        if (v.getId() == this.btn.getId()) {
            String s1 = this.text.getText().toString();
            RegisterData db = new RegisterData(this);
            db.open();
            db.insertData(s1);
            db.close();
            try {
                SmsManager.getDefault().sendTextMessage(s1, null, "You have successfully registered for Anti-Theft app!", null, null);
                Toast.makeText(getApplicationContext(), "Message sent", 0).show();
                startActivity(new Intent(this, Login.class));
            } catch (Exception e) {
                AlertDialog ad = new AlertDialog.Builder(this).create();
                ad.setMessage(e.getMessage());
                ad.show();
            }
        }
    }
}
