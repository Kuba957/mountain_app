package com.app.mountainapp;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class ConditionActivity extends BaseActivity {

    TextView titleView;
    TextView trailConditionView;
    TextView threatsView;
    TextView adviceView;
    TextView closedTrailView;
    TextView additionalInfoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_condition);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getStringArray(R.array.info_list)[0]);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        titleView = (TextView)findViewById(R.id.info_title);
        trailConditionView = (TextView)findViewById(R.id.trail_condition);
        threatsView = (TextView)findViewById(R.id.threats);
        adviceView = (TextView)findViewById(R.id.advice);
        closedTrailView = (TextView)findViewById(R.id.closed_trail);
        additionalInfoView = (TextView)findViewById(R.id.additional_info);

        getWebsite();
    }

    private void getWebsite() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                final StringBuilder title = new StringBuilder();
                final StringBuilder trailCondition = new StringBuilder();
                final StringBuilder threats = new StringBuilder();
                final StringBuilder advice = new StringBuilder();
                final StringBuilder closedTrail = new StringBuilder();
                final StringBuilder additionalInfo = new StringBuilder();
                int counter = 0;

                try {
                    Document doc = Jsoup.connect(getString(R.string.tourist_communicate_website)).get();
                    Elements mainBody = doc.select("div.mceContentBody");
                    title.append(mainBody.select("strong").first().text()).append("\n").append(
                            mainBody.select("span").first().text()).append("\n");
                    Elements mContent = mainBody.select("div.m-content");
                    for(Element content : mContent){
                        if(counter == 0){
                            trailCondition.append("\n").append(content.text()).append("\n");
                        }
                        else if(counter == 2){
                            threats.append("\n").append(content.text()).append("\n");
                        }
                        else if(counter == 3){
                            advice.append("\n").append(content.text()).append("\n");
                        }
                        else if(counter == 4){
                            closedTrail.append("\n").append(content.text()).append("\n");
                        }
                        else if(counter == 5){
                            additionalInfo.append("\n").append(content.text());
                        }
                        counter++;
                    }

                } catch (IOException e) {
                    title.append("Error : ").append(e.getMessage()).append("\n");
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        titleView.setText(title.toString());
                        trailConditionView.setText(trailCondition);
                        threatsView.setText(threats);
                        adviceView.setText(advice);
                        closedTrailView.setText(closedTrail);
                        additionalInfoView.setText(additionalInfo);
                    }
                });
            }
        }).start();
    }
}

