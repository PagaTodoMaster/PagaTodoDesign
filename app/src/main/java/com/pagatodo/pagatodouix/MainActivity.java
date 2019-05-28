package com.pagatodo.pagatodouix;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import com.pagatodo.pagatododesign.inputs.InputNormal;
import com.pagatodo.pagatododesign.progress.steps.StepBar;
import com.pagatodo.pagatododesign.spinners.SpinerYg;
import com.pagatodo.pagatododesign.spinners.SpinnerListener;
import com.pagatodo.pagatododesign.spinners.SpinnerYgAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private StepBar stepBar;
    private SpinerYg spinerYg;
    private List<String> list;
    private int positionSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((InputNormal) findViewById(R.id.inputNormal)).setText("voy");
        spinerYg = findViewById(R.id.spinner_yaganaste);
        list = new ArrayList<>();
        list.add("Lugar de Nacimiento");
        list.add("Priemero");
        list.add("Segundo");
        list.add("Tercero");
        positionSelect = 0;
        spinerYg.setListener(position ->{
                    Log.d("ELEMENTO",spinerYg.getSelectionItem(position).toString());
                    positionSelect = position;
        });
        SpinnerYgAdapter adapter = new SpinnerYgAdapter(list,this);
        spinerYg.setAdapter(adapter);
        spinerYg.showDropDown();
        findViewById(R.id.button2).setOnClickListener(this);
        /*stepBar = findViewById(R.id.step_bar);
        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        stepBar.jumpStep(5);*/

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                stepBar.backStep();
                break;
            case R.id.button2:
                //stepBar.nextStep();
                if (positionSelect == 0){
                    spinerYg.inError();
                }
                break;
        }
    }
}
