package com.weiser.sergio_w.miscontactos;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Sergio_W on 10/09/2017.
 */
public class ContactoAdapter extends RecyclerView.Adapter<ContactoAdapter.ContactoViewHolder>{

    private ArrayList<Contacto> contactos;

    public ContactoAdapter(ArrayList<Contacto> contactos) {
        this.contactos = contactos;
    }

    @Override
    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contactos, parent, false);
        return new ContactoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactoViewHolder contactoViewHolder, int position) {
        Contacto contacto = contactos.get(position);
        contactoViewHolder.ivFoto.setImageResource(contacto.getFoto());
        contactoViewHolder.tvNombre.setText(contacto.getNombre());
        contactoViewHolder.tvTelefono.setText(contacto.getTelefono());
    }

    @Override
    public int getItemCount() {
        return this.contactos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder{

        private TextView tvNombre, tvTelefono;
        private ImageView ivFoto;

        public ContactoViewHolder(View itemView) {
            super(itemView);
            this.ivFoto = (ImageView) itemView.findViewById(R.id.ivFoto);
            this.tvNombre = (TextView) itemView.findViewById(R.id.tvNombre);
            this.tvTelefono = (TextView) itemView.findViewById(R.id.tvTelefono);
        }
    }
}
