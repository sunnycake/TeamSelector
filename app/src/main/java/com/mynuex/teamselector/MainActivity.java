package com.mynuex.teamselector;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private EditText teamOneText;
    private EditText teamTwoText;
    private Button selectButton;
    private TextView resultView;

    ArrayList<String> teamList = new ArrayList<>();

    Random r = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        teamOneText = findViewById(R.id.team_one);
        teamTwoText = findViewById(R.id.team_two);
        resultView = findViewById(R.id.result_view);
        selectButton = findViewById(R.id.select_button);

        selectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Checking if team name's are empty
                if (teamOneText.getText().toString().length() <=0 || teamTwoText.getText().toString().length() <=0 ) {
                    Toast.makeText(MainActivity.this, "Enter a team name.", Toast.LENGTH_LONG).show();
                }
                //Getting team name and
                String teamOneInput = teamOneText.getText().toString();
                String teamTwoInput = teamTwoText.getText().toString();
                //storing to arraylist
                teamList.add(teamOneInput);
                teamList.add(teamTwoInput);
                // Displaying results
                resultView.setText(teamList.get(r.nextInt(teamList.size())));

            }
        });
    }
}
