package com.example.jimi.shuai3_subbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import static com.example.jimi.shuai3_subbook.MainActivity.sublist;


public class addActivity extends AppCompatActivity {



    private EditText nameInput;
    private EditText amountInput;
    private EditText dateInput;
    private EditText commentInput;
    private Button Done;
    private TextView NewSub;
    private Button Back1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adds);

        nameInput=(EditText) findViewById(R.id.ed1);
        amountInput=(EditText) findViewById(R.id.ed2);
        dateInput=(EditText) findViewById(R.id.ed3);
        commentInput=(EditText) findViewById(R.id.ed4);
        Done = (Button) findViewById(R.id.done);
        NewSub=(TextView) findViewById(R.id.New) ;
        Back1 = (Button) findViewById(R.id.back1);

        Back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(addActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });


        /*check all data format after press "done"*/
        Done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name=nameInput.getText().toString();
                String amount=amountInput.getText().toString();
                String date=dateInput.getText().toString();
                String comment=amountInput.getText().toString();

                /*data check process*/

                if(name.length()>20){   /*check name length*/
                    Toast.makeText(addActivity.this,"Failure:Name too long",Toast.LENGTH_SHORT).show();
                }
                else if(date.length() != 10 || date.charAt(4) != '-' || date.charAt(7) != '-'){    /*check data format*/
                    Toast.makeText(addActivity.this,"Failure: Invalid format for date",Toast.LENGTH_SHORT).show();;
                }

                else if(comment.length()>30) {  /*check comment length */
                    Toast.makeText(addActivity.this,"Failure:comment too long",Toast.LENGTH_SHORT).show();

                }

                else if(name.length() ==0){ /*check if name is missing*/
                    Toast.makeText(addActivity.this,"Failure: name required",Toast.LENGTH_SHORT).show();


                }
                /*else if(Integer.parseInt(amount)<0){
                    Toast.makeText(addActivity.this,"Failure: postive charge only ",Toast.LENGTH_SHORT).show();

                }*/
                else {

                     /*pass data using Intent*/

                    amount="$"+amount;
                    date = "Date: "+date;
                    Suscription newsuscription = new Suscription(name, amount, date, comment);
                    sublist.add(newsuscription);


                    Intent intent = new Intent(addActivity.this, MainActivity.class);
                    startActivity(intent);
                }

            }
        });}







}

