package rohanparekh.conferencescheduler;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by rohan on 16-08-2016.
 */
public class Register extends AppCompatActivity implements View.OnClickListener {
    //initializing variables for views
    Button registerButton;
    EditText userName, password, confirmPassword;
    //RadioButton admin_register, doctor_register;
    //RadioButton radioButton;
    RadioGroup radioLayoutRegister;
    Context context = this;
    LoginDatabaseAdapter loginDataBaseAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        //assigning the view - text view

        registerButton = (Button) findViewById(R.id.registerButton);
        //assigning the view - edit text
        userName = (EditText) findViewById(R.id.userName_register);
        password = (EditText) findViewById(R.id.password_register);
        confirmPassword = (EditText) findViewById(R.id.confirmPassword_register);

        //assigning the view - radio button
        //admin_register = (RadioButton) findViewById(R.id.admin_register);
        //doctor_register = (RadioButton) findViewById(R.id.doctor_register);
        radioLayoutRegister = (RadioGroup) findViewById(R.id.radioLayout_register);

        //click events
        registerButton.setOnClickListener(this);

    }

    //click events
    @Override
    public void onClick(View v) {
        //int radioSelected = radioLayoutRegister.getCheckedRadioButtonId();
        //radioButton = (RadioButton) findViewById(radioSelected);
        String user = userName.getText().toString();
        String pass = password.getText().toString();
        String confpass = confirmPassword.getText().toString();
        String radioValue="";

        //checking which radio button is selected and accordingly activity is changed
        //and if not checked display a toast saying to select the radio
        if (radioLayoutRegister.getCheckedRadioButtonId() == -1) {

            Toast.makeText(getApplicationContext(), "Please select one option", Toast.LENGTH_SHORT).show();
        } else {

            int id= radioLayoutRegister.getCheckedRadioButtonId();
            View radioButton = radioLayoutRegister.findViewById(id);
            int radioId = radioLayoutRegister.indexOfChild(radioButton);
            RadioButton btn = (RadioButton) radioLayoutRegister.getChildAt(radioId);
            radioValue = (String) btn.getText();
        }
        if (user.equals("") || pass.equals("")
                || confpass.equals("")) {

            Toast.makeText(getApplicationContext(), "Field Vaccant",
                    Toast.LENGTH_LONG).show();
            return;
        }
        if (!pass.equals(confpass)) {
            Toast.makeText(getApplicationContext(),
                    "Password does not match", Toast.LENGTH_LONG)
                    .show();
            return;
        }else{
            
            loginDataBaseAdapter.insertEntry(user, pass, radioValue);
            Toast.makeText(getApplicationContext(),
                    "Account Successfully Created ", Toast.LENGTH_LONG)
                    .show();
            Intent i = new Intent(this,
                    MainActivity.class);
            startActivity(i);
            finish();
        }


    }
    }
