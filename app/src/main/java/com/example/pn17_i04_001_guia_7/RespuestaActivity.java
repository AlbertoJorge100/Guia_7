package com.example.pn17_i04_001_guia_7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class RespuestaActivity extends AppCompatActivity {
    private String Puntaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_respuesta);
        Puntaje=(String)getIntent().getSerializableExtra(MainActivity.MSJ_RESPUESTA);
        TextView lblPuntaje=findViewById(R.id.lblRespuesta);
        lblPuntaje.setText(Puntaje);
    }
    public void onSaveInstanceState(Bundle estado){
        super.onSaveInstanceState(estado);
        estado.putString("puntaje", this.Puntaje);
    }
    public void onRestoreInstanceState(Bundle estadoAnterior){
        super.onRestoreInstanceState(estadoAnterior);
        this.Puntaje=estadoAnterior.getString("puntaje");
    }
}