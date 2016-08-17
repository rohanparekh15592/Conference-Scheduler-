package rohanparekh.conferencescheduler;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //initializing variables for views
    TextView signIn, signUp;
    EditText userName, password;
    RadioButton admin, doctor;
    RadioGroup radioLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assigning the view - text view
        signIn = (TextView) findViewById(R.id.buttonSignIn);
        signUp = (TextView) findViewById(R.id.buttonSignUp);

        //assigning the view - edit text
        userName = (EditText) findViewById(R.id.userName);
        password = (EditText) findViewById(R.id.password);

        //assigning the view - radio button
        admin = (RadioButton) findViewById(R.id.admin);
        doctor = (RadioButton) findViewById(R.id.doctor);
        radioLayout = (RadioGroup) findViewById(R.id.radioLayout);

        //click events
        signIn.setOnClickListener(this);
        signUp.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.buttonSignIn:
                int radioSelected = radioLayout.getCheckedRadioButtonId();

                if (radioLayout.getCheckedRadioButtonId() == -1) {

                    Toast.makeText(getApplicationContext(), "Please select one option", Toast.LENGTH_SHORT).show();
                } else {
                    if (radioSelected == admin.getId()) {

                    } else {

                    }
                }
                break;
            case R.id.buttonSignUp:
                break;
        }


    }
}
