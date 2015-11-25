package com.techacademy.loginmysqlphp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by priya on 7/16/2015.
 */
public class DisplayInfo extends Activity {
    LocalDatabase localDatabase;

    TextView tvname , tvemail , tvusername , tvpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_info);

        tvusername = (TextView)findViewById(R.id.TVusername);
        tvpassword = (TextView)findViewById(R.id.TVpassword);
        tvname = (TextView)findViewById(R.id.TVname);
        tvemail = (TextView)findViewById(R.id.TVemail);

        localDatabase = new LocalDatabase(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        if(authenticate() == true)
        {
            displayContactDetails();
        }
        else
        {
            Intent intent = new Intent(DisplayInfo.this , MainActivity.class);
            startActivity(intent);
        }
    }

    private boolean authenticate()
    {
        return localDatabase.getUserLoggedIn();
    }

    private void displayContactDetails()
    {
        Contact contact = localDatabase.getLoggedInUser();
        tvname.setText(contact.name);
        tvemail.setText(contact.email);
        tvusername.setText(contact.username);
        tvpassword.setText(contact.password);
    }

    public void onLogoutClick(View view){

        localDatabase.clearData();
        localDatabase.setUserLoggedIn(false);

        Intent intent = new Intent(DisplayInfo.this , MainActivity.class);
        startActivity(intent);

    }
}
