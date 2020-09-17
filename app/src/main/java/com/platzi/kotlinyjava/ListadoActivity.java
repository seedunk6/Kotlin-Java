package com.platzi.kotlinyjava;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        RecyclerView rcListado = (RecyclerView) findViewById(R.id.rcListado);

        TextView textView = (TextView) findViewById(R.id.txtListadoUser);

        if(getIntent() != null){
            Bundle bundle = getIntent().getExtras();
            assert bundle != null;
            String nombre = bundle.getString("usuario", "");
            textView.setText("Bienvenido "+nombre);
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        rcListado.setLayoutManager(linearLayoutManager);

        rcListado.setAdapter(new AdapterListado(getFakeData()));
    }

    private List<PojoBasico> getFakeData() {
        List<PojoBasico> pojoBasicos = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            pojoBasicos.add(new PojoBasico("Titulo " + i, "Desc " + i));
        }
        return pojoBasicos;
    }
}
