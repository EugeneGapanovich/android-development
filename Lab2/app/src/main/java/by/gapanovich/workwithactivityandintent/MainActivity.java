package by.gapanovich.workwithactivityandintent;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tView = (TextView) findViewById(R.id.view_value);
        Button button = (Button) findViewById(R.id.button_open_form);
        EditText edText = (EditText) findViewById(R.id.enter_value);

        button.setOnClickListener((View v) -> {
            String value = ""; // contains value from EditText 'edText' field
            if (edText.getText().toString().equals("")) {
                value = "0";
            } else {
                value = edText.getText().toString();
            }
            int sendingValue = Integer.parseInt(tView.getText().toString()) + Integer.parseInt(value);
            Intent intentToSecondActivity = new Intent(MainActivity.this, SecondActivity.class);
            intentToSecondActivity.putExtra("message", Integer.toString(sendingValue));
            MainActivity.this.startActivityForResult(intentToSecondActivity, REQUEST_CODE);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                TextView tView = (TextView) findViewById(R.id.view_value);
                tView.setText(data.getStringExtra("result"));
            }
        }
    }

}