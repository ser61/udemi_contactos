package com.weiser.sergio_w.miscontactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Contacto> contactos;
    private ListView lvLista;
    private RecyclerView rvLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        this.rvLista = (RecyclerView) findViewById(R.id.rvLista);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        this.rvLista.setLayoutManager(llm);
        iniciarLista();
        iniciarAdapter();

        /*this.lvLista = (ListView) findViewById(R.id.lvLista);

        lvLista.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombres));

        lvLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetalleContacto.class);
                intent.putExtra("Nombre", contactos.get(i).getNombre());
                intent.putExtra("Telefono", contactos.get(i).getTelefono());
                intent.putExtra("Email", contactos.get(i).getEmail());
                startActivity(intent);
                finish();
            }
        });*/
    }

    public void iniciarAdapter() {
        ContactoAdapter contactoAdapter = new ContactoAdapter(contactos, this);
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
