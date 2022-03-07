package com.example.anti_theft;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Number extends Activity implements View.OnClickListener {
    Button btn;
    ImageView image;
    EditText text;
    TextView txt1;
    TextView txt2;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);
        this.txt1 = (TextView) findViewById(R.id.tv1);
        this.txt2 = (TextView) findViewById(R.id.tv2);
        this.image = (ImageView) findViewById(R.id.imageView1);
        this.text = (EditText) findViewById(R.id.text1);
        this.btn = (Button) findViewById(R.id.button);
        this.btn.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v.getId() == this.btn.getId()) {
            String s1 = this.text.getText().toString().trim();
            if (s1.length() > 10 || s1.length() < 10) {
                Toast.makeText(getApplicationContext(), "Invalid Number", 0).show();
                this.text.setText("");
                return;
            }
            Intent intent = new Intent(this, Confirm_Number.class);
            Bundle bundle = new Bundle();
            bundle.putString(RegisterData.KEY_NUMBER, s1);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }
}
