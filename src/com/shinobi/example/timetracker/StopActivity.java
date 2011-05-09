package com.shinobi.example.timetracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.shinobi.example.timetracker.com.shinobi.example.timetracker.database.GlobalState;

/**
 * Created by IntelliJ IDEA.
 * User: Semy
 * Date: 09.05.11
 * Time: 20:30
 * To change this template use File | Settings | File Templates.
 */
public class StopActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.stop);

        Button stopButton = (Button) findViewById(R.id.stopButton);
        stopButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                GlobalState state = (GlobalState) getApplication();
                state.StopTimer();
                startActivity(new Intent(StopActivity.this, StartActivity.class));
            }
        });



//        Button showChartButton = (Button) findViewById(R.id.showChartButton);
//        showChartButton.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(StopActivity.this, StatisticsActivity.class));
//            }
//        });
    }

}