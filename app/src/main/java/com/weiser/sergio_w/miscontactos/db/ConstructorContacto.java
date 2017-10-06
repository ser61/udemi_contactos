package com.weiser.sergio_w.miscontactos.db;

import android.content.ContentValues;
import android.content.Context;

import com.weiser.sergio_w.miscontactos.R;
import com.weiser.sergio_w.miscontactos.pojo.Contacto;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

/**
 * Created by Sergio_W on 06/10/2017.
 */

public class ConstructorContacto {

    private static final int LIKE = 1;
    private Context context;

    public ConstructorContacto(Context context) {
        this.context = context;
    }

    public ArrayList<Contacto> obtenerDatos() {
        BaseDatos db = new BaseDatos(context);
        insertarContactos(db);
        return db.obtenerTodosLosContactos();
    }

    public void insertarContactos(BaseDatos db) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_CONTACT_NOMBRE, "Sergio");
        contentValues.put(ConstantesBD.TABLE_CONTACT_TELEFONO, "45789568");
        contentValues.put(ConstantesBD.TABLE_CONTACT_EMAIL, "sergio@gmail.com");
        contentValues.put(ConstantesBD.TABLE_CONTACT_FOTO, R.drawable.user1);
        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_CONTACT_NOMBRE, "Dennis");
        contentValues.put(ConstantesBD.TABLE_CONTACT_TELEFONO, "12459678");
        contentValues.put(ConstantesBD.TABLE_CONTACT_EMAIL, "denis@yahoo.es");
        contentValues.put(ConstantesBD.TABLE_CONTACT_FOTO, R.drawable.user2);
        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_CONTACT_NOMBRE, "Sebastian");
        contentValues.put(ConstantesBD.TABLE_CONTACT_TELEFONO, "7458912");
        contentValues.put(ConstantesBD.TABLE_CONTACT_EMAIL, "sebastian@yahoo.es");
        contentValues.put(ConstantesBD.TABLE_CONTACT_FOTO, R.drawable.user3);
        db.insertarContacto(contentValues);

    }

    public void darLike(Contacto contacto) {
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_LIKES_ID_CONTACTO, contacto.getId());
        contentValues.put(ConstantesBD.TABLE_LIKES_NUMERO_LIKES, LIKE);
        db.insertarLikeContacto(contentValues);
    }

    public int obtenerLikesContactos(Contacto contacto) {
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesContacto(contacto);
    }
}
