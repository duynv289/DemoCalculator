package com.example.liz.democalculator;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import fragment.Fragment;


public class CalculatorActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.mnSetting :
                break;
            case R.id.mnHistory :
                SharedPreferences PREF_Result = getSharedPreferences("MyShare",MODE_PRIVATE);
                String SPresult = PREF_Result.getString("result","123");
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

}

