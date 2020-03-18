package com.nisith.calculatelove;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private EditText maleNmaeET,femaleNameET;
    private TextView resultTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        Toolbar appToolbar = findViewById(R.id.app_toolbar);
        setSupportActionBar(appToolbar);

        maleNmaeET = findViewById(R.id.male_name_edit_text);
        femaleNameET = findViewById(R.id.female_name_edit_text);
        Button calculateLoveButton = findViewById(R.id.calculate_love);
        resultTV = findViewById(R.id.text_view);
        maleNmaeET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                resultTV.setText("");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        femaleNameET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                resultTV.setText("");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        calculateLoveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maleNmaeString = maleNmaeET.getText().toString();
                String femaleNameString = femaleNameET.getText().toString();
                if (maleNmaeString.length()==0){
                    Toast.makeText(getApplicationContext(),"Enter Male Name",Toast.LENGTH_SHORT).show();

                }else if (femaleNameString.length()==0){
                    Toast.makeText(getApplicationContext(),"Enter Female Name",Toast.LENGTH_SHORT).show();
                }else {

                    Calendar calendar = Calendar.getInstance();
                    String day = "" + calendar.get(Calendar.DAY_OF_MONTH);
                    String month = "" + calendar.get(Calendar.MONTH);
                    String year = "" + calendar.get(Calendar.YEAR);
                    String concatinateString = maleNmaeString + femaleNameString + day + month + year;
                    concatinateString = concatinateString.toLowerCase();
                    int hashCode = concatinateString.hashCode();
                    Random random = new Random(hashCode);
                    int randomNumber = random.nextInt(101);
                    resultTV.setText(randomNumber + " %");
                }

            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.app_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.about_app:
                Toast.makeText(this, "About App", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
