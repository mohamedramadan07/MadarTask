package com.example.madar;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.madar.data.SavedData;

public class DataEntry extends AppCompatActivity {

    private EditText mEditName = null;
    private EditText mEditAge = null;
    private EditText mEditJobTitle = null;
    private RadioButton mBtnGender = null;
    private SavedData savedData;
    private Button saveBtn;
    private String gender;

    public static final String EXTRA_REPLY = "com.example.android.wordlistsql.REPLY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_entry);
        mEditName = findViewById(R.id.name);
        mEditAge = findViewById(R.id.age);
        mEditJobTitle = findViewById(R.id.job_title);
        mBtnGender = findViewById(R.id.gender);


        saveBtn = findViewById(R.id.save_btn);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(mEditName.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    gender = "Female";
                    if(mBtnGender.isChecked()) {
                        gender = "Male";
                    }
                    savedData = new SavedData(mEditName.getText().toString()
                            ,Integer.valueOf(mEditAge.getText().toString()),mEditJobTitle.getText().toString()
                            ,gender);
                    replyIntent.putExtra(EXTRA_REPLY, savedData);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }
}
