package com.example.androiddemo.startActivityForResult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.androiddemo.R;

public class StartForResultActivity extends AppCompatActivity {
    private Button button;
    private TextView textView;
    private final static int iRequestCode = 0x11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_for_result);

        button = findViewById(R.id.btn_sfr_click);
        textView = findViewById(R.id.tv_sfr_show);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartForResultActivity.this, SecondActivity.class);
                startActivityForResult(intent, iRequestCode);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case iRequestCode:
                if (resultCode == RESULT_OK) {
                    String msg = data.getStringExtra("data_return");
                    textView.setText(msg);
                }
                break;
        }
    }
}
