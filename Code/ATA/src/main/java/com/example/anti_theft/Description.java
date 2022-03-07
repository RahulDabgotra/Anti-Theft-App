package com.example.anti_theft;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Description extends Activity implements View.OnClickListener {
    Button btn1;
    Button btn2;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        this.btn1 = (Button) findViewById(R.id.noreg);
        this.btn2 = (Button) findViewById(R.id.utility);
        this.btn1.setOnClickListener(this);
        this.btn2.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.noreg /*{ENCODED_INT: 2131296263}*/:
                startActivity(new Intent(this, Number.class));
                return;
            case R.id.utility /*{ENCODED_INT: 2131296264}*/:
                startActivity(new Intent(this, Menu.class));
                return;
            default:
                return;
        }
    }
}
