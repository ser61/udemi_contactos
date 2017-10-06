package com.weiser.sergio_w.miscontactos.presentador;

import android.content.Context;

import com.weiser.sergio_w.miscontactos.db.ConstructorContacto;
import com.weiser.sergio_w.miscontactos.fragment.IRecyclerViewFragmentView;
import com.weiser.sergio_w.miscontactos.pojo.Contacto;

import java.util.ArrayList;

/**
 * Created by Sergio_W on 06/10/2017.
 */

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter{

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorContacto constructorContacto;
    private ArrayList<Contacto> contactos;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerContactosBaseDatos();
    }

    @Override
    public void obtenerContactosBaseDatos() {
        this.constructorContacto = new ConstructorContacto(context);
        contactos = constructorContacto.obtenerDatos();
        mostrarContactosRV();
    }

    @Override
    public void mostrarContactosRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(contactos));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }
}
