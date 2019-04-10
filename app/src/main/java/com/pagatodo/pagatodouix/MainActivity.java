package com.pagatodo.pagatodouix;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.pagatodo.pagatododesign.progress.steps.StepBar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private StepBar stepBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                stepBar.nextStep();
                break;
        }
    }
}
