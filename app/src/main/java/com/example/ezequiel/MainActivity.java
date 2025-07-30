package com.example.ezequiel;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editTexto;
    Button botaoLer;
    TextView resultadoTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTexto = findViewById(R.id.editTexto);
        botaoLer = findViewById(R.id.botaoLer);
        resultadoTexto = findViewById(R.id.resultadoTexto);

        botaoLer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String entrada = editTexto.getText().toString();
                resultadoTexto.setText("Você digitou: " + entrada);
            }
        });
    }
}
