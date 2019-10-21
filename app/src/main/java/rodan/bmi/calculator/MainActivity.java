package rodan.bmi.calculator;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onButtonClick (View v){
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);

        EditText efeets = findViewById(R.id.editTextFeets);
        EditText einchs = findViewById(R.id.editTextInches);
        EditText eweight = findViewById(R.id.editTextWeight);
        TextView t1 = findViewById(R.id.textView);
        TextView t2 = findViewById(R.id.textView3);
        String sfeets = efeets.getText().toString();
        String sinches = einchs.getText().toString();
        String sweight = eweight.getText().toString();
        if (sfeets.equals("")||sinches.equals("")||sweight.equals("")){
            Toast.makeText(this,"Plz Don't Leave any fields Blank",Toast.LENGTH_LONG).show();
        }
        else{
        double feets = Double.parseDouble(efeets.getText().toString());
        double inches = Double.parseDouble(einchs.getText().toString());
        double weight = Double.parseDouble(eweight.getText().toString());
        double height = (feets*12*2.54)+ inches*2.54;
        height = height/100;
        double BMI = (weight)/(height*height);
        DecimalFormat df = new DecimalFormat("#.##");//Making format of x.yz
        BMI =Double.parseDouble(df.format(BMI));//Converting String to double using parseDouble from class Double

        t1.setText("Your BMI is "+Double.toString(BMI));
        if(BMI>25){
            t2.setText("You are an Obese");
        }
        else if(BMI<18.5){
            t2.setText("You are Under Nutritioned");
        }
        else{
            t2.setText("You are Healthy");
        }}
    }
}
