package com.example.sistemadevendas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class CategoriaEditar extends AppCompatActivity {
    EditText ed1, ed2, ed3;
    Button b1, b2, b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria_editar);

        ed1 = findViewById(R.id.catid);
        ed2 = findViewById(R.id.categoria);
        ed3 = findViewById(R.id.categoriadesc);

        b1 = findViewById(R.id.btn1);
        b2 = findViewById(R.id.btn2);
        b3 = findViewById(R.id.btn3);
    }
}
