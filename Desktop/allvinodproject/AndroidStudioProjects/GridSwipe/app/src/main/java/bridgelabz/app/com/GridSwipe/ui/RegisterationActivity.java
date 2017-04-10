package bridgelabz.app.com.GridSwipe.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import bridgelabz.app.com.listviewswipetest.R;
import bridgelabz.app.com.GridSwipe.base.BaseActivity;
import bridgelabz.app.com.GridSwipe.utils.Constants;

public class RegisterationActivity extends BaseActivity implements View.OnClickListener {
    private static final String TAG = "RegistrationActivity";
    AppCompatEditText editTextNameRegister;
    AppCompatEditText editTextEmRegister;
    AppCompatEditText editTextPassRegister;
    AppCompatEditText editTextMobRegister;
    AppCompatEditText editTextAddrRegister;
    AppCompatButton saveButton;
    AppCompatButton AlreadyAccountButton;
    Matcher mMatcher;
    Pattern Pattern;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        initView();
    }

    @Override
    public void initView() {
        editTextNameRegister = (AppCompatEditText) findViewById(R.id.editTextNameReg);
        editTextEmRegister = (AppCompatEditText) findViewById(R.id.editTextEmailReg);
        editTextPassRegister = (AppCompatEditText) findViewById(R.id.editTextPassReg);
        editTextMobRegister = (AppCompatEditText) findViewById(R.id.editTextMobReg);
        editTextAddrRegister = (AppCompatEditText) findViewById(R.id.editTextAddressReg);
        saveButton = (AppCompatButton) findViewById(R.id.SaveButton);
        AlreadyAccountButton = (AppCompatButton) findViewById(R.id.AlreadyAccButton);
        setListeners();
    }

    @Override
    public void setListeners() {

        saveButton.setOnClickListener(this);
        AlreadyAccountButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.SaveButton:
                validate();
                break;
            case R.id.AlreadyAccButton:
                Intent intent = new Intent(RegisterationActivity.this, LoginActivity.class);
                startActivity(intent);
                break;

        }
    }

    public void validate() {
        boolean checkemail = false, checkname = false, checkpassword = false, checkMobile = false, checkAddress = false;

        Pattern mPattern = Pattern.compile(Constants.Password_Pattern);
        mMatcher = mPattern.matcher(editTextPassRegister.getText().toString());

        SharedPreferences sh = getSharedPreferences(Constants.keys, Context.MODE_PRIVATE);
        String name = editTextNameRegister.getText().toString();
        String email = editTextEmRegister.getText().toString();
        String password = editTextPassRegister.getText().toString();
        String Mobile = editTextMobRegister.getText().toString();
        String Adress = editTextAddrRegister.getText().toString();

        if (name.isEmpty()) {
            editTextNameRegister.setError(getString(R.string.nameshould_not_be_empty));

        } else {
            checkname = true;
        }


        if (email.isEmpty()) {
            editTextEmRegister.setError(getString(R.string.Emailid_should_not_be_empty));

        } else if (!isValidEmail(email)) {
            editTextEmRegister.setError(getString(R.string.invalid_Email));
        } else {
            checkemail = true;
        }


        if (password.isEmpty()) {
            editTextPassRegister.setError(getString(R.string.password_should_not_be_empty));

        } else if (password.length() < 5) {
            editTextPassRegister.setError(getString(R.string.password_should_not_be_minimum_5_character));

        } else if (mMatcher.matches()) {
            checkpassword = true;
        } else {
            editTextPassRegister.setError(getString(R.string.wrongformat_of_password));
            editTextPassRegister.requestFocus();

        }

        if (Mobile.isEmpty()) {
            editTextMobRegister.setError(getString(R.string.mobile_no_should_not_be_empty));
        } else if (Mobile.length() < 10) {
            editTextMobRegister.setError(getString(R.string.mobile_no_should_be_10_digit));
        } else {
            checkMobile = true;
        }

        if (Adress.isEmpty()) {
            editTextAddrRegister.setError(getString(R.string.Address_should_not_empty));

        } else {
            checkAddress = true;
        }
        if (checkname && checkMobile && checkAddress && checkemail && checkpassword) {
            SharedPreferences.Editor editor = sh.edit();
            editor.putString("Name", name);
            editor.putString("email", email);
            editor.putString("password", password);
            editor.putString("Mobile", Mobile);
            editor.putString("Adress", Adress);
            editor.putBoolean("islogin", false);
            editor.commit();
            Toast.makeText(getApplicationContext(), R.string.registration_successful, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();

        }

    }

    private boolean isValidEmail(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

}

