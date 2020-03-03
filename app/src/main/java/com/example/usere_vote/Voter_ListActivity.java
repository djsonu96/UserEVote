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
import android.widget.Button;
import android.widget.TextView;



import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class Voter_ListActivity extends AppCompatActivity {

    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    TextView mName, mEmail, mPhone, mDate, mAadhaar;
    Button bGOTo;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voter__list);

        mName = findViewById(R.id.profileFullName);
        mAadhaar = findViewById(R.id.tAadharNumber);
        mPhone = findViewById(R.id.tMobileNumber);
        mDate = findViewById(R.id.tDateofBirth);
        mEmail = findViewById(R.id.tEmailAdd);
        bGOTo = findViewById(R.id.btnGoTo);

        Toolbar toolbar1 = findViewById(R.id.toolbar_CheckDet);

        setSupportActionBar(toolbar1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        bGOTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoIntent = new Intent(Voter_ListActivity.this,LoginDashBoardActivity.class);
                startActivity(gotoIntent);
            }
        });


        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        DocumentReference docRf = fStore.collection("users").document(fAuth.getCurrentUser().getUid());
        docRf.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()){

                    mName.setText(documentSnapshot.getString("fullName"));
                    mAadhaar.setText(documentSnapshot.getString("aadhaar"));
                    mEmail.setText(documentSnapshot.getString("emailId"));
                    mDate.setText(documentSnapshot.getString("dateofBirth"));
                    mPhone.setText(documentSnapshot.getString("mobileNumber"));


                }
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
