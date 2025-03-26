package com.example.sit703_task21p_unitconverter;


import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText inputValue;
    private Spinner fromUnit, toUnit;
    private Button convertButton;
    private TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        inputValue = findViewById(R.id.inputValue);
        fromUnit = findViewById(R.id.fromUnit);
        toUnit = findViewById(R.id.toUnit);
        convertButton = findViewById(R.id.convertButton);
        resultView = findViewById(R.id.resultView);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.units_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fromUnit.setAdapter(adapter);
        toUnit.setAdapter(adapter);

        // Convert button click listener
        convertButton.setOnClickListener(view -> performConversion());
    }

    private void performConversion() {
        String inputText = inputValue.getText().toString().trim();
        String from = fromUnit.getSelectedItem().toString();
        String to = toUnit.getSelectedItem().toString();

        if (inputText.isEmpty()) {
            Toast.makeText(MainActivity.this, "Please enter a value", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double value = Double.parseDouble(inputText);
            double result = ConversionUtils.convert(from, to, value);
            resultView.setText(String.format("Converted Value: %.2f", result));
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "Invalid conversion", Toast.LENGTH_SHORT).show();
        }
    }
}
