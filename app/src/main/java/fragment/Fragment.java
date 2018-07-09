package fragment;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.example.liz.democalculator.R;

import java.text.DecimalFormat;

public class Fragment extends android.app.Fragment implements View.OnClickListener{

    private Button btnZero,btnOne,btnTwo,btnThree,btnFour,btnFive,btnSix,btnSeven,btnEight,btnNine;
    private Button btnClear,btnAdd,btnPercent,btnDivide,btnPlus,btnSub,btnMulti,btnResult,btnPoint;
    private TextView tvDisplay;
    private double number1;
    boolean plus,sub,multi,divide;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        onClickView();

    }
    private void initView() {
        btnZero     = getActivity().findViewById(R.id.btnZero);
        btnOne      = getActivity().findViewById(R.id.btnOne);
        btnTwo      = getActivity().findViewById(R.id.btnTwo);
        btnThree    = getActivity().findViewById(R.id.btnThree);
        btnFour     = getActivity().findViewById(R.id.btnFour);
        btnFive     = getActivity().findViewById(R.id.btnFive);
        btnSix      = getActivity().findViewById(R.id.btnSix);
        btnSeven    = getActivity().findViewById(R.id.btnSeven);
        btnEight    = getActivity().findViewById(R.id.btnEight);
        btnNine     = getActivity().findViewById(R.id.btnNine);

        btnClear    = getActivity().findViewById(R.id.btnClear);
        btnAdd      = getActivity().findViewById(R.id.btnAdd);
        btnPercent  = getActivity().findViewById(R.id.btnPercent);
        btnDivide   = getActivity().findViewById(R.id.btnDivide);
        btnMulti    = getActivity().findViewById(R.id.btnMulti);
        btnPlus     = getActivity().findViewById(R.id.btnPlus);
        btnSub      = getActivity().findViewById(R.id.btnSub);
        btnPoint    = getActivity().findViewById(R.id.btnPoint);
        btnResult   = getActivity().findViewById(R.id.btnResult);

        tvDisplay  =  getActivity().findViewById(R.id.tvDisplay);

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
                try{
                    double number2 = Double.parseDouble(tvDisplay.getText().toString());
                    if(plus){
                        tvDisplay.setText(df.format(number1 + number2));
                        plus = false;
                    }
                    if (sub){
                        tvDisplay.setText(df.format(number1 - number2));
                        sub=false;
                    }
                    if (multi){
                        tvDisplay.setText(df.format(number1* number2));
                        multi=false;
                    }
                    if (divide){
                        if (number2 == 0){
                            Toast.makeText(getActivity(), "error", Toast.LENGTH_SHORT).show();
                        }
                        tvDisplay.setText(df.format(number1/ number2));
                        divide=false;
                    }
                }catch (Exception e){
                    Toast.makeText(getActivity(), "Please choose second number", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    private void sharedPreferences() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MyShare", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor     = sharedPreferences.edit();
        editor.putString("result",tvDisplay.getText().toString());
        editor.apply();
    }
}