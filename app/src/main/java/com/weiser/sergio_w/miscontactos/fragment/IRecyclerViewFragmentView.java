package com.weiser.sergio_w.miscontactos.fragment;

import com.weiser.sergio_w.miscontactos.adapter.ContactoAdapter;
import com.weiser.sergio_w.miscontactos.pojo.Contacto;

import java.util.ArrayList;

/**
 * Created by Sergio_W on 06/10/2017.
 */

public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();

    public ContactoAdapter crearAdaptador(ArrayList<Contacto> contactos);

    public void inicializarAdaptadorRV(ContactoAdapter contactoAdapter);
}
