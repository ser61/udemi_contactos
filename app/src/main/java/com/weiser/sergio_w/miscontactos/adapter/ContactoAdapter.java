package com.weiser.sergio_w.miscontactos.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.weiser.sergio_w.miscontactos.pojo.Contacto;
import com.weiser.sergio_w.miscontactos.DetalleContacto;
import com.weiser.sergio_w.miscontactos.R;

import java.util.ArrayList;

/**
 * Created by Sergio_W on 10/09/2017.
 */
public class ContactoAdapter extends RecyclerView.Adapter<ContactoAdapter.ContactoViewHolder>{

    private ArrayList<Contacto> contactos;
    private Activity activity;

    public ContactoAdapter(ArrayList<Contacto> contactos, Activity activity) {
        this.contactos = contactos;
        this.activity = activity;
    }

    @Override
    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contactos, parent, false);
        return new ContactoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactoViewHolder contactoViewHolder, int position) {
        final Contacto contacto = contactos.get(position);
        contactoViewHolder.ivFoto.setImageResource(contacto.getFoto());
        contactoViewHolder.tvNombre.setText(contacto.getNombre());
        contactoViewHolder.tvTelefono.setText(contacto.getTelefono());

        contactoViewHolder.ivFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, contacto.getNombre(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, DetalleContacto.class);
                intent.putExtra("Nombre", contacto.getNombre());
                intent.putExtra("Telefono", contacto.getTelefono());
                intent.putExtra("Email", contacto.getEmail());
                activity.startActivity(intent);
            }
        });
        
        contactoViewHolder.ivLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "Diste Like a: " + contacto.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.contactos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder{

        private TextView tvNombre, tvTelefono;
        private ImageView ivFoto, ivLike;

        public ContactoViewHolder(View itemView) {
            super(itemView);
            this.ivFoto = (ImageView) itemView.findViewById(R.id.ivFoto);
            this.tvNombre = (TextView) itemView.findViewById(R.id.tvNombre);
            this.tvTelefono = (TextView) itemView.findViewById(R.id.tvTelefono);
            this.ivLike = (ImageView) itemView.findViewById(R.id.ivLike);
        }
    }
}
