package com.example.jimi.shuai3_subbook;


import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
    private static final String FILENAME = "file.txt";
    private TextView totalTv;
    private ListView lv;
    private Button Adds;
    private Button Deletes;
    private Button Edit;
    public static ArrayList<Suscription> sublist =new ArrayList<Suscription>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Adds = (Button) findViewById(R.id.add);
        Deletes = (Button) findViewById(R.id.delete);
        lv = (ListView) findViewById(R.id.listView);
        Edit=(Button) findViewById(R.id.edit);



        //adapter
        final ArrayAdapter adapter = new ArrayAdapter<Suscription>(MainActivity.this, android.R.layout.simple_list_item_multiple_choice, sublist);
        adapter.notifyDataSetChanged();
        lv.setAdapter(adapter);
        setTotalTv();


        //add
        Adds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addSuscription();
                adapter.notifyDataSetChanged();


            }
        });
        //select
        lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            }
        });

        //delete
        Deletes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDeletes(adapter);
                setTotalTv();

            }
        });

        //edit
        Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setEdit();

            }
        });




    }

    private void setEdit() {
        SparseBooleanArray checked = lv.getCheckedItemPositions();
        int size = lv.getCount();
        int oneChecked=0;
        int checkedId=0;

        for (int i = size - 1; i > -1; i--) {
            if (lv.isItemChecked(i)) {
                checkedId=i;
                oneChecked=oneChecked+1;
            }
        }
        if(oneChecked==1){

            Intent intent = new Intent(MainActivity.this, editActivity.class);
            intent.putExtra("id",checkedId);
            startActivity(intent);
        }
        if(oneChecked==0){
            Toast.makeText(MainActivity.this, "Nothing to view", Toast.LENGTH_SHORT).show();
        }
        if(oneChecked>1){
            Toast.makeText(MainActivity.this, "Only one can be viewed", Toast.LENGTH_SHORT).show();
        }

    }



    private void setTotalTv(){
        totalTv = (TextView) findViewById(R.id.totalCharge);
        int charges = lv.getCount();
        int totalCharges=0;
        for(int o=0;o<charges;o++){
            totalCharges=totalCharges+Integer.valueOf(sublist.get(o).getAmount().substring(1));
        }

        totalTv.setText("Total: $"+String.valueOf(totalCharges));
    }

    private void addSuscription()
    {
        Intent intent = new Intent(MainActivity.this, addActivity.class);
        startActivity(intent);

    }
    private void setDeletes(ArrayAdapter oldadapter){
        SparseBooleanArray checked=lv.getCheckedItemPositions();
        int size=lv.getCount();

        for(int i = size-1;i>-1;i--){
            if (lv.isItemChecked(i)){
                sublist.remove(i);
            }
        }
        checked.clear();
        oldadapter.notifyDataSetChanged();
        if(size==0) {
            Toast.makeText(MainActivity.this, "List is empty", Toast.LENGTH_SHORT).show();
        }
    }


}
