package com.shinobi.example.timetracker;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.shinobi.example.timetracker.com.shinobi.example.timetracker.database.TimerResult;

/**
 * Created by IntelliJ IDEA.
 * User: Semy
 * Date: 09.05.11
 * Time: 20:31
 * To change this template use File | Settings | File Templates.
 */
public class StatisticsActivity extends Activity {

    private String arraySpinner[];

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.stats);

        Spinner tagComboBox = (Spinner) findViewById(R.id.tagComboBox);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.tagsNames, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tagComboBox.setAdapter(adapter);

        //TODO: Get last position from database. Last used tag.

    }

    private void FetchResults() {
        //TODO: pobrać z bazy danych result spełniające zadany czas i wrzucić je na diagram... jakolwiek ma ten diagram wygladac :)

    }
}