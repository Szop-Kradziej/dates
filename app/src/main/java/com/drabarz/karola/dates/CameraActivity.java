package com.drabarz.karola.dates;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CameraActivity extends AppCompatActivity {

    int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.camera_activity);

        addStartCameraButtonListener();
    }

    private void addStartCameraButtonListener() {
        Button startCameraButton = (Button) findViewById(R.id.start_camera);
        startCameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startCamera();
            }
        });
    }

    private void startCamera() {
        dispatchTakePictureIntent();
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            List<Integer> colorHashes = extractColorHashes(imageBitmap);
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            sharedPreferences.edit().putStringSet("colors", toStringSet(colorHashes));

            startStyleActivity();
        }
    }

    void startStyleActivity() {
        startActivity(new Intent(this, StyleActivity.class));
    }

    private Set<String> toStringSet(List<Integer> colorHashes) {
        HashSet<String> colorStringSet = new HashSet<>();
        for (Integer colorHash : colorHashes) {
            colorStringSet.add(colorHash.toString());
        }

        return colorStringSet;
    }

    private List<Integer> extractColorHashes(Bitmap imageBitmap) {
        List<Integer> colorHashesList = new ArrayList<>();
        colorHashesList.add(0x552244);
        colorHashesList.add(0xaa0011);
        colorHashesList.add(0x113344);
        colorHashesList.add(0x332255);
        colorHashesList.add(0x110000);
        return colorHashesList;
    }
}
