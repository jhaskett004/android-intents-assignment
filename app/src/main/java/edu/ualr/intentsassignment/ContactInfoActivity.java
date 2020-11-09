package edu.ualr.intentsassignment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import edu.ualr.intentsassignment.databinding.CiaLayoutBinding;
import edu.ualr.intentsassignment.model.Contact;

import com.google.android.material.chip.Chip;

public class ContactInfoActivity extends AppCompatActivity {

    // TODO 04. Define the basic skeleton of the ContactInfoActivity. Inflate the layout defined in the first step to display the GUI elements on screen.

    private CiaLayoutBinding mBinding;
    private TextView resultTV;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cia_layout);

        setContactData();

        final Chip callChip = findViewById(R.id.call_chip);
        callChip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCallChipClick();
            }
        });







    }
    //07. Create a new method that reads the contact info coming from ContactFormActivity and use it to populate the several TextView elements in the layout.
    public void setContactData() {

        Contact contact = getIntent().getParcelableExtra(ContactFormActivity.EXTRA_CONTACT);

        resultTV = findViewById((R.id.CIA_full_name));
        resultTV.setText(contact.getFullName());
        resultTV = findViewById(R.id.CIA_email_address);
        resultTV.setText(contact.getEmailAddress());
        resultTV = findViewById((R.id.CIA_location));
        resultTV.setText(contact.getAddress());
        resultTV = findViewById((R.id.CIA_phoneNumber));
        resultTV.setText(contact.getPhoneNumber());
        resultTV = findViewById((R.id.CIA_website));
        resultTV.setText(contact.getWebsite());
    }

    public void onCallChipClick() {
        resultTV = findViewById((R.id.CIA_phoneNumber));
        String phoneNumberUri = String.valueOf(resultTV);
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(phoneNumberUri));

        startActivity(intent);
    }




    // TODO 08. Create a new method that invokes a Phone Dialer app, using as parameter the phone number included in the contact info received from ContactFormActivity in the previous step
    // TODO 09. Create a new method that invokes a Messages app, using as parameter the phone number included in the contact info received from ContactFormActivity in the 7th step
    // TODO 10. Create a new method that invokes a Maps app, using as parameter the address included in the contact info received from ContactFormActivity in the 7th step
    // TODO 11. Create a new method that invokes an Email app, using as parameter the email address included in the contact info received from ContactFormActivity in the 7th step
    // TODO 12. Create a new method that invokes an Web Browser app, using as parameter the web url included in the contact info received from ContactFormActivity in the 7th step
}
