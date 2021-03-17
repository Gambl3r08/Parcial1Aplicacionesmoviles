package com.example.parcial1robertolozada;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private EditText textoEntrada;
    private Button agregaTexto;
    private TextView textoResultado;
    private Button botonCalcular;
    private Button botonBorrar;
    private RadioGroup grupoBotones;
    private RadioButton radioOrdenar;
    private RadioButton radioPromedio;
    private RadioButton radioMenor;
    private RadioButton radioMayor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Coleccion coleccion = new Coleccion();
        setContentView(R.layout.activity_main);

        textoEntrada = (EditText) findViewById(R.id.txtEntrada);
        textoResultado = (TextView) findViewById(R.id.txtResultado);
        agregaTexto = (Button) findViewById(R.id.botonAgregar);
        botonCalcular = (Button) findViewById(R.id.BotonCalcular);
        botonBorrar = (Button) findViewById(R.id.BotonBorrar);
        grupoBotones = (RadioGroup) findViewById(R.id.grupoRadio);
        radioOrdenar = (RadioButton)findViewById(R.id.OrdenarVector);
        radioPromedio = (RadioButton)findViewById(R.id.PromedioVector);
        radioMenor = (RadioButton)findViewById(R.id.ValorMenor);
        radioMayor = (RadioButton)findViewById(R.id.ValorMayor);

        agregaTexto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dato = null;
                dato = textoEntrada.getEditableText().toString();

                if (dato.isEmpty()){
                    textoEntrada.setText("No puede estar vacio, intente de nuevo");

                } else{
                    coleccion.AgregarDato(dato);
                    textoResultado.setText(coleccion.GetDatos());
                }

            }
        });

       botonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(radioPromedio.isChecked()){
                    float Promedio = coleccion.getPromedio();
                    String PromedioTotal = "Promedio: " + Promedio;
                    textoResultado.setText(PromedioTotal);
                } else if(radioOrdenar.isChecked()){
                    coleccion.OrdenarArreglo();
                    textoResultado.setText(coleccion.GetDatos());
                } else if(radioMenor.isChecked()){
                    String Menor = coleccion.getDatoMenor();
                    textoResultado.setText(Menor);
                } else if(radioMayor.isChecked()){
                    String Mayor = coleccion.getDatoMayor();
                    textoResultado.setText(Mayor);
                }

            }
        });



        botonBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Borrar = textoEntrada.getEditableText().toString();
                coleccion.BorrarDatos(Borrar);
                textoResultado.setText(coleccion.GetDatos());
            }
        });



    }

}