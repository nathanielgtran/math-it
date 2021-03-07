package au.edu.unsw.infs3634.MathIt;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class SummaryActivity extends AppCompatActivity {

    public static String SCORE_PERCENT_MESSAGE;
    public static String SCORE_MESSAGE;
    private Button again;
    private TextView score;
    private Button home;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        String finalScore = getIntent().getStringExtra(SCORE_MESSAGE);

        score = findViewById(R.id.tvScoreFinal);
        score.setText(finalScore);
        System.out.println(finalScore);
        Button again = findViewById(R.id.btnRestart);
        again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchDetailActivity();
            } //launch detail activity to play again
        });
        Button home = findViewById(R.id.btnHome);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchMainActivity();
            } //launch main activity to return home
        });
    }

    public void launchDetailActivity() {
        Intent intent = new Intent(SummaryActivity.this, DetailActivity.class);
        startActivity(intent);
    }

    public void launchMainActivity() {
        Intent intent = new Intent(SummaryActivity.this, MainActivity.class);
        startActivity(intent);
    }
}