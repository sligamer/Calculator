package com.lab2_4.sligamer.calculator;

/**
 * Created by Justin Freres on 2/2/2018.
 */

public class SimpleExpression {

    // DECLARE PRIVATE VARIABLES
    private Integer mOperator1;
    private Integer mOperator2;
    private String mOperator;
    private Integer mValue;

    // DEFAULT CONSTRUCTOR
    public SimpleExpression()
    {
        mOperator1 = 0;
        mOperator2 = 0;
        mOperator = "+";
        mValue = 0;
    }

    public void setOperator1(int v)
    {
        mOperator1 = v;
    }

    public  int getOperator1()
    {
        return  mOperator1;
    }

    public  void  setOperator2(int v)
    {
        mOperator2 = v;
    }

    public  int getOperator2()
    {
        return  mOperator2;
    }

    public void setOperator(String s)
    {
        mOperator = s;
    }

    public  String getOperator()
    {
        return  mOperator;
    }

    public Integer getValue()
    {
        computeValue();
        return  mValue;
    }

    // Clear the operands within the expression
    public void clearOperands()
    {
        mOperator1 = 0;
        mOperator2 = 0;
    }

    // Compute the integer value of the expression
    private void computeValue() {
        mValue = 0;
        if(mOperator.contentEquals("+")){
            mValue = mOperator1 + mOperator2;
        }else if(mOperator.contentEquals("-")){
            mValue = mOperator1 - mOperator2;
        }else if(mOperator.contentEquals("x")){
            mValue = mOperator1 * mOperator2;
        }else if(mOperator.contentEquals("/") && mOperator2 !=0){
            mValue = mOperator1 / mOperator2;
        }else{
            mValue = mOperator1 % mOperator2;
        }

    }

}
