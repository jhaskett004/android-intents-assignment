package edu.ualr.intentsassignment;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import edu.ualr.intentsassignment.databinding.CfaLayoutBinding;
import com.google.android.material.button.MaterialButton;


public class ContactFormActivity extends AppCompatActivity {
    //TODO 2. Define the basic skeleton of the ContactFormActivity. Inflate the layout defined in the first step to display the GUI elements on screen.

    private CfaLayoutBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = CfaLayoutBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
    }

    public void onButtonClick(View view) {
        Intent intent = new Intent(this, ContactInfoActivity.class);
    }




    // TODO 06. Create a new method that reads the values in the several EditText elements of the layout and then uses the Contact class to send those data to ContactInfoActivity
}
