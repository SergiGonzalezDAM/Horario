package com.sergigonzalez.activitat3uf1;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;

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
        int hora = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        int minuto = Calendar.getInstance().get(Calendar.MINUTE);
        int dia = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        String name = prefs.getString("nombre", "Nombre");
        String colour = prefs.getString("colour", "Blanco");
        String group = prefs.getString("group", "A1");
        String font = prefs.getString("font", "Sans-serif");
        TextView textoBienvenida = (TextView) findViewById(R.id.textview);
        TextView textoProfesor = (TextView) findViewById(R.id.textViewProf);
        TextView textoAsignatura = (TextView)findViewById(R.id.textViewAss);
        TextView textoHoraInicio = (TextView)findViewById(R.id.textViewHii);
        TextView textHoraFin = (TextView) findViewById(R.id.textViewHFf);
        textoBienvenida.setText("Bienvenido/a " + name + " del grupo " + group);
        Cursor c = db.rawQuery("SELECT cod_asignatura, hora_inicio, hora_fin FROM Horario WHERE" +
                "('"+ hora + ":" + minuto +"' BETWEEN hora_inicio AND hora_fin) AND (dia = " + dia +")",null);
        if (c.moveToFirst())
        {
            do
            {
                String codAsignatura = c.getString(0);
                String horaInicio = c.getString(1);
                String horaFin = c.getString(2);

                textoAsignatura.setText(codAsignatura);
                textoHoraInicio.setText(horaInicio);
                textHoraFin.setText(horaFin);

            }while(c.moveToNext());
        }
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