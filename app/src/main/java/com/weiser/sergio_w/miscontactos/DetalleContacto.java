package com.weiser.sergio_w.miscontactos;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DetalleContacto extends AppCompatActivity {

    private TextView tvNombre, tvTelefono, tvEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);
        Bundle bundle = getIntent().getExtras();
        String nombre = bundle.getString("Nombre");
        String telefono = bundle.getString("Telefono");
        String email = bundle.getString("Email");

        this.tvNombre = (TextView) findViewById(R.id.tvNombreContacto);
        this.tvTelefono = (TextView) findViewById(R.id.tvNumero);
        this.tvEmail = (TextView) findViewById(R.id.tvEmail);

        tvNombre.setText(nombre);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
    }

    public void llamar(View v) {
        String telefono = tvTelefono.getText().toString();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+telefono)));
    }

    public void sendMessage(View v) {
        String email = tvEmail.getText().toString();
        Intent intent = new Intent((Intent.ACTION_SEND));
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, email);
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Email "));
    }
}
