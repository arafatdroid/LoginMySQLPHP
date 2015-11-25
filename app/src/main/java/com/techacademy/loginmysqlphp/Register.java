package com.techacademy.loginmysqlphp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by priya on 7/16/2015.
 */
public class Register extends Activity {
    EditText etname ,etemail , etusername , etpassword, etconfirm_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        etusername = (EditText)findViewById(R.id.TFusername_register);
        etpassword = (EditText)findViewById(R.id.TFpassword_register);
        etname = (EditText)findViewById(R.id.TFname_register);
        etemail = (EditText)findViewById(R.id.TFemail_register);
        etconfirm_password = (EditText)findViewById(R.id.TFconfirm_password_register);

    }

    public void onLoginClick(View view)
    {
        Intent intent = new Intent(Register.this , MainActivity.class);
        startActivity(intent);
    }

    public void onRegisterClick(View view){
        String name = etname.getText().toString();
        String email = etemail.getText().toString();
        String username = etusername.getText().toString();
        String password = etpassword.getText().toString();
        String confirm_password = etconfirm_password.getText().toString();



        if(password.equals(confirm_password))
        {
            Contact contact = new Contact(name ,email , username,password);
            ServerRequests serverRequests = new ServerRequests(this);
            serverRequests.storeDataInBackground(contact , new GetUserCallback() {
                @Override
                public void done(Contact returnedContact) {
                    Intent intent = new Intent(Register.this , MainActivity.class);
                    startActivity(intent);
                }
            });
        }
        else{
            Toast.makeText(this , "Passwords don't match! Enter again!" , Toast.LENGTH_LONG).show();
        }

    }



}
