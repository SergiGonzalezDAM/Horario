package com.sergigonzalez.activitat3uf1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Settings extends AppCompatActivity implements View.OnClickListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Button btnApply = (Button) findViewById(R.id.buttonApply);
        btnApply.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.buttonApply)
        {
            Intent i = new Intent(this,MainActivity.class);
            startActivity(i);
            EditText name = (EditText) findViewById(R.id.editTextName);
            Spinner group = (Spinner) findViewById(R.id.spinnerGroup);
            Spinner colour = (Spinner) findViewById(R.id.spinnerColour);
            Spinner font = (Spinner) findViewById(R.id.spinnerFont);

            SharedPreferences prefs =
                    getSharedPreferences("CalendarioDAM", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("nombre",name.getText().toString());
            editor.putString("group",group.getSelectedItem().toString());
            editor.putString("colour",colour.getSelectedItem().toString());
            editor.putString("font",font.getSelectedItem().toString());
            editor.commit();
        }
    }
}
