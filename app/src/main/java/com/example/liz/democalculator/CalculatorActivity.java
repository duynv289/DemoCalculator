package com.example.liz.democalculator;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;


public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnZero,btnOne,btnTwo,btnThree,btnFour,btnFive,btnSix,btnSeven,btnEight,btnNine;
    private Button btnClear,btnAdd,btnPercent,btnDivide,btnPlus,btnSub,btnMulti,btnResult,btnPoint;
    private TextView tvDisplay;
    private double number1;
    boolean plus,sub,multi,divide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        initView();
        onClickView();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.mnSetting :
            break;
            case R.id.mnHistory :
                SharedPreferences sharedPreferences = getSharedPreferences("MyShare",MODE_PRIVATE);
                String SPresult = sharedPreferences.getString("result","123");
                Toast.makeText(this, SPresult+"", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mnExit :
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }


    private void initView() {
        btnZero     = findViewById(R.id.btnZero);
        btnOne      = findViewById(R.id.btnOne);
        btnTwo      = findViewById(R.id.btnTwo);
        btnThree    = findViewById(R.id.btnThree);
        btnFour     = findViewById(R.id.btnFour);
        btnFive     = findViewById(R.id.btnFive);
        btnSix      = findViewById(R.id.btnSix);
        btnSeven    = findViewById(R.id.btnSeven);
        btnEight    = findViewById(R.id.btnEight);
        btnNine     = findViewById(R.id.btnNine);

        btnClear    = findViewById(R.id.btnClear);
        btnAdd      = findViewById(R.id.btnAdd);
        btnPercent  = findViewById(R.id.btnPercent);
        btnDivide   = findViewById(R.id.btnDivide);
        btnMulti    = findViewById(R.id.btnMulti);
        btnPlus     = findViewById(R.id.btnPlus);
        btnSub      = findViewById(R.id.btnSub);
        btnPoint    = findViewById(R.id.btnPoint);
        btnResult   = findViewById(R.id.btnResult);

        tvDisplay  =  findViewById(R.id.tvDisplay);

    }
    public void onClickView(){
        btnZero.setOnClickListener(this);
        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnFour.setOnClickListener(this);
        btnFive.setOnClickListener(this);
        btnSix.setOnClickListener(this);
        btnSeven.setOnClickListener(this);
        btnEight.setOnClickListener(this);
        btnNine.setOnClickListener(this);

        btnPlus.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnDivide.setOnClickListener(this);
        btnMulti.setOnClickListener(this);

        btnPoint.setOnClickListener(this);
        btnPercent.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnResult.setOnClickListener(this);
    }
    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnZero :
                tvDisplay.append("0");
                break;
            case R.id.btnOne :
                tvDisplay.append("1");
                break;
            case R.id.btnTwo :
                tvDisplay.append("2");
                break;
            case R.id.btnThree :
                tvDisplay.append("3");
                break;
            case R.id.btnFour :
                tvDisplay.append("4");
                break;
            case R.id.btnFive :
                tvDisplay.append("5");
                break;
            case R.id.btnSix :
                tvDisplay.append("6");
                break;
            case R.id.btnSeven :
                tvDisplay.append("7");
                break;
            case R.id.btnEight :
                tvDisplay.append("8");
                break;
            case R.id.btnNine :
                tvDisplay.append("9");
                break;

            case R.id.btnSub :
                number1 = Double.parseDouble(tvDisplay.getText().toString());
                tvDisplay.append("-");
                sub = true;
                tvDisplay.setText(null);
                break;
            case R.id.btnPlus :
                number1 = Double.parseDouble(tvDisplay.getText().toString());
                tvDisplay.append("+");
                plus = true;
                tvDisplay.setText(null);
                break;
            case R.id.btnMulti :
                number1 = Double.parseDouble(tvDisplay.getText().toString());
                tvDisplay.append("*");
                multi = true;
                tvDisplay.setText(null);
                break;
            case R.id.btnDivide :
                number1 = Double.parseDouble(tvDisplay.getText().toString());
                tvDisplay.append("/");
                divide = true;
                tvDisplay.setText(null);
                break;

            case R.id.btnPoint :
                tvDisplay.append(".");
                break;
            case R.id.btnPercent :
                double result = Double.parseDouble(tvDisplay.getText().toString());
                tvDisplay.setText(result*100+"%");
                break;
            case R.id.btnAdd :
                result = Double.parseDouble(tvDisplay.getText().toString());
                tvDisplay.setText(String.valueOf(-result));
                break;
            case R.id.btnClear :
                tvDisplay.setText("");
                break;
            case R.id.btnResult :
                sharedPreferences();
                DecimalFormat df = new DecimalFormat("0.000");
                double number2 = Double.parseDouble(tvDisplay.getText().toString());
                if(plus){
                    tvDisplay.setText(df.format(number1 + number2));
                }
                if (sub){
                    tvDisplay.setText(df.format(number1 - number2));
                }
                if (multi){
                    tvDisplay.setText(df.format(number1* number2));
                }
                if (divide){
                    if (number2 == 0){
                        Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
                    }
                    tvDisplay.setText(df.format(number1/ number2));
                }
                break;
        }
    }

    private void sharedPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences("MyShare",MODE_PRIVATE);
        SharedPreferences.Editor editor     = sharedPreferences.edit();
        editor.putString("result",tvDisplay.getText().toString());
        editor.commit();
    }
}

