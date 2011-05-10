package com.shinobi.example.timetracker;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import com.shinobi.example.timetracker.database.GlobalState;

/**
 * Created by IntelliJ IDEA.
 * User: Semy
 * Date: 10.05.11
 * Time: 12:07
 * To change this template use File | Settings | File Templates.
 */
public class TagsAdtivity extends Activity {

    private GlobalState globalState;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.tagseditview);

        this.globalState = (GlobalState) getApplication();

        InitializeSpinner();
        InitializeAddItemButton();
        InitializeRemoveItemButton();
    }

    private void InitializeSpinner() {

        Spinner tagComboBox = (Spinner) findViewById(R.id.tagComboBox);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.tagsNames, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tagComboBox.setAdapter(adapter);

        String defaultTag = globalState.CurrentTag();
        int position = adapter.getPosition(defaultTag);
        tagComboBox.setSelection(position);
    }

    private void InitializeAddItemButton() {

        Button addItemBtn = (Button) findViewById(R.id.addSpinnerItemButton);
        addItemBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                GlobalState globalState = (GlobalState) getApplication();
                TextView textView = (TextView) findViewById(R.id.newTagTextBox);
                String tag = textView.getText().toString();
                globalState.AddTag(tag);
            }
        });
    }

    private void InitializeRemoveItemButton() {

        Button remItemBtn = (Button) findViewById(R.id.remSpinnerItemButton);
        remItemBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                GlobalState globalState = (GlobalState) getApplication();
                Spinner spinner = (Spinner) findViewById(R.id.tagComboBox);
                String tag = spinner.getSelectedItem().toString();
                globalState.RemoveTag(tag);
            }
        });
    }

}