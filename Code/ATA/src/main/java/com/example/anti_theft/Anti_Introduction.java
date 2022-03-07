package com.example.anti_theft;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class Anti_Introduction extends Activity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anti__introduction);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.anti__introduction, menu);
        return true;
    }
}
