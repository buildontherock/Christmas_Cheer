package com.example.austinrb.christmas_cheer;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;



public class MyActivity extends Activity {

    MediaPlayer christmasSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.christmas_layout);
        blinkText();
        
        christmasSong = MediaPlayer.create(MyActivity.this, R.raw.joy_to_the_world);
        christmasSong.start();

    }

    private void blinkText() {
        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                int timeToBlink = 500;    //in ms
                try{
                    Thread.sleep(timeToBlink);
                }catch (Exception e) {

                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        TextView txt = (TextView) findViewById(R.id.textView);
                        if(txt.getVisibility() == View.VISIBLE){
                            txt.setVisibility(View.INVISIBLE);
                        }else{
                            txt.setVisibility(View.VISIBLE);
                        }
                        blinkText();
                    }
                });
            }}).start();
    }

    @Override
    protected void onPause(){
        super.onPause();
        christmasSong.release();
        finish();
    }

}
