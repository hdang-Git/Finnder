package edu.temple.finnder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class frontpage extends AppCompatActivity {

    EditText text1;
    EditText text2;

    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frontpage);
        text1 = (EditText)findViewById(R.id.editText);
        text2 = (EditText)findViewById(R.id.editText2);
        button1 = (Button) findViewById(R.id.button);




        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean complete=true;
                String text1complete = text1.getText().toString();
                String text2complete = text2.getText().toString();

                if(text1complete == null){
                    Toast.makeText(getApplicationContext(), "Empty Username", Toast.LENGTH_SHORT).show();
                    complete = false;
                }
                if(text2complete == null){
                    Toast.makeText(getApplicationContext(), "Empty Password", Toast.LENGTH_SHORT).show();
                    complete = false;
                }

                if(complete = true) {
                    Intent intent = new Intent(frontpage.this, MainActivity.class);
                    startActivity(intent);
                }
            }


        });
    }

}

