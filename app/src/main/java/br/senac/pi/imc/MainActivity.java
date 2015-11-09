package br.senac.pi.imc;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        findViewById(R.id.btnresolver).setOnClickListener(imc());
    }
    //Peso / altura²
    //18.5 abaixo dopeso
    //18.6 a 24.9 peso ideal
    //25.0 a 29.9 peso levemente acima do peso
    //30.0 a 34.9 Obesidade grau 1
    //35.0 a 39.0 Obesidade grau 2
    //acima do40 Obesidade 3 (imorbida).

private View.OnClickListener imc() {
    return new View.OnClickListener() {
        public void onClick(View v) {

            EditText peso = (EditText) findViewById(R.id.peso);
            EditText altura = (EditText) findViewById(R.id.altura);
            double pes = Double.parseDouble(peso.getText().toString());
            double alt = Double.parseDouble(altura.getText().toString());
            double total = pes/(alt * alt);
            TextView txtResultado = (TextView) findViewById(R.id.txtResultado);
            //txtResultado.setText(getString(R.string.Resultado) + "" +imc().toString());

            //Toast.makeText(getApplicationContext()"abaixo do peso", Toast.LENGTH_SHORT).show();{

            if (total <= 18.5) {
                txtResultado.setText(getString(R.string.peso1).toString());
            } else if (total <= 24.9) {
                txtResultado.setText(getString(R.string.peso2).toString());
            } else if ((total >= 25.0) && (total <= 29.9)) {
                txtResultado.setText(getString(R.string.peso3).toString());
            } else if ((total >= 30.0) && (total <= 34.9)) {
                txtResultado.setText(getString(R.string.peso4).toString());
            } else if ((total >= 35.0) && (total <= 39.0)) {
                txtResultado.setText(getString(R.string.peso5).toString());
            } else if (total >= 40) {
                txtResultado.setText(getString(R.string.peso6).toString());
                //Toast.makeText(getApplicationContext()"Você estar com a média do peso", Toast.LENGTH_SHORT).show();{
            }
        }
    };
}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
