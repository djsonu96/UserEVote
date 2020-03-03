package com.example.usere_vote;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

public class LoginDashBoardActivity extends AppCompatActivity {

    ImageView iVote;
    ImageView iVoterList;
    ImageView iCandiList;
    ImageView iResult;
    ImageView ipoll;
    ImageView iHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_dash_board);

        iVote = findViewById(R.id.imgvote);
        iVoterList = findViewById(R.id.imguprofile);
        iCandiList = findViewById(R.id.imgcinfo);
        ipoll = findViewById(R.id.imgpoll);
        iResult = findViewById(R.id.imgresult);
        iHelp = findViewById(R.id.imghelp);

        Toolbar toolbar1 = findViewById(R.id.toolbar_CheckDet);

        setSupportActionBar(toolbar1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        iVote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent voteIntent = new Intent(LoginDashBoardActivity.this,VoteActivity.class);
                startActivity(voteIntent);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.logout_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.logout){
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(getApplicationContext(),MainDashBoardActivity.class));
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
