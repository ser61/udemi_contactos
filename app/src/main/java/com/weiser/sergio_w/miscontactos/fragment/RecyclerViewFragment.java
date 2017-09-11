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

import java.util.ArrayList;


public class RecyclerViewFragment extends Fragment {

    private ArrayList<Contacto> contactos;
    private RecyclerView rvLista;

    public RecyclerViewFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        this.rvLista = (RecyclerView) v.findViewById(R.id.rvLista);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        this.rvLista.setLayoutManager(llm);
        iniciarLista();
        iniciarAdapter();

        return v;
    }

    public void iniciarAdapter() {
        ContactoAdapter contactoAdapter = new ContactoAdapter(contactos, getActivity());
        this.rvLista.setAdapter(contactoAdapter);
    }

    public void iniciarLista() {
        this.contactos = new ArrayList<>();
        contactos.add(new Contacto("Sergio", "45789568", "sergio@gmail.com", R.drawable.user1));
        contactos.add(new Contacto("Dennis", "12459678", "denis@yahoo.es", R.drawable.user2));
        contactos.add(new Contacto("Sebastian", "7458912", "sebastian@yahoo.es", R.drawable.user3));
        contactos.add(new Contacto("Sandra", "754187", "sandra@yahoo.es", R.drawable.user1));
        contactos.add(new Contacto("Guido", "712459", "guido@yahoo.es", R.drawable.user2));
    }
}
