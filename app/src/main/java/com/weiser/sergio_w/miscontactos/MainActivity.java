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

    private ListView lvLista;
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

        tlTab.getTabAt(0).setIcon(R.drawable.ic_contacs);
        tlTab.getTabAt(1).setIcon(R.drawable.ic_profile);
    }
}
