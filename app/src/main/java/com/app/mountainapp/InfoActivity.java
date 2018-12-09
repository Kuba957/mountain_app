package com.app.mountainapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class InfoActivity extends BaseActivity {

    private ListView listView ;
    private ArrayAdapter<String> adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.info);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        listView = (ListView)findViewById(R.id.list_info);

        String[] info_titles = this.getResources().getStringArray(R.array.info_list);

        adapter = new ArrayAdapter<String>(this, R.layout.info_card,R.id.text1,info_titles);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Intent intent = new Intent(view.getContext(),ConditionActivity.class);
                    startActivity(intent);
                }
                else if(position == 1){
                    Intent intent = new Intent((view.getContext()),AvalancheActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
}
