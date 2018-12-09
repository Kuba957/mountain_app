package com.app.mountainapp;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class BaseActivity extends AppCompatActivity {

    protected boolean isFlashWorking = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Context context = getApplicationContext();


        if (id == R.id.action_flashlight) {
            if(context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)) {

                try {
                    Camera cam = Camera.open();
                    Camera.Parameters p = cam.getParameters();
                    if (!isFlashWorking) {

                        p.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                        cam.setParameters(p);
                        cam.startPreview();
                        isFlashWorking = true;
                    } else {
                        cam.stopPreview();
                        cam.release();
                        isFlashWorking = false;
                    }
                }catch (Exception ex){
                    Toast.makeText(context,"Pozwól na dostęp aplikacji do aparatu",Toast.LENGTH_LONG).show();
                }
            }
            return true;
        }
        else if(id == R.id.action_phone){
            Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
            phoneIntent.setData(Uri.parse("tel:"+getResources().getString(R.string.emergency_phone)));
            startActivity(phoneIntent);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
