/*
 * editActivity
 *
 * Version 1.0
 *
 *
 * February 04 2018
 *
 *
 * Copyright @ 2018 Shuai Li, COMPUT301, University of Alberta - All Rights Reserved.
 * You may use, distribute, or modify this code under teams and conditions of the Code of
 *    Student Behavior at Univertity of Alberta.
 * You can find a cope of the license in this porject. Otherwise please contact contact@abc.ca.
 */

package com.example.jimi.shuai3_subbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.jimi.shuai3_subbook.MainActivity.sublist;

public class editActivity extends AppCompatActivity {
    /**
     * @author Shuai Li
     */


    private EditText nameEdit;
    private EditText amountEdit;
    private EditText dateEdit;
    private EditText commentEdit;
    private Button Done2;
    private TextView OldSub;
    private Button Back2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        nameEdit=(EditText) findViewById(R.id.ed5);
        amountEdit=(EditText) findViewById(R.id.ed6);
        dateEdit=(EditText) findViewById(R.id.ed7);
        commentEdit=(EditText) findViewById(R.id.ed8);
        Done2 = (Button) findViewById(R.id.done2);
        OldSub=(TextView) findViewById(R.id.Old) ;
        Back2 = (Button) findViewById(R.id.back2);

        Back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(editActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });
        Bundle extras = getIntent().getExtras();

        final int Id= extras.getInt("id");
        nameEdit.setText(sublist.get(Id).getName());
        amountEdit.setText(sublist.get(Id).getAmount().substring(1));
        dateEdit.setText(sublist.get(Id).getDate().substring(6));
        commentEdit.setText(sublist.get(Id).getComment());

        Done2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name2=nameEdit.getText().toString();
                String amount2=amountEdit.getText().toString();
                String date2=dateEdit.getText().toString();
                String comment2=commentEdit.getText().toString();

                if(name2.length()>20){   /*check name length*/
                    Toast.makeText(editActivity.this,"Failure:Name too long",Toast.LENGTH_SHORT).show();
                }
                else if(date2.length() != 10 || date2.charAt(4) != '-' || date2.charAt(7) != '-'){
                    Toast.makeText(editActivity.this,"Failure: Invalid format for date",Toast.LENGTH_SHORT).show();;
                }

                else if(comment2.length()>30) {  /*check comment length */
                    Toast.makeText(editActivity.this,"Failure:comment too long",Toast.LENGTH_SHORT).show();

                }

                else if(name2.length() ==0){ /*check if name is missing*/
                    Toast.makeText(editActivity.this,"Failure: name required",Toast.LENGTH_SHORT).show();


                }
                /*else if(Integer.parseInt(amount)<0){
                    Toast.makeText(addActivity.this,"Failure: postive charge only ",Toast.LENGTH_SHORT).show();

                }*/
                else {

                     /*pass data using Intent*/

                    amount2="$"+amount2;
                    date2 = "Date: "+date2;
                    sublist.remove(Id);
                    Suscription editsuscription = new Suscription(name2, amount2, date2, comment2);
                    sublist.add(Id,editsuscription);

                    Intent intent = new Intent(editActivity.this, MainActivity.class);
                    startActivity(intent);

            }
        }});

    }

}
