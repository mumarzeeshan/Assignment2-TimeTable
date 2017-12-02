package com.example.thesm.assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class TimetableActivity extends AppCompatActivity {

    // I have use firebase firestore as a database. I tried to use firebase Real time database. But it was not giving me the
    // correct result.

    // Also Firebase Firestore needs internet to get the timetable from the firestore. So it may take some time depending on the
    // internet connection


    // Intializing Text view for the timetable
    private TextView textViewm1,textViewm2,textViewm3,textViewm4,textViewm5,textViewm6,textViewm7;
    private TextView textViewt1,textViewt2,textViewt3,textViewt4,textViewt5,textViewt6,textViewt7;
    private  TextView textVieww1,textVieww2,textVieww3,textVieww4,textVieww5,textVieww6,textVieww7;
    private TextView textViewth1,textViewth2,textViewth3,textViewth4,textViewth5,textViewth6,textViewth7;
    private TextView textViewf1,textViewf2,textViewf3,textViewf4,textViewf5,textViewf6,textViewf7;

// connecting android app with the firebase firestore database
    private DocumentReference mDocRef = FirebaseFirestore.getInstance().document("/Timetable/D83DUKcB4kuKXEBtcuAv");

    // Firebase  database instance
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);
        textViewm1 = (TextView)findViewById(R.id.m1);
        textViewm2 = (TextView)findViewById(R.id.m2);
        textViewm3 = (TextView)findViewById(R.id.m3);
        textViewm4 = (TextView)findViewById(R.id.m4);
        textViewm5 = (TextView)findViewById(R.id.m5);
        textViewm6 = (TextView)findViewById(R.id.m6);
        textViewm7 = (TextView)findViewById(R.id.m7);

        textViewt1 = (TextView)findViewById(R.id.t1);
        textViewt2 = (TextView)findViewById(R.id.t2);
        textViewt3 = (TextView)findViewById(R.id.t3);
        textViewt4 = (TextView)findViewById(R.id.t4);
        textViewt5 = (TextView)findViewById(R.id.t5);
        textViewt6 = (TextView)findViewById(R.id.t6);
        textViewt7 = (TextView)findViewById(R.id.t7);

        textVieww1 = (TextView)findViewById(R.id.w1);
        textVieww2 = (TextView)findViewById(R.id.w2);
        textVieww3 = (TextView)findViewById(R.id.w3);
        textVieww4 = (TextView)findViewById(R.id.w4);
        textVieww5 = (TextView)findViewById(R.id.w5);
        textVieww6 = (TextView)findViewById(R.id.w6);
        textVieww7 = (TextView)findViewById(R.id.w7);


        textViewth1 =(TextView)findViewById(R.id.th1);
        textViewth2 =(TextView)findViewById(R.id.th2);
        textViewth3 =(TextView)findViewById(R.id.th3);
        textViewth4 =(TextView)findViewById(R.id.th4);
        textViewth5 =(TextView)findViewById(R.id.th5);
        textViewth6 =(TextView)findViewById(R.id.th6);
        textViewth7 =(TextView)findViewById(R.id.th7);

        textViewf1 =(TextView)findViewById(R.id.fr1);
        textViewf2 =(TextView)findViewById(R.id.fr2);
        textViewf3 =(TextView)findViewById(R.id.fr3);
        textViewf4 =(TextView)findViewById(R.id.fr4);
        textViewf5 =(TextView)findViewById(R.id.fr5);
        textViewf6 =(TextView)findViewById(R.id.fr6);
        textViewf7 =(TextView)findViewById(R.id.fr7);


        //getting the text from firebase firestore and setting it equal to the textview.
        mDocRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists())
                {
                    String m1 = documentSnapshot.getString("classM1");
                    textViewm1.setText(m1);

                    String m2 = documentSnapshot.getString("classM2");
                    textViewm2.setText(m2);

                    String m3 = documentSnapshot.getString("classM3");
                    textViewm3.setText(m3);

                    String m4 = documentSnapshot.getString("classM4");
                    textViewm4.setText(m4);

                    String m5 = documentSnapshot.getString("classM5");
                    textViewm5.setText(m5);

                    String m6 = documentSnapshot.getString("classM6");
                    textViewm6.setText(m6);

                    String m7 = documentSnapshot.getString("classM7");
                    textViewm7.setText(m7);


                    String t1 = documentSnapshot.getString("ClassT1");
                    textViewt1.setText(t1);

                    String t2 = documentSnapshot.getString("ClassT2");
                    textViewt2.setText(t2);
                    String t3 = documentSnapshot.getString("ClassT3");
                    textViewt3.setText(t3);
                    String t4 = documentSnapshot.getString("ClassT4");
                    textViewt4.setText(t4);
                    String t5 = documentSnapshot.getString("ClassT5");
                    textViewt5.setText(t5);
                    String t6 = documentSnapshot.getString("ClassT6");
                    textViewt6.setText(t6);
                    String t7 = documentSnapshot.getString("ClassT7");
                    textViewt7.setText(t7);

                    String w1 = documentSnapshot.getString("ClassW1");
                    textVieww1.setText(w1);

                    String w2 = documentSnapshot.getString("ClassW2");
                    textVieww2.setText(w2);
                    String w3 = documentSnapshot.getString("ClassW3");
                    textVieww3.setText(w3);
                    String w4 = documentSnapshot.getString("ClassW4");
                    textVieww4.setText(w4);
                    String w5 = documentSnapshot.getString("ClassW5");
                    textVieww5.setText(w5);
                    String w6 = documentSnapshot.getString("ClassW6");
                    textVieww6.setText(w6);


                    String w7 = documentSnapshot.getString("ClassW7");
                    textVieww7.setText(w7);


                    String th1 = documentSnapshot.getString("ClassTh1");
                    textViewth1.setText(th1);
                    String th2 = documentSnapshot.getString("ClassTh2");
                    textViewth2.setText(th2);


                    String th3 = documentSnapshot.getString("ClassTh3");
                    textViewth3.setText(th3);

                    String th4 = documentSnapshot.getString("ClassTh4");
                    textViewth4.setText(th4);

                    String th5 = documentSnapshot.getString("ClassTh5");
                    textViewth5.setText(th5);

                    String th6 = documentSnapshot.getString("ClassTh6");
                    textViewth6.setText(th6);

                    String th7 = documentSnapshot.getString("ClassTh7");
                    textViewth7.setText(th7);

                    String f1 = documentSnapshot.getString("ClassF1");
                    textViewf1.setText(f1);

                    String f2 = documentSnapshot.getString("ClassF2");
                    textViewf2.setText(f2);

                    String f3 = documentSnapshot.getString("ClassF3");
                    textViewf3.setText(f3);

                    String f4= documentSnapshot.getString("ClassF4");
                    textViewf4.setText(f4);

                    String f5 = documentSnapshot.getString("ClassF5");
                    textViewf5.setText(f5);

                    String f6 = documentSnapshot.getString("ClassF6");
                    textViewf6.setText(f6);

                    String f7 = documentSnapshot.getString("ClassF7");
                    textViewf7.setText(f7);




                }
            }
        });

    }
}
