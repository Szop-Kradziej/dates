package com.drabarz.karola.dates;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        addStartAdventureListener();
    }

    private void addStartAdventureListener() {
        TextView startAdventureButton = (TextView) findViewById(R.id.start_adventure);
        startAdventureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startCameraActivity();
            }
        });
    }

    private void startCameraActivity() {
        startActivity(new Intent(this, CameraActivity.class));
    }
}
