package com.weiser.sergio_w.miscontactos.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.weiser.sergio_w.miscontactos.pojo.Contacto;

import java.util.ArrayList;

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
    public void onCreate(SQLiteDatabase db) {
        String queryCreateContacto = "create table " + ConstantesBD.TABLE_CONTACT + "(" +
                ConstantesBD.TABLE_CONTACT_ID       + " integer primary key autoincrement, " +
                ConstantesBD.TABLE_CONTACT_NOMBRE   + " text, " +
                ConstantesBD.TABLE_CONTACT_TELEFONO + " text, " +
                ConstantesBD.TABLE_CONTACT_EMAIL    + " text, " +
                ConstantesBD.TABLE_CONTACT_FOTO     + " integer" +
                ")";

        String queryCreateContactoLikes = "create table " + ConstantesBD.TABLE_CONTACT_LIKES + "(" +
                ConstantesBD.TABLE_LIKES_ID                 + " integer primary key autoincrement, " +
                ConstantesBD.TABLE_LIKES_ID_CONTACTO        + " integer not null, " +
                ConstantesBD.TABLE_LIKES_NUMERO_LIKES       + " integer, " +
                "foreign key ("+ConstantesBD.TABLE_LIKES_ID_CONTACTO+") " +
                "references "+ ConstantesBD.TABLE_CONTACT   + "(" + ConstantesBD.TABLE_CONTACT_ID +")"+
                ")";

        db.execSQL(queryCreateContacto);
        db.execSQL(queryCreateContactoLikes);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exist " + ConstantesBD.TABLE_CONTACT);
        db.execSQL("drop table if exist " + ConstantesBD.TABLE_CONTACT_LIKES);
        onCreate(db);
    }
    
    public ArrayList<Contacto> obtenerTodosLosContactos() {
        ArrayList<Contacto> contactos = new ArrayList<>();

        String query = "select * from " + ConstantesBD.TABLE_CONTACT;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()) {
            Contacto contacto = new Contacto();
            contacto.setId(registros.getInt(0));
            contacto.setNombre(registros.getString(1));
            contacto.setTelefono(registros.getString(2));
            contacto.setEmail(registros.getString(3));
            contacto.setFoto(registros.getInt(4));

            contactos.add(contacto);
        }

        registros.close();
        db.close();

        return contactos;
    }

    public void insertarContacto(ContentValues contentValues) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBD.TABLE_CONTACT, null, contentValues);
        db.close();
    }
}
