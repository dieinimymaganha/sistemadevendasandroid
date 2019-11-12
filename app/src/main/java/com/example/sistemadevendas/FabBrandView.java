package com.example.sistemadevendas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class FabBrandView extends AppCompatActivity {

    ListView lst1;

    ArrayList<String> titles = new ArrayList<String>();
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fabbrandview);



        lst1 = findViewById(R.id.lst1);

        SQLiteDatabase db = openOrCreateDatabase("supervenda",
                Context.MODE_PRIVATE, null);

        final Cursor c = db.rawQuery("SELECT * FROM FABRICANTE", null);
        int id = c.getColumnIndex("id");
        int fabricante = c.getColumnIndex("fabricante");
        int fabdes = c.getColumnIndex("fabdes");

        titles.clear();

        arrayAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, titles);

        lst1.setAdapter(arrayAdapter);

        final ArrayList<Fab> brann = new ArrayList<Fab>();

        if (c.moveToNext()) {
            do {
                Fab br = new Fab();
                br.id = c.getString(id);
                br.fabricante = c.getString(fabricante);
                br.des = c.getString(fabdes);
                brann.add(br);
                titles.add(c.getString(id) + "\t" + c.getString(fabricante) +
                        "\t" + c.getString(fabdes));


            } while (c.moveToNext());
            arrayAdapter.notifyDataSetChanged();
            lst1.invalidateViews();
        }


    }
}
