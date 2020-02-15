package com.example.program3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine, btnZero, btnSum, btnMultiply, btnSubstract, btnDivision, btnEqual, btnClear;
    EditText numValue;
    int valueOne, valueTwo, Result;
    String strResult;
    Boolean numSum = false, numSubs = false, numDivision = false, numMultiply = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnOne = findViewById(R.id.btnOne);
        btnTwo = findViewById(R.id.btnTwo);
        btnThree = findViewById(R.id.btnThree);
        btnFour = findViewById(R.id.btnFour);
        btnFive = findViewById(R.id.btnFive);
        btnSix = findViewById(R.id.btnSix);
        btnSeven = findViewById(R.id.btnSeven);
        btnEight = findViewById(R.id.btnEight);
        btnNine = findViewById(R.id.btnNine);
        btnZero = findViewById(R.id.btnZero);
        btnEqual = findViewById(R.id.btnEqual);
        btnClear = findViewById(R.id.btnClear);
        btnSum = findViewById(R.id.btnSum);
        btnSubstract = findViewById(R.id.btnSubstract);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivision = findViewById(R.id.btnDivision);
        numValue = findViewById(R.id.result);

        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numValue.setText(numValue.getText() + "1");
            }
        });

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numValue.setText(numValue.getText() + "2");
            }
        });

        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numValue.setText(numValue.getText() + "3");
            }
        });

        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numValue.setText(numValue.getText() + "4");
            }
        });

        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numValue.setText(numValue.getText() + "5");
            }
        });

        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numValue.setText(numValue.getText() + "6");
            }
        });

        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numValue.setText(numValue.getText() + "7");
            }
        });

        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numValue.setText(numValue.getText() + "8");
            }
        });

        btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numValue.setText(numValue.getText() + "9");
            }
        });

        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numValue.setText(numValue.getText() + "0");
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numValue.setText("");
            }
        });

        btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numValue == null) {
                    numValue.setText("");
                } else {
                    valueOne = Integer.parseInt(numValue.getText() + "");
                    System.out.println(valueOne);
                    numSum = true;
                    numValue.setText(null);
                }
            }
        });

        btnSubstract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numValue == null) {
                    numValue.setText("");
                } else {
                    valueOne = Integer.parseInt(numValue.getText() + "");
                    numSubs = true;
                    numValue.setText("");
                }
            }
        });

        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numValue == null) {
                    numValue.setText("");
                } else {
                    valueOne = Integer.parseInt(numValue.getText() + "");
                    numDivision = true;
                    numValue.setText("");
                }
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numValue == null) {
                    numValue.setText("");
                } else {
                    valueOne = Integer.parseInt(String.valueOf(numValue.getText()));
                    numMultiply = true;
                    numValue.setText("");
                }
            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueTwo = Integer.parseInt(String.valueOf(numValue.getText()));


                System.out.println(valueOne + valueTwo);
                if (numSum == true) {

                    Result = valueOne + valueTwo;
                    strResult = String.valueOf(Result);
                    numValue.setText(strResult);
                    numSum = false;
                }

                if (numSubs == true) {
                    Result = valueOne - valueTwo;
                    strResult = String.valueOf(Result);
                    numValue.setText(strResult);
                    numSubs = false;
                }

                if (numMultiply == true) {
                    Result = valueOne * valueTwo;
                    strResult = String.valueOf(Result);
                    numValue.setText(strResult);
                    numMultiply = false;
                }

                if (numDivision == true) {
                    Result = valueOne / valueTwo;
                    strResult = String.valueOf(Result);
                    numValue.setText(strResult);
                    numDivision = false;
                }
            }
        });
    }
}
