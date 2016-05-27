package com.example.carolynhemmings.sharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private EditText name;
    private TextView showNameText;
    private static final String PREFERENCES_NAME = "MyPreferencesFile";
    private Button saveName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.nameEditText);
        showNameText = (TextView) findViewById(R.id.showMyNameTextView);

        saveName = (Button) findViewById(R.id.saveButton);
        saveName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences myPrefs = getSharedPreferences(PREFERENCES_NAME, 0); // This is the name of the shared preferences file
                // or SharedPreferences myPrefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = myPrefs.edit();

                if (name.getText().toString().equals("")){

                    Toast.makeText(getApplicationContext(), "Please enter a name.", Toast.LENGTH_LONG).show();

                }else {

                    editor.putString("name", name.getText().toString());
                    editor.commit();
                }



            }
        });

        //get data back
        SharedPreferences prefs = getSharedPreferences(PREFERENCES_NAME, 0);

        if ( prefs.contains("name")){
            String userName = prefs.getString("name", "not found");
            showNameText.setText("You are " + userName);
        }else {

            showNameText.setText("");
        }
    }



}
