package edu.ualr.intentsassignment;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.content.Context;

import edu.ualr.intentsassignment.databinding.CfaLayoutBinding;
import edu.ualr.intentsassignment.model.Contact;

import com.google.android.material.button.MaterialButton;


public class ContactFormActivity extends AppCompatActivity {
    //2. Define the basic skeleton of the ContactFormActivity. Inflate the layout defined in the first step to display the GUI elements on screen.

    private CfaLayoutBinding mBinding;
    private EditText userInput;
    public static final String EXTRA_CONTACT = "Contact_data";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = CfaLayoutBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        final MaterialButton button = findViewById(R.id.save_contact_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonClick();
            }
        });
    }

    //06. Create a new method that reads the values in the several EditText elements of the layout and then uses the Contact class to send those data to ContactInfoActivity
    public void onButtonClick() {
        Intent intent = new Intent(this, ContactInfoActivity.class);
        Contact contact = new Contact();

        userInput = findViewById(R.id.Fname_textInputLayout);
        contact.setFirstName(userInput.getText().toString());
        userInput = findViewById(R.id.Lname_textInputLayout);
        contact.setLastName(userInput.getText().toString());
        userInput = findViewById(R.id.telephone_textInputLayout);
        contact.setPhoneNumber(userInput.getText().toString());
        userInput = findViewById(R.id.email_textInputLayout);
        contact.setEmailAddress(userInput.getText().toString());
        userInput = findViewById(R.id.website_textInputLayout);
        contact.setWebsite(userInput.getText().toString());
        userInput = findViewById(R.id.address_textInputLayout);
        contact.setAddress(userInput.getText().toString());

        intent.putExtra(EXTRA_CONTACT, contact);
        startActivity(intent);
    }

}
