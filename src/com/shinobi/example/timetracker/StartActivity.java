package com.shinobi.example.timetracker;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.shinobi.example.timetracker.com.shinobi.example.timetracker.database.GlobalState;

/**
 * Created by IntelliJ IDEA.
 * User: Semy
 * Date: 09.05.11
 * Time: 20:30
 * To change this template use File | Settings | File Templates.
 */
public class StartActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.start);

        GlobalState state = (GlobalState) getApplication();

        Button btn = (Button) findViewById(R.id.startButton);
        btn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                GlobalState state = (GlobalState) getApplication();
                state.StartTimer("TAG");
                startActivity(new Intent(StartActivity.this, StopActivity.class));
            }
        });

        Button showChartButton = (Button) findViewById(R.id.showChartButton);
        showChartButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(StartActivity.this, StatisticsActivity.class));
            }
        });
    }
}