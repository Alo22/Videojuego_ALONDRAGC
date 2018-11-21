package com.example.alondra.dadm_u3_ejercicio7_alondragonzalezcruz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Lienzo(this));
    }
    public void abrir() {
        Intent s = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(s);
    }
}
