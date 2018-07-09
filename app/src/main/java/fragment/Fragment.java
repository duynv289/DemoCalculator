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

    private Button button_0, button_1, button_2, button_3, button_4, button_5, button_6, button_7, button_8, button_9;
    private Button button_clear, button_inveser, button_percent, button_divide, button_plus, button_subtract, button_multiply, button_result, button_point;
    private TextView text_result;
    private double number1;
    boolean plus, subtract, multiply,divide;
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
        button_0 = getActivity().findViewById(R.id.button_0);
        button_1 = getActivity().findViewById(R.id.button_1);
        button_2 = getActivity().findViewById(R.id.button_2);
        button_3 = getActivity().findViewById(R.id.button_3);
        button_4 = getActivity().findViewById(R.id.button_4);
        button_5 = getActivity().findViewById(R.id.button_5);
        button_6 = getActivity().findViewById(R.id.button_6);
        button_7 = getActivity().findViewById(R.id.button_7);
        button_8 = getActivity().findViewById(R.id.button_8);
        button_9 = getActivity().findViewById(R.id.button_9);

        button_clear = getActivity().findViewById(R.id.button_clear);
        button_inveser = getActivity().findViewById(R.id.button_insever);
        button_percent = getActivity().findViewById(R.id.button_percent);
        button_point = getActivity().findViewById(R.id.button_point);
        button_result = getActivity().findViewById(R.id.button_result);

        button_divide = getActivity().findViewById(R.id.button_divide);
        button_multiply = getActivity().findViewById(R.id.button_multiply);
        button_plus = getActivity().findViewById(R.id.button_plus);
        button_subtract = getActivity().findViewById(R.id.button_subtract);

        text_result =  getActivity().findViewById(R.id.text_result);

    }
    public void onClickView(){
        button_0.setOnClickListener(this);
        button_1.setOnClickListener(this);
        button_2.setOnClickListener(this);
        button_3.setOnClickListener(this);
        button_4.setOnClickListener(this);
        button_5.setOnClickListener(this);
        button_6.setOnClickListener(this);
        button_7.setOnClickListener(this);
        button_8.setOnClickListener(this);
        button_9.setOnClickListener(this);

        button_plus.setOnClickListener(this);
        button_subtract.setOnClickListener(this);
        button_divide.setOnClickListener(this);
        button_multiply.setOnClickListener(this);

        button_point.setOnClickListener(this);
        button_percent.setOnClickListener(this);
        button_clear.setOnClickListener(this);
        button_inveser.setOnClickListener(this);
        button_result.setOnClickListener(this);
    }
    @SuppressLint("SetTextI18n")
    public void onClick(View view) throws NumberFormatException{
        switch (view.getId()){
            case R.id.button_0:
                text_result.append("0");
                break;
            case R.id.button_1:
                text_result.append("1");
                break;
            case R.id.button_2:
                text_result.append("2");
                break;
            case R.id.button_3:
                text_result.append("3");
                break;
            case R.id.button_4:
                text_result.append("4");
                break;
            case R.id.button_5:
                text_result.append("5");
                break;
            case R.id.button_6:
                text_result.append("6");
                break;
            case R.id.button_7:
                text_result.append("7");
                break;
            case R.id.button_8:
                text_result.append("8");
                break;
            case R.id.button_9:
                text_result.append("9");
                break;

            case R.id.button_subtract:
                number1 = Double.parseDouble(text_result.getText().toString());
                text_result.append("-");
                subtract = true;
                text_result.setText(null);
                break;
            case R.id.button_plus:
                number1 = Double.parseDouble(text_result.getText().toString());
                text_result.append("+");
                plus = true;
                text_result.setText(null);
                break;
            case R.id.button_multiply:
                number1 = Double.parseDouble(text_result.getText().toString());
                text_result.append("*");
                multiply = true;
                text_result.setText(null);
                break;
            case R.id.button_divide:
                number1 = Double.parseDouble(text_result.getText().toString());
                text_result.append("/");
                divide = true;
                text_result.setText(null);
                break;

            case R.id.button_point:
                text_result.append(".");
                break;
            case R.id.button_percent:
                double result = Double.parseDouble(text_result.getText().toString());
                text_result.setText(result*100+"%");
                break;
            case R.id.button_insever:
                result = Double.parseDouble(text_result.getText().toString());
                text_result.setText(String.valueOf(-result));
                break;
            case R.id.button_clear:
                text_result.setText("");
                break;
            case R.id.button_result:
                sharedPreferences();
                DecimalFormat df = new DecimalFormat("0.000");
                try{
                    double number2 = Double.parseDouble(text_result.getText().toString());
                    if(plus){
                        text_result.setText(df.format(number1 + number2));
                        plus = false;
                    }
                    if (subtract){
                        text_result.setText(df.format(number1 - number2));
                        subtract =false;
                    }
                    if (multiply){
                        text_result.setText(df.format(number1* number2));
                        multiply =false;
                    }
                    if (divide){
                        if (number2 == 0){
                            Toast.makeText(getActivity(), "error", Toast.LENGTH_SHORT).show();
                        }
                        text_result.setText(df.format(number1/ number2));
                        divide=false;
                    }
                }catch (Exception e){
                    Toast.makeText(getActivity(), "Please choose second number", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    private void sharedPreferences() {
        SharedPreferences PREF_Result = getActivity().getSharedPreferences("MyShare", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor     = PREF_Result.edit();
        editor.putString("result", text_result.getText().toString());
        editor.apply();
    }
}