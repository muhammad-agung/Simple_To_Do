package sg.edu.rp.c346.id18004536.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etAnswer;
    Button btnAdd;
    Button btnClear;
    ListView lvTD;

    ArrayList<String> alTD;
    ArrayAdapter<String> aaColour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAnswer=findViewById(R.id.editTextTD);
        btnAdd=findViewById(R.id.buttonAdd);
        btnClear=findViewById(R.id.butttonClear);
        lvTD=findViewById(R.id.listView);


        alTD = new ArrayList<>();

        aaColour=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,alTD);

        lvTD.setAdapter(aaColour);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String td = etAnswer.getText().toString();

                alTD.add(td);

                aaColour.notifyDataSetChanged();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aaColour.clear();
            }
        });

    lvTD.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            String show = alTD.get(position);
            Toast.makeText(MainActivity.this,show,Toast.LENGTH_LONG).show();
            return false;
        }
    });


    }
}
