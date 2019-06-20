package com.apkglobal.sharedprefrences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2;
    Button save,fetch,update,delete;
    private SharedPreferences pref;
    private String prefName="rahul";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1=findViewById(R.id.userid);
        e2=findViewById(R.id.name);

        save=findViewById(R.id.save1);
        fetch=findViewById(R.id.fetch1);
        update=findViewById(R.id.update1);
        delete=findViewById(R.id.delete1);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pref=getSharedPreferences(prefName,MODE_PRIVATE);
                SharedPreferences.Editor editor=pref.edit();
                editor.putInt("ID",Integer.parseInt(e1.getText().toString()));
                editor.putString("NAME",e2.getText().toString());
                editor.commit();
                Toast.makeText(getBaseContext(), "Saved", Toast.LENGTH_SHORT).show();

            }
        });
        fetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                pref=getSharedPreferences(prefName,MODE_PRIVATE);
                String s1=String.valueOf(pref.getInt("ID",100));
                String s2=pref.getString("NAME","ABC");
                e1.setText(s1);
                e2.setText(s2);

                Toast.makeText(getBaseContext(), "Data Fetched", Toast.LENGTH_SHORT).show();

            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                pref=getSharedPreferences(prefName,MODE_PRIVATE);
                SharedPreferences.Editor editor=pref.edit();
                editor.putInt("ID",Integer.parseInt(e1.getText().toString()));
                editor.putString("NAME",e2.getText().toString());
                editor.commit();
                Toast.makeText(getBaseContext(), "Updated", Toast.LENGTH_SHORT).show();
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                pref=getSharedPreferences(prefName,MODE_PRIVATE);
                SharedPreferences.Editor editor=pref.edit();
                editor.clear();
                editor.commit();
                Toast.makeText(getBaseContext(), "Deleted", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
