package com.example.anti_theft;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ProgressBar;

public class WelcomeScreen extends Activity {
    ProgressBar pb;
    MediaPlayer song;

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.song.release();
        finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        this.pb = (ProgressBar) findViewById(R.id.progressBar);
        this.song = MediaPlayer.create(this, (int) R.raw.audio);
        this.song.start();
        new Thread() {
            /* class com.example.anti_theft.WelcomeScreen.AnonymousClass1 */

            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    WelcomeScreen.this.startActivity(new Intent(WelcomeScreen.this, Register.class));
                }
            }
        }.start();
    }
}
