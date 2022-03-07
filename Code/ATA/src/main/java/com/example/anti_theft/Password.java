package com.example.anti_theft;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Password extends Activity implements View.OnClickListener {
    Button btn;
    EditText edit1;
    EditText edit2;
    EditText edit3;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        this.edit1 = (EditText) findViewById(R.id.text1);
        this.edit2 = (EditText) findViewById(R.id.text2);
        this.edit3 = (EditText) findViewById(R.id.text3);
        this.btn = (Button) findViewById(R.id.bAdd);
        this.btn.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v.getId() == this.btn.getId()) {
            String s1 = this.edit1.getText().toString().trim();
            String s2 = this.edit2.getText().toString().trim();
            String s3 = this.edit3.getText().toString().trim();
            System.out.println(s1);
            System.out.println(s2);
            System.out.println(s3);
            if (s2.equals(s3)) {
                RegisterData db = new RegisterData(this);
                db.open();
                boolean b1 = db.updatePassword(s1, s2);
                System.out.println(b1);
                db.close();
                if (b1) {
                    Toast.makeText(getApplicationContext(), "Password Changed", 0).show();
                    startActivity(new Intent(this, Login.class));
                    return;
                }
                Toast.makeText(getApplicationContext(), "Invalid Password", 0).show();
                this.edit1.setText("");
                this.edit2.setText("");
                this.edit3.setText("");
                return;
            }
            Toast.makeText(getApplicationContext(), "Password did not match", 0).show();
            this.edit2.setText("");
            this.edit3.setText("");
        }
    }
}
