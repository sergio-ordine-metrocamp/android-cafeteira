package br.com.metrocamp.example.sergio.cafeteira;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        Intent intent = getIntent();
        CoffeType type = (CoffeType) intent.getSerializableExtra("Type");

        String coffeName = "";

        switch (type) {
            case SHORT:
                //coffeName = "Curto";
                coffeName =  getString(R.string.curto);
                break;
            case MEDIUM:
                //coffeName = "Médio";
                coffeName =  getString(R.string.medio);
                break;
            case LARGE:
               // coffeName = "Longo";
                coffeName =  getString(R.string.longo);
                break;
        }

        TextView text = (TextView) findViewById(R.id.tipoCafe);
        text.setText(coffeName);

    }
}
