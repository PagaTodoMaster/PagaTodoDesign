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

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SpinnerListener{

    private StepBar stepBar;
    private SpinerYg spinerYg;
    private SpinerYg spinerYgb;
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((InputNormal) findViewById(R.id.inputNormal)).setText("voy");
        spinerYg = findViewById(R.id.spinner_yaganaste);
        spinerYgb = findViewById(R.id.spinner_yg_dos);
        list = new ArrayList<>();
        list.add("Lugar de Nacimiento");
        list.add("Priemero");
        list.add("Segundo");
        list.add("Tercero");
        SpinnerYgAdapter adapter = new SpinnerYgAdapter(list,this);
        spinerYg.setAdapter(adapter);
        spinerYg.showDropDown(true);
        spinerYgb.setAdapter(adapter);
        spinerYg.setListener(this);
        spinerYgb.setListener(this);
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
                String selection = (String) spinerYg.getSelectionItem();
                if (selection.equalsIgnoreCase("Segundo")){
                    spinerYg.inError();
                }
                break;
        }
    }

    @Override
    public void onItemSelected(View view, int position) {
        if (view.getId() == R.id.spinner_yaganaste){
                Log.d("ELEMENTO",((String) spinerYg.getSelectionItem()));
        } else if (view.getId() == R.id.spinner_yg_dos){

        }
    }

    @Override
    public void setOnClickListener(View view) {
        if (view.getId() == R.id.spinner_yaganaste){
            spinerYg.inActive();
            spinerYgb.inNormal();
            spinerYg.showDropDown(false);
        } else if (view.getId() == R.id.spinner_yg_dos){
            spinerYgb.inActive();
            spinerYg.inNormal();
            spinerYgb.showDropDown(false);
        }
    }

    @Override
    public void setOnClickListenerArrow(View view) {
        if (view.getId() == R.id.spinner_yaganaste){
            spinerYg.showDropDown(false);
            spinerYgb.inNormal();
        } else if (view.getId() == R.id.spinner_yg_dos){
            spinerYgb.showDropDown(false);
            spinerYg.inNormal();
        }
    }

    @Override
    public void setOnTouchListener(View view) {
        if (view.getId() == R.id.spinner_yaganaste){
            spinerYg.inActive();
            spinerYgb.inNormal();
        } else if (view.getId() == R.id.spinner_yg_dos){
            spinerYgb.inActive();
            spinerYg.inNormal();
        }
    }
}
