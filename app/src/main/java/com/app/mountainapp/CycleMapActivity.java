package com.app.mountainapp;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import uk.co.senab.photoview.PhotoViewAttacher;

public class CycleMapActivity extends BaseActivity {

    private ImageView mImageView;
    private PhotoViewAttacher mPhotoViewAttacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cycle_map);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.cycle_map);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mImageView = (ImageView) findViewById(R.id.cycle_map_photo);
        Drawable bitmap = getResources().getDrawable(R.drawable.cycle_map_1);
        mImageView.setImageDrawable(bitmap);
        mPhotoViewAttacher = new PhotoViewAttacher(mImageView);
    }
}
