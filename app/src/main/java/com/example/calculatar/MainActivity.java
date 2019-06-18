package com.example.calculatar;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button0, button1,button2, button3, button4, button5, button6,button7, button8, button9;
    Button buttonDot, buttonEquals, buttonDelete, buttonMultiply,buttonDivide, buttonPlus,buttonSubstract;
    TextView result;
    String currentNumber;
    String firstNumber;
    Operand currentOperand;

    enum Operand {
        ADD, DIVIDE, MULTIPLY, SUBSTRACT, NONE
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVars();
        initListeners();



    }
    void initVars() {
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonDot= findViewById(R.id.buttonDot);
        buttonEquals= findViewById(R.id.buttonEquals);
        buttonDelete= findViewById(R.id.buttonDelete);
        buttonMultiply= findViewById(R.id.buttonMultiply);
        buttonDivide= findViewById(R.id.buttonDivide);
        buttonPlus= findViewById(R.id.buttonPlus);
        buttonSubstract= findViewById(R.id.buttonSubtract);
        result = findViewById(R.id.result);
        currentNumber = "0";
    }

    void initListeners() {
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendNumber(0);

            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendNumber(1);

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendNumber(2);

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendNumber(3);

            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendNumber(4);

            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendNumber(5);

            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendNumber(6);

            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendNumber(7);

            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendNumber(8);

            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendNumber(9);

            }
        });


        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                useOperand(Operand.ADD);

            }
        });

        buttonSubstract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                useOperand(Operand.SUBSTRACT);

            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                useOperand(Operand.MULTIPLY);

            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                useOperand(Operand.DIVIDE);

            }
        });

        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendDecimal();

            }
        });

        buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();

            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();

            }
        });



    }
    void appendDecimal() {
        if (!currentNumber.contains(".") && currentNumber.length() > 0) {
            currentNumber += ".";
        }
        updateResult();
    }
    void updateResult() {
        float currentNumberFloat = Float.parseFloat(currentNumber);
        if (currentNumberFloat < 0) {
            result.setTextColor(Color.parseColor("#f45942"));
        }else {
            result.setTextColor(Color.BLACK);
        }



        result.setText(currentNumber);

    }

    void appendNumber(int number) {
        if (currentNumber.equals("0")) {
            currentNumber = String.valueOf(number);
        }else {
            currentNumber += String.valueOf(number);
        }
        updateResult();
    }


    void clear() {
        currentNumber = "0";
        updateResult();
    }

    void useOperand(Operand operand) {
        currentOperand = operand;
        firstNumber = currentNumber;
        currentNumber = "0";
        updateResult();
    }

    void calculate() {
        float numberOne = Float.parseFloat(firstNumber);
        float numberTwo = Float.parseFloat(currentNumber);
        float result = 0;
        switch (currentOperand) {
            case ADD:
                result = numberOne + numberTwo;
                break;

            case SUBSTRACT:
                result = numberOne - numberTwo;
                break;
            case MULTIPLY:
                result = numberOne * numberTwo;
                break;
            case DIVIDE:
                result = numberOne / numberTwo;
                break;
        }
        currentNumber = String.valueOf(result);

        if (Math.floor(result) == result) {
            currentNumber = currentNumber.substring(0, currentNumber.length() - 2);
        }

        updateResult();
    }



}
