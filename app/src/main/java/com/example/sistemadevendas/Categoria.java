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

import java.sql.SQLData;

public class Categoria extends AppCompatActivity {
    EditText ed1, ed2;
    Button bt1, bt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);

        ed1 = findViewById(R.id.categoria);
        ed2 = findViewById(R.id.categproadesc);
        bt1 = findViewById(R.id.btn1);


        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert();
            }
        });


        bt2 = findViewById(R.id.btn2);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Categoria.this, Main.class);
                startActivity(i);
            }
        });
    }

    public void insert() {
        try {
            String categoria = ed1.getText().toString();
            String descricao = ed2.getText().toString();
            SQLiteDatabase db = openOrCreateDatabase("supervenda",
                    Context.MODE_PRIVATE, null);
            db.execSQL("CREATE TABLE IF NOT EXISTS categoria(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "categoria VARCHAR, catdesc VARCHAR)");
            String sql = "INSERT INTO categoria (categoria, catdesc) values (?,?) ";
            SQLiteStatement statement = db.compileStatement(sql);
            statement.bindString(1, categoria);
            statement.bindString(2, descricao);
            statement.execute();
            Toast.makeText(this, "Categoria adicionada com sucesso", Toast.LENGTH_SHORT).show();
            ed1.setText("");
            ed2.setText("");
            ed1.requestFocus();
        } catch (Exception ex) {
            Toast.makeText(this, "Categoria deu pau!", Toast.LENGTH_SHORT).show();
        }

    }



}



