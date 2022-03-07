package com.example.anti_theft;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends Activity implements View.OnClickListener {
    Button bt1;
    Button bt2;
    EditText etxt1;
    EditText etxt2;
    EditText etxt3;
    TextView text1;
    TextView text2;
    TextView text3;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        this.etxt1 = (EditText) findViewById(R.id.etext1);
        this.etxt2 = (EditText) findViewById(R.id.etext2);
        this.etxt3 = (EditText) findViewById(R.id.etext3);
        this.text1 = (TextView) findViewById(R.id.tv1);
        this.text2 = (TextView) findViewById(R.id.tv2);
        this.text3 = (TextView) findViewById(R.id.tv3);
        this.bt1 = (Button) findViewById(R.id.bAdd);
        this.bt2 = (Button) findViewById(R.id.bAdd2);
        this.bt1.setOnClickListener(this);
        this.bt2.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v.getId() == this.bt1.getId()) {
            String s1 = this.etxt1.getText().toString();
            String s2 = this.etxt2.getText().toString();
            String s3 = this.etxt3.getText().toString();
            if (s1.equals("") || s2.equals("") || s3.equals("")) {
                Toast.makeText(getApplicationContext(), "Please Enter Required Fields", 0).show();
            } else if (s2.equals(s3)) {
                RegisterData db = new RegisterData(this);
                db.open();
                db.insertdata(s1, s2);
                db.close();
                startActivity(new Intent(this, Login.class));
            } else {
                Toast.makeText(getApplicationContext(), "Password does not match", 0).show();
            }
        }
        if (v.getId() == this.bt2.getId()) {
            startActivity(new Intent(this, Login.class));
        }
    }
}
