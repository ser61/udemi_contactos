package com.weiser.sergio_w.miscontactos.db;

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
        ArrayList<Contacto> contactos = new ArrayList<>();
        contactos.add(new Contacto("Sergio", "45789568", "sergio@gmail.com", R.drawable.user1, 8));
        contactos.add(new Contacto("Dennis", "12459678", "denis@yahoo.es", R.drawable.user2, 5));
        contactos.add(new Contacto("Sebastian", "7458912", "sebastian@yahoo.es", R.drawable.user3, 1));
        contactos.add(new Contacto("Sandra", "754187", "sandra@yahoo.es", R.drawable.user1, 4));
        contactos.add(new Contacto("Guido", "712459", "guido@yahoo.es", R.drawable.user2, 7));
        return contactos;
    }
}
