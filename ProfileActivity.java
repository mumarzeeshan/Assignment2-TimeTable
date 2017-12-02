package com.example.thesm.assignment1;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener{

    //initializing Buttons and text views
    private Button buttonLogout;
    private TextView textViewUserEmail;
    private Button twitterb;

    private Button buttonCoordinates;
    private TextView coordinatesView;
// initializing Loctaion listener and loction manager to get the cooridnates
    private LocationListener locationListener;
    private LocationManager locationManager;



    //private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;

   // private EditText editTextName,EditTextAdress;
   // private Button buttontosave;
    private Button buttonmaps;
    private Button viewTimetable;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
//creating the firebaseAuth get instance
        firebaseAuth= FirebaseAuth.getInstance();
            if (firebaseAuth.getCurrentUser()==null)
            {
                startActivity(new Intent(this,LoginActivity.class));

            }
            databaseReference= FirebaseDatabase.getInstance().getReference();
            FirebaseUser user = firebaseAuth.getCurrentUser();

           // editTextName=(EditText)findViewById(R.id.editName);
        //EditTextAdress=(EditText)findViewById(R.id.editTextAdress);
         //buttontosave= (Button)findViewById(R.id.ButtonToSave);

// getting the email ID of the current login user
        textViewUserEmail = (TextView) findViewById(R.id.textViewUserEmail);
        textViewUserEmail.setText("Welcome "+user.getEmail());

        buttonLogout = (Button)findViewById(R.id.ButtonToLogOut);

        twitterb = (Button)findViewById(R.id.twitterButton);

        twitterb.setOnClickListener(this);
        //buttontosave.setOnClickListener(this);
        buttonmaps = (Button)findViewById(R.id.ButtonMaps);
        viewTimetable = (Button)findViewById(R.id.ButtonTT);

        viewTimetable.setOnClickListener(this);

        buttonmaps.setOnClickListener(this);

        buttonLogout.setOnClickListener(this);

        // I have followed tutorial from Youtube to get the cooridnates of the user current location

        coordinatesView =(TextView)findViewById(R.id.coordinates);
        buttonCoordinates = (Button)findViewById(R.id.coordinatesButton);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                //t.append("\n " + location.getLongitude() + " " + location.getLatitude());
                coordinatesView.append(location.getLongitude() + " hjgyj" + location.getLatitude());
            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

                Intent i = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(i);
            }
        };

        configure_button();






    }
    //private void saveUserInfomation(){
      //  String name=editTextName.getText().toString().trim();
        //String add = EditTextAdress.getText().toString().trim();

        //userInformation UserInformation = new userInformation(name,add);
        //FirebaseUser user = firebaseAuth.getCurrentUser();
        //databaseReference.child(user.getUid()).setValue(UserInformation);

        //Toast.makeText(this,"Information Saved..",Toast.LENGTH_LONG).show();

    //}

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        switch (requestCode) {
            case 10:
                configure_button();
                break;
            default:
                break;
        }
    }

    void configure_button() {
        // first check for permissions
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,
                                Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.INTERNET}
                        , 10);
            }
            return;
        }
        // this code won'textView execute IF permissions are not allowed, because in the line above there is return statement.
        buttonCoordinates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //noinspection MissingPermission
                locationManager.requestLocationUpdates("gps", 5000, 0, locationListener);
            }
        });
    }



    @Override
    public void onClick(View view) {
        if (view==buttonLogout){
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this,LoginActivity.class));
        }

        //if (view==buttontosave){
         //   saveUserInfomation();
       // }
        if (view == buttonmaps)
        {

            startActivity(new Intent(this,MapsActivity.class));
        }
        if (view==viewTimetable)
        {
            startActivity(new Intent(this,TimetableActivity.class));
        }
            if (view==twitterb)
            {
                startActivity(new Intent(this,twitterActivity.class));

            }

    }
}
