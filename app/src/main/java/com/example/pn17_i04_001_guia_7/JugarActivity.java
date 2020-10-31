package com.example.pn17_i04_001_guia_7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class JugarActivity extends AppCompatActivity {
    private int Puntaje=10;
    private String Numero;
    public static final String TAG_PUNTAJE="puntaje";
    private TextView lblPuntaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugar);
        final TextView txbNumero=findViewById(R.id.txbNumero);
        lblPuntaje=findViewById(R.id.lblPuntaje);
        TextView btnProbar=findViewById(R.id.btnProbar);

        Numero=(String)getIntent().getSerializableExtra(MainActivity.MSJ_RESPUESTA);
        Toast.makeText(JugarActivity.this,Numero,Toast.LENGTH_SHORT).show();
        btnProbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num=txbNumero.getText().toString();
                if(!num.equals("")){
                    if(num.equals(Numero)){
                        Puntaje+=10;
                        Toast.makeText(JugarActivity.this,"Felicidades Acertastes !",Toast.LENGTH_SHORT).show();
                        try {
                            Retorno();
                        }catch (Exception e){
                            Toast.makeText(JugarActivity.this,"Excepcion: " + e.toString(),Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        int aux=Integer.parseInt(Numero);
                        int aux2=Integer.parseInt(num);
                        if(aux2 > aux){
                            Toast.makeText(JugarActivity.this,"El numero ingresado es mayor al generado por el sistema :( !",Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(JugarActivity.this,"El numero ingresado es menor al generado por el sistema :( !",Toast.LENGTH_SHORT).show();
                        }
                        Puntaje-=1;
                    }
                    lblPuntaje.setText(Integer.toString(Puntaje));
                }else{
                    txbNumero.setError("Debe ingresar un numero !");
                }
            }
        });


    }

    private void Retorno() throws  Exception{
        Thread.sleep(1000);
        Intent intn=new Intent();
        intn.putExtra(TAG_PUNTAJE,Integer.toString(Puntaje));
        setResult(MainActivity.ID_JUGAR,intn);
        finish();
    }


    public void onSaveInstanceState(Bundle estado){
        super.onSaveInstanceState(estado);
        estado.putInt("puntaje", this.Puntaje);
        estado.putString("numero", this.Numero);
    }
    public void onRestoreInstanceState(Bundle estadoAnterior){
        super.onRestoreInstanceState(estadoAnterior);
        this.Puntaje=estadoAnterior.getInt("puntaje");
        this.Numero=estadoAnterior.getString("numero");
        lblPuntaje.setText(Integer.toString(Puntaje));
    }
}