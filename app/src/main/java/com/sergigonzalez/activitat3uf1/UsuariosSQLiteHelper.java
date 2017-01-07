package com.sergigonzalez.activitat3uf1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.lang.reflect.Array;

/**
 * Created by ALUMNEDAM on 30/11/2016.
 */

public class UsuariosSQLiteHelper extends SQLiteOpenHelper
{
    //Sentencia de crear tablas

     String sqlCreate [] = {"CREATE TABLE Horario (grupo VARCHAR2(2), id_horario NUMBER PRIMARY KEY," +
            " cod_asignatura VARCHAR2(3), hora_inicio VARCHAR2(8), hora_fin VARCHAR2(8), dia NUMBER)",
             "CREATE TABLE Modulo (cod_asignatura VARCHAR2(3), id_profesor NUMBER, nombre_asignatura VARCHAR2(20))",
             "CREATE TABLE Profesor (id_profesor VARCHAR2(2) PRIMARY KEY, nombre VARCHAR2(20), apellidos VARCHAR2(50))"};

    //Sentencia de insertar modulos

    String sqlInsertM [] = {"INSERT INTO Modulo VALUES('M05', 1, 'Entorns de Desenvolupament')"
    ,"INSERT INTO Modulo VALUES('M02', 1, 'Base de Dades')"
    ,"INSERT INTO Modulo VALUES('M06', 1, 'Acces a Dades')"};

    //Sentencia de insertar profesores
    String sqlInsertP [] = {"INSERT INTO Profesor VALUES(1, 'Jorge', 'Rubio')"
    ,"INSERT INTO Profesor VALUES(2, 'Josefa', 'Gonzalez')"};

    //Sentencia de insertar profesores
    String sqlInsertH [] = {"INSERT INTO Horario VALUES('A1', 1, 'M7', '15:00', '16:00', 1)"
    ,"INSERT INTO Horario VALUES('A1', 2, 'M7', '16:00', '17:00', 1)"
    ,"INSERT INTO Horario VALUES('A1', 3, 'M7', '17:00', '18:00', 1)"};

    public UsuariosSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {

            for (int i = 0; i < sqlCreate.length; i++)
            {
                db.execSQL(sqlCreate[i]);
            }
            for (int i = 0; i < sqlInsertM.length; i++)
            {
                db.execSQL(sqlInsertM[i]);
            }
            for (int i = 0; i < sqlInsertP.length; i++)
            {
                db.execSQL(sqlInsertP[i]);
            }
            for (int i = 0; i < sqlInsertH.length; i++)
            {
                db.execSQL(sqlInsertH[i]);
            }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {
        //No se pone nada
    }
}
