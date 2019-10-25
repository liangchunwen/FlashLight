package com.runbo.flashlight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "MainActivity_TAG";
    ImageView fSwitch, lStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fSwitch = findViewById(R.id.flashlightSwitch);
        fSwitch.setOnClickListener(this);
        lStatus = findViewById(R.id.light_status);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.flashlightSwitch) {
            int status = Settings.System.getInt(getContentResolver(), "flashlight_status", 0);
            Intent intent = new Intent("com.runbo.flashlight.switch");
            if (status == 1) {
                fSwitch.setBackground(getDrawable(R.drawable.flashlight_switcher_off));
                lStatus.setBackground(getDrawable(R.drawable.flashlight_light_off));
                intent.putExtra("status", false);
            } else {
                fSwitch.setBackground(getDrawable(R.drawable.flashlight_switcher_on));
                lStatus.setBackground(getDrawable(R.drawable.flashlight_light_on));
                intent.putExtra("status", true);
            }
            sendBroadcast(intent);
        }
    }
}
