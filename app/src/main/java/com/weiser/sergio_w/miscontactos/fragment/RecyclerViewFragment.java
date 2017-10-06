package com.weiser.sergio_w.miscontactos.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.weiser.sergio_w.miscontactos.R;
import com.weiser.sergio_w.miscontactos.adapter.ContactoAdapter;
import com.weiser.sergio_w.miscontactos.pojo.Contacto;
import com.weiser.sergio_w.miscontactos.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;


public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView {

    private ArrayList<Contacto> contactos;
    private RecyclerView rvLista;
    private RecyclerViewFragmentPresenter presenter;

    public RecyclerViewFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);
        this.rvLista = (RecyclerView) v.findViewById(R.id.rvLista);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());
        return v;
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        this.rvLista.setLayoutManager(llm);
    }

    @Override
    public ContactoAdapter crearAdaptador(ArrayList<Contacto> contactos) {
        ContactoAdapter contactoAdapter = new ContactoAdapter(contactos, getActivity());
        return contactoAdapter;
    }

    @Override
    public void inicializarAdaptadorRV(ContactoAdapter contactoAdapter) {
        this.rvLista.setAdapter(contactoAdapter);
    }
}
