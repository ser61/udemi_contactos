package com.weiser.sergio_w.miscontactos.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Sergio_W on 06/10/2017.
 */

public class BaseDatos extends SQLiteOpenHelper {

    Context context;

    public BaseDatos(Context context) {
        super(context, ConstantesBD.DATEBASE_NAME, null, ConstantesBD.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String queryCreateContacto = "create table ";
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
