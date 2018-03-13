package com.example.android.sharedprefs;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private Button saveButton;
    private TextView resultTextView;
    private EditText editText;
    private SharedPreferences myPrefs;
    private static final String PREFS_NAME = "myPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saveButton = (Button)findViewById(R.id.sav_btn);
        resultTextView = (TextView) findViewById(R.id.txt_view);
        editText = (EditText) findViewById(R.id.edit_text_enter);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myPrefs = getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor editor = myPrefs.edit();

                editor.putString("message", editText.getText().toString());
                editor.commit();

            }
        });

        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, 0);

        if(prefs.contains("message")){
            String message = prefs.getString("message", "not found");
            resultTextView.setText(message);
        }
    }
}
