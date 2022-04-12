package com.example.aprileleven;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int numDucks = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void upCLick (View v)
    {
        Toast.makeText(this, "You clicked the up button", Toast.LENGTH_SHORT).show();
        numDucks++;
        updateTextView();
    }

    public void downClick (View v)
    {
        Toast.makeText(this, "You clicked the down button", Toast.LENGTH_SHORT).show();
        numDucks--;
        updateTextView();
    }

    public void openDialog (View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Confirm reset count");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "YESIREEEE", Toast.LENGTH_SHORT).show();
                numDucks = 0;
                updateTextView();
            }
        });
        builder.setNegativeButton("No Way Jose!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog resetDialog = builder.create();
        resetDialog.show();
    }

    public void updateTextView()
    {
        TextView countTextView = (TextView) findViewById(R.id.countLabelView);
        countTextView.setText("Number of Ducks: " + numDucks);
    }
}