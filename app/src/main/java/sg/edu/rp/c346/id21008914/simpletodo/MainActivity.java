package sg.edu.rp.c346.id21008914.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etNewToDo;
    Button btnAdd;
    Button btnClearAll;
    ListView lvToDo;

    ArrayList<String> alTodo;
    ArrayAdapter<String> aaTodo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNewToDo = findViewById(R.id.editNewToDo);
        btnAdd = findViewById(R.id.buttonAddItem);
        btnClearAll = findViewById(R.id.buttonClearItem);
        lvToDo = findViewById(R.id.listViewToDo);

        alTodo = new ArrayList<>();
        aaTodo = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alTodo);
        lvToDo.setAdapter(aaTodo);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newTodo = etNewToDo.getText().toString();
                alTodo.add(newTodo);
                aaTodo.notifyDataSetChanged();
                etNewToDo.setText(null);
            }
        });


        btnClearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alTodo.clear();
                aaTodo.notifyDataSetChanged();
            }
        });

    }
}