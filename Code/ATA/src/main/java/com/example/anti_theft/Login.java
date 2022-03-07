package com.example.anti_theft;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity implements View.OnClickListener {
    Button btn;
    EditText edit1;
    EditText edit2;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.edit1 = (EditText) findViewById(R.id.etext1);
        this.edit2 = (EditText) findViewById(R.id.etext2);
        this.btn = (Button) findViewById(R.id.bAdd);
        this.btn.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v.getId() == this.btn.getId()) {
            String s1 = this.edit1.getText().toString();
            String s2 = this.edit2.getText().toString();
            RegisterData db = new RegisterData(this);
            db.open();
            boolean b1 = db.verifyUser(s1, s2);
            db.close();
            System.out.println(b1);
            if (b1) {
                Toast.makeText(getApplicationContext(), "Valid User", 0).show();
                startActivity(new Intent(this, Description.class));
                return;
            }
            Toast.makeText(getApplicationContext(), "Invalid User", 0).show();
            this.edit1.setText("");
            this.edit2.setText("");
            startActivity(new Intent(this, Register.class));
        }
    }
}
