package com.shinobi.example.timetracker;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import com.shinobi.example.timetracker.database.GlobalState;
import com.shinobi.example.timetracker.settings.Settings;

/**
 * Created by IntelliJ IDEA.
 * User: Semy
 * Date: 09.05.11
 * Time: 20:30
 * To change this template use File | Settings | File Templates.
 */
public class StartActivity extends Activity {

    private GlobalState globalState;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.start);

        this.globalState = (GlobalState) getApplication();

        InitializeStartButton();
        InitializeShowChartButton();
        InitializeSpinnerComboBox();
    }

    private void InitializeStartButton() {
        Button btn = (Button) findViewById(R.id.startButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GlobalState state = (GlobalState) getApplication();
                Spinner s = (Spinner) findViewById(R.id.tagComboBox);
                String selectedTag = s.getSelectedItem().toString();
                state.StartTimer(selectedTag);
                startActivity(new Intent(StartActivity.this, StopActivity.class));
            }
        });
    }

    private void InitializeShowChartButton() {
        Button showChartButton = (Button) findViewById(R.id.showChartButton);
        showChartButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(StartActivity.this, StatisticsActivity.class));
            }
        });
    }

    private void InitializeSpinnerComboBox() {
        Spinner tagComboBox = (Spinner) findViewById(R.id.tagComboBox);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.tagsNames, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tagComboBox.setAdapter(adapter);

        String defaultTag  = globalState.CurrentTag();
        int position = adapter.getPosition(defaultTag);
        tagComboBox.setSelection(position);
    }
}