package com.weiser.sergio_w.miscontactos;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import com.weiser.sergio_w.miscontactos.adapter.ContactoAdapter;
import com.weiser.sergio_w.miscontactos.adapter.PageAdaptor;
import com.weiser.sergio_w.miscontactos.fragment.PerfilFragment;
import com.weiser.sergio_w.miscontactos.fragment.RecyclerViewFragment;
import com.weiser.sergio_w.miscontactos.pojo.Contacto;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Contacto> contactos;
    private ListView lvLista;
    private RecyclerView rvLista;
    private Toolbar tvToolbar;
    private TabLayout tlTab;
    private ViewPager vpPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.tvToolbar = (Toolbar) findViewById(R.id.tbToolbar);
        this.tlTab = (TabLayout) findViewById(R.id.tabTab);
        this.vpPage = (ViewPager) findViewById(R.id.vpPage);

        setUpViewPager();
        /*this.rvLista = (RecyclerView) findViewById(R.id.rvLista);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        this.rvLista.setLayoutManager(llm);
        iniciarLista();
        iniciarAdapter();*/

        if (tvToolbar != null) {
            setSupportActionBar(tvToolbar);
        }
    }

    private ArrayList<Fragment> agregarFraments() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());
        return fragments;
    }

    private void setUpViewPager() {
        vpPage.setAdapter(new PageAdaptor(getSupportFragmentManager(), agregarFraments()));
        tlTab.setupWithViewPager(vpPage);
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
