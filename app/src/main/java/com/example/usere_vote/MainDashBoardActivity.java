package com.example.usere_vote;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainDashBoardActivity extends AppCompatActivity {

    ImageView iRegister;
    ImageView iLogin;
    ImageView iResult;
    ImageView icinfo;
    ImageView ipoll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dash_board);

        iRegister = findViewById(R.id.imgregister);
        iLogin = findViewById(R.id.imglogin);
        iResult = findViewById(R.id.imgresult);
        icinfo = findViewById(R.id.imgcinfo);
        ipoll = findViewById(R.id.imgpoll);

        Toolbar toolbar1 = findViewById(R.id.toolbar_CheckDet);

        setSupportActionBar(toolbar1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        iRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(MainDashBoardActivity.this,VerificationActivity.class);
                startActivity(registerIntent);
            }
        });
        iLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(MainDashBoardActivity.this,VerificationActivity.class);
                startActivity(loginIntent);
            }
        });
        ipoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(MainDashBoardActivity.this,LoginActivity.class);
                startActivity(registerIntent);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.exit_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.setting) {
            return true;
        }
        if (id == R.id.exit) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
