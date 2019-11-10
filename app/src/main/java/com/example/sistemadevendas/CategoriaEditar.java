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

        Intent i = getIntent();

        String id = i.getStringExtra("id").toString();
        String categoria = i.getStringExtra("categoria").toString();
        String desc = i.getStringExtra("catdesc").toString();

        ed1.setText(id);
        ed2.setText(categoria);
        ed3.setText(desc);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Editar();
            }
        });
    }

    public void Editar() {
        try {
            String catid = ed1.getText().toString();
            String categorianome = ed2.getText().toString();
            String catdescricao = ed3.getText().toString();
            SQLiteDatabase db = openOrCreateDatabase("supervenda",
                    Context.MODE_PRIVATE, null);
            String sql = "UPDATE categoria SET categoria = ?, catdesc = ? WHERE id = ?";
            SQLiteStatement statement = db.compileStatement(sql);
            statement.bindString(1, categorianome);
            statement.bindString(2, catdescricao);
            statement.bindString(3, catid);
            statement.execute();
            Toast.makeText(this, "Categoria Atualizada com sucesso", Toast.LENGTH_SHORT).show();

            Intent i = new Intent(getApplicationContext(), Main.class);
            startActivity(i);

        } catch (Exception ex) {
            Toast.makeText(this, "Categoria deu pau!", Toast.LENGTH_SHORT).show();
        }
    }
}
