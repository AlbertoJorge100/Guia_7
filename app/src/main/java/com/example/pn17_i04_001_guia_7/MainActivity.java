package com.example.pn17_i04_001_guia_7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static final int ID_JUGAR=1;
    public static final String MSJ_RESPUESTA="respuesta";
    private String NumGenerado;
    private String Puntaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView btnJugar=findViewById(R.id.btnJugar);
        TextView btnPuntaje=findViewById(R.id.btnPuntaje);
        TextView btnRespuesta=findViewById(R.id.btnRespuesta);
        TextView btnDatos=findViewById(R.id.btnDatos);

        btnJugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intn=new Intent(MainActivity.this,JugarActivity.class);
            intn.putExtra(MSJ_RESPUESTA,GenerarNumero());
            startActivityForResult(intn,ID_JUGAR);
            }
        });

        btnPuntaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             Intent intn=new Intent(MainActivity.this,PuntajeActivity.class);
             intn.putExtra(MSJ_RESPUESTA,Puntaje);
             startActivity(intn);
            }
        });

        btnRespuesta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intn=new Intent(MainActivity.this,RespuestaActivity.class);
            intn.putExtra(MSJ_RESPUESTA,NumGenerado);
            startActivity(intn);
            }
        });

        btnDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             startActivity(new Intent(MainActivity.this,DatosActivity.class));
            }
        });
    }
    private String GenerarNumero(){
        Random rand = new Random();
        NumGenerado = Integer.toString(rand.nextInt(50));
        return NumGenerado;
    }

    public void onSaveInstanceState(Bundle estado){
        super.onSaveInstanceState(estado);
        estado.putString("puntaje", this.Puntaje);
        estado.putString("numero", this.NumGenerado);
    }
    public void onRestoreInstanceState(Bundle estadoAnterior){
        super.onRestoreInstanceState(estadoAnterior);
        this.Puntaje=estadoAnterior.getString("puntaje");
        this.NumGenerado=estadoAnterior.getString("numero");
    }
    public void onActivityResult(int requestcode, int resultcode, Intent data){
        super.onActivityResult(requestcode,resultcode,data);
        this.Puntaje=data.getStringExtra(JugarActivity.TAG_PUNTAJE);
        if(Integer.parseInt(Puntaje)>0)
            GenerarNumero();
    }
}