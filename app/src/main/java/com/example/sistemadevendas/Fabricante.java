package com.example.sistemadevendas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Fabricante extends AppCompatActivity {
    EditText ed1, ed2;
    Button bt1, bt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fabricante);
        ed1 = findViewById(R.id.idfabricante);
        ed2 = findViewById(R.id.fabricantedes);
        bt1 = findViewById(R.id.btn1);
        bt2 = findViewById(R.id.btn2);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert();
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Fabricante.this, Main.class);
                startActivity(i);
            }
        });

    }

    public void insert(){
        try {
            String fabricante = ed1.getText().toString();
            String fabricantedesc = ed2.getText().toString();
            SQLiteDatabase db = openOrCreateDatabase("supervenda",
                    Context.MODE_PRIVATE, null);
            db.execSQL("CREATE TABLE IF NOT EXISTS fabricante(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "fabricante VARCHAR, fabdes VARCHAR)");
            String sql = "INSERT INTO fabricante (fabricante, fabdes) values (?,?) ";
            SQLiteStatement statement = db.compileStatement(sql);
            statement.bindString(1, fabricante);
            statement.bindString(2, fabricantedesc);
            statement.execute();
            Toast.makeText(this, "Fabricante adicionada com sucesso", Toast.LENGTH_SHORT).show();
            ed1.setText("");
            ed2.setText("");
            ed1.requestFocus();
        } catch (Exception ex) {
            Toast.makeText(this, "Categoria deu pau!", Toast.LENGTH_SHORT).show();
        }

    }
}
