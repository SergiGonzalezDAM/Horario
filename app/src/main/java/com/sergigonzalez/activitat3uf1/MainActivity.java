package com.sergigonzalez.activitat3uf1;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        SQLiteDatabase db;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UsuariosSQLiteHelper dataBase =
                new UsuariosSQLiteHelper(this, "DBHorarios", null, 1);
        db = dataBase.getWritableDatabase();

        SharedPreferences prefs =
                getSharedPreferences("CalendarioDAM", Context.MODE_PRIVATE);

        String name = prefs.getString("nombre", "Nombre");
        String colour = prefs.getString("colour", "Blanco");
        String group = prefs.getString("group", "A1");
        String font = prefs.getString("font", "Sans-serif");
        TextView textoBienvenida = (TextView) findViewById(R.id.textview);
        textoBienvenida.setText("Bienvenido/a " + name);

        switch (colour)
        {
            case "Blanco":
                findViewById(R.id.activity_main).setBackgroundColor(Color.WHITE);
                break;
            case "Rojo":
                findViewById(R.id.activity_main).setBackgroundColor(Color.RED);
                break;
            case "Verde" :
                findViewById(R.id.activity_main).setBackgroundColor(Color.GREEN);
                break;
        }
        switch (font)
        {
            case "Sans-serif":
                textoBienvenida.setTypeface(Typeface.SANS_SERIF);
                break;
            case "Serif":
                textoBienvenida.setTypeface(Typeface.SERIF);
                break;
            case "Monospace":
                textoBienvenida.setTypeface(Typeface.MONOSPACE);
                break;
        }

    }
}
