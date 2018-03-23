package com.lab2_4.sligamer.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // DECLARE PRIVATE VARIABLES
    private TextView mNumberDisplay;
    private  SimpleExpression mExpression;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        mNumberDisplay = (TextView) findViewById(R.id.textView);

        mExpression = new SimpleExpression();
    }

    public void goAC(View view) {
        mExpression.clearOperands();
        mNumberDisplay.setText("0");
    }

    public void goOperator(View view) {
        String operator = (String) view.getContentDescription();
        try {
            String val = (String) mNumberDisplay.getText();
            mExpression.setOperator1((int) Integer.parseInt(val.toString()));
        }
        catch (NumberFormatException e)
        {
            mExpression.setOperator1(0);
        }
        mNumberDisplay.setText("0");
        mExpression.setOperator(operator);
    }

    public void goOperand(View view) {
        String val = (String) mNumberDisplay.getText();
        String digit = (String) view.getContentDescription();
        if(val.charAt(0) == '0')
            mNumberDisplay.setText(digit);
        else
            mNumberDisplay.setText((String) mNumberDisplay.getText() + digit.charAt(0));
    }

    public void goCompute(View view) {
        try {
            String val = (String) mNumberDisplay.getText();
            mExpression.setOperator2((int) Integer.parseInt(val.toString()));
        }catch (NumberFormatException e) {
            mExpression.setOperator2(0);
        }
        mNumberDisplay.setText(mExpression.getValue().toString());

    }

    @Override
    public  boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        if(id == R.id.action_settings)
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
