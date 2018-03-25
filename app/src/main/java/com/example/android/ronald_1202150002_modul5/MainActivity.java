package com.example.android.ronald_1202150002_modul5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText ToDo, Description, Priority;
    Database dtbase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Add To Do");

        ToDo = (EditText) findViewById(R.id.editTodo);
        Description = (EditText) findViewById(R.id.editDesc);
        Priority = (EditText) findViewById(R.id.editPriority);
        dtbase = new Database(this);
    }

    @Override
    public void onBackPressed() {
        //intent dari add to do menuju list to do
        Intent intent = new Intent(MainActivity.this, ListToDo.class);
        //memulai intent
        startActivity(intent);
        this.finish();
    }

    public void tambah(View view) {
        if (dtbase.inputdata(new AddData(ToDo.getText().toString(), Description.getText().toString(), Priority.getText().toString()))){
            //menampilkan toast  data berhasil di tambahkan ke dalam list
            Toast.makeText(this, "To Do List added!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this, ListToDo.class));
            this.finish();
        }else {
            //jika edit text kosong maka akan muncul toast tidak bisa menambahkan ke dalam list
            Toast.makeText(this, "Cannot add the list", Toast.LENGTH_SHORT).show();
            ToDo.setText(null);
            Description.setText(null);
            Priority.setText(null);
        }
    }
}
