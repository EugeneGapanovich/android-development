package by.gapanovich.workwithactivityandintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.ma_button_open_form2);
        TextView tView = (TextView) findViewById(R.id.ma_view_value);
        EditText edText = (EditText) findViewById(R.id.ma_enter_value);

        Intent intentFromSecondActivity = getIntent();
        if( intentFromSecondActivity.getStringExtra("result") != null){
            tView.setText(intentFromSecondActivity.getStringExtra("result"));
        }


        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String value = ""; // contains value from EditText 'edText' field
                if(edText.getText().toString().equals("")){
                    value = "0";
                } else {
                    value = edText.getText().toString();
                }
                int sendingValue = Integer.parseInt(tView.getText().toString()) + Integer.parseInt(value);
                Intent intentToSecondActivity = new Intent(MainActivity.this, SecondActivity.class);
                intentToSecondActivity.putExtra("message", Integer.toString(sendingValue));
                startActivity(intentToSecondActivity);
            }
        });
    }

}