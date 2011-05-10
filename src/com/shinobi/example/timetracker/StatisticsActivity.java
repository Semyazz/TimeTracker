package com.shinobi.example.timetracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

/**
 * Created by IntelliJ IDEA.
 * User: Semy
 * Date: 09.05.11
 * Time: 20:31
 * To change this template use File | Settings | File Templates.
 */
public class StatisticsActivity extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.stats);

        Spinner tagComboBox = (Spinner) findViewById(R.id.tagComboBox);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.tagsNames, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tagComboBox.setAdapter(adapter);


        Button gotoTagsEdit = (Button) findViewById(R.id.tagsEditButton);
        gotoTagsEdit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(StatisticsActivity.this, TagsAdtivity.class));
            }
        });


        //TODO: Get last position from database. Last used tag.

    }

    private void FetchResults() {
        //TODO: pobrać z bazy danych result spełniające zadany czas i wrzucić je na diagram... jakolwiek ma ten diagram wygladac :)

    }
}