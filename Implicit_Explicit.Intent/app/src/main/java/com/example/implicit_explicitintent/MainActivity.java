package com.example.implicit_explicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText editText, editText2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        editText = findViewById(R.id.editTextText);
        editText2 = findViewById(R.id.editTextText2);
        IntentFilter filter = new IntentFilter("com.tutorialspoint.CUSTOM_INTENT");
        registerReceiver(new MyReceiver(), filter);
        button.setOnClickListener(v -> {
            Intent intent=new Intent();
            int n1 = Integer.parseInt(editText.getText().toString());
            int n2 = Integer.parseInt(editText2.getText().toString());
            intent.putExtra("number1", n1);
            intent.putExtra("number2", n2);
            intent.setAction("com.tutorialspoint.CUSTOM_INTENT");
            sendBroadcast(intent);
        });

    }
    public void broadcastIntent(View view)
    {
        Intent intent=new Intent();
        intent.setAction("com.tutorialspoint.CUSTOM_INTENT");
        sendBroadcast(intent);
    }

}