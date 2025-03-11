package week.eight;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    private EditText inputFirstNumber, inputSecondNumber;
    private Button buttonPlus, buttonMinus, buttonMultiply, buttonDivide;
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        inputFirstNumber = findViewById(R.id.inputFirstNumber);
        inputSecondNumber = findViewById(R.id.inputSecondNumber);

        buttonPlus = findViewById(R.id.buttonPlus);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonDivide = findViewById(R.id.buttonDivide);

        textResult = findViewById(R.id.textResult);


        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult('+');
            }
        });

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult('-');
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult('*');
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult('/');
            }
        });
    }

    private void calculateResult(char operation) {
        String firstNumStr = inputFirstNumber.getText().toString();
        String secondNumStr = inputSecondNumber.getText().toString();


        if (firstNumStr.isEmpty() || secondNumStr.isEmpty()) {
            textResult.setText("Enter both numbers");
            return;
        }

        try {
            double firstNum = Double.parseDouble(firstNumStr);
            double secondNum = Double.parseDouble(secondNumStr);
            double result = 0;

            switch (operation) {
                case '+':
                    result = firstNum + secondNum;
                    break;
                case '-':
                    result = firstNum - secondNum;
                    break;
                case '*':
                    result = firstNum * secondNum;
                    break;
                case '/':
                    if (secondNum == 0) {
                        textResult.setText("Cannot divide by zero");
                        return;
                    }
                    result = firstNum / secondNum;
                    break;
            }

            if (result == Math.floor(result)) {
                textResult.setText(String.valueOf((int)result));
            } else {
                textResult.setText(String.valueOf(result));
            }

        } catch (NumberFormatException e) {
            textResult.setText("Invalid number format");
        }
    }
}