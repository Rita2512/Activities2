package com.rguz.activities2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SelectEmployee extends Activity implements View.OnClickListener {

    TextView loggedName;
    String nameDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_employee);
        loggedName = findViewById(R.id.textViewLoggedName);
        nameDisplay = getIntent().getExtras().getString("Send_Email");
        loggedName.setText(nameDisplay);

        TextView JP = findViewById(R.id.textViewJP);
        TextView JM = findViewById(R.id.textViewJM);
        TextView AG = findViewById(R.id.textViewAG);

        JP.setOnClickListener(this);
        JM.setOnClickListener(this);
        AG.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
     switch (v.getId()){
         case R.id.textViewJP:
             String[] emp1 = new String[]{"Juan Perez","JR analyst","70","31","70"};
             Intent sendJP = new Intent(this, Profile.class);
             Bundle bundle = new Bundle();
             bundle.putStringArray("Send_JP", emp1);
             sendJP.putExtras(bundle);
             startActivity(sendJP);
             break;

            case R.id.textViewJM:
                String[] emp2 = new String[]{"Julia Morales","Senior analyst","80","40","85"};
                Intent sendJM = new Intent(this, Profile.class);
                Bundle bundle1 = new Bundle();
                bundle1.putStringArray("Send_JM", emp2);
                sendJM.putExtras(bundle1);
                startActivity(sendJM);
                break;

            case R.id.textViewAG:
                String[] emp3 = new String[]{"Alfredo Guzman","Senior analyst II","95","55","90"};
                Intent sendAG = new Intent(this, Profile.class);
                Bundle bundle2 = new Bundle();
                bundle2.putStringArray("Send_AG", emp3);
                sendAG.putExtras(bundle2);
                startActivity(sendAG);
                break;
        }

     }
    }
