package by.gapanovich.workwithactivityandintent;

import androidx.appcompat.app.AppCompatActivity;

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
        setContentView(R.layout.activity_second);

        Button button = (Button) findViewById(R.id.sa_button_open_form1);
        TextView textView = (TextView) findViewById(R.id.sa_view_text);
        EditText edText = (EditText) findViewById(R.id.sa_enter_value);

        Intent intentFromMainActivity = getIntent();
        textView.setText(intentFromMainActivity.getStringExtra("message"));


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = ""; // contains value from EditText 'edText' field
                if(edText.getText().toString().equals("")){
                    value = "0";
                } else {
                    value = edText.getText().toString();
                }
                int sendingValue = Integer.parseInt(textView.getText().toString()) + Integer.parseInt(value);

                Intent intentToMainActivity = new Intent(SecondActivity.this, MainActivity.class);
                intentToMainActivity.putExtra("result", Integer.toString(sendingValue));
                startActivity(intentToMainActivity);
            }
        });
    }
}