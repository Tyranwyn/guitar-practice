package com.fux.guitarpracticewear;

import android.support.wearable.activity.WearableActivity;
import android.widget.Button;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

@EActivity(R.layout.activity_main)
public class MainActivity extends WearableActivity {

    List<String> notes = new ArrayList<>();

    @ViewById
    TextView n1;
    @ViewById
    TextView n2;
    @ViewById
    TextView n3;
    @ViewById
    TextView n4;
    @ViewById
    Button button;

    @AfterViews
    void onCreate() {
        setAmbientEnabled();
    }

    @AfterViews
    void setInitValues() {
        notes.add("A");
        notes.add("A#");
        notes.add("B");
        notes.add("C");
        notes.add("C#");
        notes.add("D");
        notes.add("D#");
        notes.add("E");
        notes.add("F");
        notes.add("G");
        notes.add("G#");
        randomizeNotes();
    }

    @Click(R.id.button)
    void randomizeNotes() {
        n1.setText(getRandomNote());
        n2.setText(getRandomNote());
        n3.setText(getRandomNote());
        n4.setText(getRandomNote());
    }

    private String getRandomNote() {
        List<String> filteredNotes = new ArrayList<>(notes);
        filteredNotes.remove(n1.getText().toString());
        filteredNotes.remove(n2.getText().toString());
        filteredNotes.remove(n3.getText().toString());
        filteredNotes.remove(n4.getText().toString());

        return filteredNotes.get((int) Math.floor(Math.random() * 7));
    }
}
