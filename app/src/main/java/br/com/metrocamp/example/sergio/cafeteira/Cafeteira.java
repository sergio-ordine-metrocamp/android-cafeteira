package br.com.metrocamp.example.sergio.cafeteira;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;

public class Cafeteira extends AppCompatActivity {

    private boolean on = false;

    private CoffeType type = CoffeType.SHORT;

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;

        setupLight(on);
        changeCoffeButtons(on);
        changeOrderButtonStatus(on);

    }

    public CoffeType getType() {
        return type;
    }

    public void setType(CoffeType type) {
        this.type = type;
        Log.d("COFFE","type is "+type);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafeteira);

        Switch switchOn = (Switch) findViewById(R.id.chaveLigar);

        setOn(false);
        switchOn.setChecked(false);

        switchOn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton,
                                         boolean enabled) {
                setOn(enabled);
            }
        });


        FloatingActionButton button = (FloatingActionButton) findViewById(R.id.btnCurto);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setType(CoffeType.SHORT);
            }
        });

        button = (FloatingActionButton) findViewById(R.id.btnMedio);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setType(CoffeType.MEDIUM);
            }
        });

        button = (FloatingActionButton) findViewById(R.id.btnLongo);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setType(CoffeType.LARGE);
            }
        });

        Button orderButton = (Button) findViewById(R.id.btnPedir);
        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cafeteira.this, Resultado.class);
                intent.putExtra("Type",getType());
                Cafeteira.this.startActivity(intent);
            }
        });

    }

    private void changeCoffeButtons(boolean enabled) {
        changeCoffeeButtonStatus( R.id.btnCurto, enabled);
        changeCoffeeButtonStatus( R.id.btnMedio, enabled);
        changeCoffeeButtonStatus( R.id.btnLongo, enabled);
    }

    private void changeOrderButtonStatus(boolean enabled) {
        Button orderButton = (Button) findViewById(R.id.btnPedir);
        orderButton.setEnabled(enabled);
        changeButtonColor(orderButton, enabled);
    }

    private void changeButtonColor(View view, boolean enabled) {
        int color = enabled ? R.color.frenteComponente : R.color.fundoComponente;
        view.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(color)));
    }

    private void changeCoffeeButtonStatus(int buttonId, boolean enabled) {
        FloatingActionButton button = (FloatingActionButton) findViewById(buttonId);
        button.setEnabled(enabled);

        changeButtonColor(button,enabled);
    }

    private void setupLight(boolean enabled) {
        int imageId = enabled ?  R.drawable.on : R.drawable.off;
        ImageView lightImage = (ImageView) findViewById(R.id.lightImage);
        lightImage.setImageDrawable(getResources().getDrawable(imageId));
    }



}
