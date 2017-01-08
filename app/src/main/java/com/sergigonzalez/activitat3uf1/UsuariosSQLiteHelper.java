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
             "CREATE TABLE Modulo (cod_asignatura VARCHAR2(3), id_profesor NUMBER, nombre_asignatura VARCHAR2(100))",
             "CREATE TABLE Profesor (id_profesor VARCHAR2(2) PRIMARY KEY, nombre VARCHAR2(20), apellidos VARCHAR2(50))"};

    //Sentencia de insertar modulos

    String sqlInsertM [] = {"INSERT INTO Modulo VALUES('M05', 1, 'Entorns de Desenvolupament')"
    ,"INSERT INTO Modulo VALUES('M02', 1, 'Base de Dades')"
    ,"INSERT INTO Modulo VALUES('M06', 1, 'Acces a Dades')"
    ,"INSERT INTO Modulo VALUES('Tut', 2, 'Tutoria')"
    ,"INSERT INTO Modulo VALUES('M03', 2, 'Programació basica')"
    ,"INSERT INTO Modulo VALUES('M07', 5, 'Desenvolupament de interficies')"
    ,"INSERT INTO Modulo VALUES('M08', 3, 'Prog. multimèdia i dispositius mobils')"
    ,"INSERT INTO Modulo VALUES('M10', 4, 'Sistemes de gestio empresarials')"
    ,"INSERT INTO Modulo VALUES('M09', 1, 'Programació de serveis i processos')"};

    //Sentencia de insertar profesores
    String sqlInsertP [] = {"INSERT INTO Profesor VALUES(1, 'Jorge', 'Rubio')"
    ,"INSERT INTO Profesor VALUES(2, 'Josefa', 'Gonzalez')"
    ,"INSERT INTO Profesor VALUES(3, 'Lluis','Perpiñà')"
    ,"INSERT INTO Profesor VALUES(4, 'Marta','Planas')"
    ,"INSERT INTO Profesor VALUES(5, 'Jose', 'Leo')"};

    //Sentencia de insertar profesores
    String sqlInsertH [] = {"INSERT INTO Horario VALUES('A2', 1, 'M7', '15:00', '16:00', 1)"
    ,"INSERT INTO Horario VALUES('A2', 2, 'M07', '16:00', '17:00', 1)"
    ,"INSERT INTO Horario VALUES('A2', 3, 'M07', '17:00', '18:00', 1)"
    ,"INSERT INTO Horario VALUES('A2', 4, 'PAT', '18:00', '18:20', 1)"
    ,"INSERT INTO Horario VALUES('A2', 5, 'TUT', '18:20', '19:20', 1)"
    ,"INSERT INTO Horario VALUES('A2', 6, 'M03', '19:20', '20:20', 1)"
    ,"INSERT INTO Horario VALUES('A2', 7, 'M03', '20:20', '21:20', 1)"
    ,"INSERT INTO Horario VALUES('A2', 8, 'M08', '15:00', '16:00', 2)"
    ,"INSERT INTO Horario VALUES('A2', 9, 'M08', '16:00', '17:00', 2)"
    ,"INSERT INTO Horario VALUES('A2', 10, 'M10', '17:00', '18:00', 2)"
    ,"INSERT INTO Horario VALUES('A2', 11, 'PAT', '18:00', '18:20', 2)"
    ,"INSERT INTO Horario VALUES('A2', 12, 'M10', '18:20', '19:20', 2)"
    ,"INSERT INTO Horario VALUES('A2', 13, 'M05', '19:20', '20:20', 2)"
    ,"INSERT INTO Horario VALUES('A2', 14, 'M05', '20:20', '21:20', 2)"
    ,"INSERT INTO Horario VALUES('A2', 15, 'M05', '16:00', '17:00', 3)"
    ,"INSERT INTO Horario VALUES('A2', 16, 'M08', '17:00', '18:00', 3)"
    ,"INSERT INTO Horario VALUES('A2', 17, 'PAT', '18:00', '18:20', 3)"
    ,"INSERT INTO Horario VALUES('A2', 18, 'M08', '18:00', '19:20', 3)"
    ,"INSERT INTO Horario VALUES('A2', 19, 'M09', '19:00', '20:20', 3)"
    ,"INSERT INTO Horario VALUES('A2', 20, 'M03', '16:00', '17:00', 4)"
    ,"INSERT INTO Horario VALUES('A2', 21, 'M03', '17:00', '18:00', 4)"
    ,"INSERT INTO Horario VALUES('A2', 22, 'PAT', '18:00', '18:20', 4)"
    ,"INSERT INTO Horario VALUES('A2', 23, 'M05', '18:20', '19:20', 4)"
    ,"INSERT INTO Horario VALUES('A2', 24, 'M05', '19:20', '20:20', 4)"
    ,"INSERT INTO Horario VALUES('A2', 25, 'M05', '20:20', '21:20', 4)"
    ,"INSERT INTO Horario VALUES('A2', 26, 'M10', '15:00', '16:00', 5)"
    ,"INSERT INTO Horario VALUES('A2', 27, 'M10', '16:00', '17:00', 5)"
    ,"INSERT INTO Horario VALUES('A2', 28, 'M09', '17:00', '18:00', 5)"
    ,"INSERT INTO Horario VALUES('A2', 29, 'PAT', '18:00', '18:20', 5)"
    ,"INSERT INTO Horario VALUES('A2', 30, 'M09', '18:20', '19:20', 5)"
    ,"INSERT INTO Horario VALUES('A2', 31, 'M05', '19:20', '20:20', 5)"
    ,"INSERT INTO Horario VALUES('A2', 32, 'M05', '20:20', '21:20', 5)"};

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
