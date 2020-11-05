package by.gapanovich.workwithactivityandintent;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intentFromMainActivity = getIntent();
        TextView tView = (TextView) findViewById(R.id.view_value);
        tView.setText(intentFromMainActivity.getStringExtra("message"));

        Button button = (Button) findViewById(R.id.button_open_form);
        button.setOnClickListener((View.OnClickListener) v -> {
            EditText edText = (EditText) findViewById(R.id.enter_value);
            String value = ""; // contains value from EditText 'edText' field
            if (edText.getText().toString().equals("")) {
                value = "0";
            } else {
                value = edText.getText().toString();
            }
            int sendingValue = Integer.parseInt(tView.getText().toString()) + Integer.parseInt(value);
            Intent intentToMainActivity = new Intent(SecondActivity.this, MainActivity.class);
            intentToMainActivity.putExtra("result", Integer.toString(sendingValue));
            setResult(Activity.RESULT_OK, intentToMainActivity);
            finish();
        });
    }
}