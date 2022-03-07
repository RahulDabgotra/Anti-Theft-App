package com.example.anti_theft;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Menu extends Activity implements View.OnClickListener {
    ImageView image1;
    ImageView image2;
    ImageView image3;
    ImageView image4;
    TextView txt1;
    TextView txt2;
    TextView txt3;
    TextView txt4;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        this.txt1 = (TextView) findViewById(R.id.textView1);
        this.txt2 = (TextView) findViewById(R.id.textView2);
        this.txt3 = (TextView) findViewById(R.id.textView3);
        this.txt4 = (TextView) findViewById(R.id.textView4);
        this.image1 = (ImageView) findViewById(R.id.imageView1);
        this.image2 = (ImageView) findViewById(R.id.imageView2);
        this.image3 = (ImageView) findViewById(R.id.imageView3);
        this.image4 = (ImageView) findViewById(R.id.imageView4);
        this.txt1.setOnClickListener(this);
        this.image1.setOnClickListener(this);
        this.txt2.setOnClickListener(this);
        this.image2.setOnClickListener(this);
        this.txt3.setOnClickListener(this);
        this.image3.setOnClickListener(this);
        this.txt4.setOnClickListener(this);
        this.image4.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageView1 /*{ENCODED_INT: 2131296257}*/:
                startActivity(new Intent(this, Anti_Introduction.class));
                return;
            case R.id.tv3 /*{ENCODED_INT: 2131296258}*/:
            case R.id.text1 /*{ENCODED_INT: 2131296259}*/:
            case R.id.button /*{ENCODED_INT: 2131296260}*/:
            case R.id.tv2 /*{ENCODED_INT: 2131296262}*/:
            case R.id.noreg /*{ENCODED_INT: 2131296263}*/:
            case R.id.utility /*{ENCODED_INT: 2131296264}*/:
            case R.id.etext1 /*{ENCODED_INT: 2131296265}*/:
            case R.id.etext2 /*{ENCODED_INT: 2131296266}*/:
            case R.id.bAdd /*{ENCODED_INT: 2131296267}*/:
            default:
                return;
            case R.id.imageView2 /*{ENCODED_INT: 2131296261}*/:
                startActivity(new Intent(this, Alarm.class));
                return;
            case R.id.imageView4 /*{ENCODED_INT: 2131296268}*/:
                startActivity(new Intent(this, Password.class));
                return;
            case R.id.imageView3 /*{ENCODED_INT: 2131296269}*/:
                startActivity(new Intent(this, GeoLocation.class));
                return;
            case R.id.textView2 /*{ENCODED_INT: 2131296270}*/:
                startActivity(new Intent(this, Alarm.class));
                return;
            case R.id.textView4 /*{ENCODED_INT: 2131296271}*/:
                startActivity(new Intent(this, Password.class));
                return;
            case R.id.textView1 /*{ENCODED_INT: 2131296272}*/:
                startActivity(new Intent(this, Anti_Introduction.class));
                return;
            case R.id.textView3 /*{ENCODED_INT: 2131296273}*/:
                startActivity(new Intent(this, GeoLocation.class));
                return;
        }
    }
}
