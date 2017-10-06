package com.weiser.sergio_w.miscontactos.db;

import android.content.ContentValues;
import android.content.Context;

import com.weiser.sergio_w.miscontactos.R;
import com.weiser.sergio_w.miscontactos.pojo.Contacto;

import java.util.ArrayList;

/**
 * Created by Sergio_W on 06/10/2017.
 */

public class ConstructorContacto {

    private Context context;

    public ConstructorContacto(Context context) {
        this.context = context;
    }

    public ArrayList<Contacto> obtenerDatos() {
        /*ArrayList<Contacto> contactos = new ArrayList<>();
        contactos.add(new Contacto("Sergio", "45789568", "sergio@gmail.com", R.drawable.user1, 8));
        contactos.add(new Contacto("Dennis", "12459678", "denis@yahoo.es", R.drawable.user2, 5));
        contactos.add(new Contacto("Sebastian", "7458912", "sebastian@yahoo.es", R.drawable.user3, 1));
        contactos.add(new Contacto("Sandra", "754187", "sandra@yahoo.es", R.drawable.user1, 4));
        contactos.add(new Contacto("Guido", "712459", "guido@yahoo.es", R.drawable.user2, 7));*/

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
}
