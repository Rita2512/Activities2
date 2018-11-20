package com.rguz.activities2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

public class Profile extends Activity {
    TextView QA;
    TextView AT;
    TextView Av;
    TextView EmpName;
    TextView Pos;
    Button share;
    String textToShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        EmpName = findViewById(R.id.textViewEmpName);
        Pos = findViewById(R.id.textViewPos);
        QA = findViewById(R.id.textViewQuality);
        Av = findViewById(R.id.textViewAverage);
        AT = findViewById(R.id.textViewAttendance);
        Bundle bundle = getIntent().getExtras();

        final String arrayReceived[] = bundle.getStringArray("Send_JP");
        EmpName.setText(arrayReceived[0]);
        Pos.setText(arrayReceived[1]);
        QA.setText(arrayReceived[2]);
        Av.setText(arrayReceived[3]);
        AT.setText(arrayReceived[4]);




        //share button
        share = findViewById(R.id.buttonShare);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                textToShare = arrayReceived[0] + "\n" + arrayReceived[1];
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, textToShare);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });

    }
}
