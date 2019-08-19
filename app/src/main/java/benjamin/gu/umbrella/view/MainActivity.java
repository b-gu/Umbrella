package benjamin.gu.umbrella.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import benjamin.gu.umbrella.R;
import benjamin.gu.umbrella.model.WeatherPojo;

public class MainActivity extends AppCompatActivity {

    EditText zipCode;
    RadioButton fahrenheit;
    RadioButton celsius;
    RadioButton kelvin;
    Button saveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        zipCode = findViewById(R.id.zipCode);
        fahrenheit = findViewById(R.id.btn_fahrenheit);
        celsius = findViewById(R.id.btn_celsius);
        kelvin = findViewById(R.id.btn_kelvin);
        saveBtn = findViewById(R.id.save_settings);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String zip = zipCode.getText().toString();
                String unitType = "";
                if(celsius.isChecked()){
                    unitType = celsius.getText().toString();
                }
                else if(fahrenheit.isChecked()){
                    unitType = fahrenheit.getText().toString();
                }
                if (kelvin.isChecked()){
                    unitType =kelvin.getText().toString();
                }
                Intent intent = new Intent(MainActivity.this, WeatherDisplay.class);
                intent.putExtra("zipcode", zip);
                intent.putExtra("tempType", unitType);
                startActivity(intent);
            }
        });
    }



}
