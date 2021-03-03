package au.edu.unsw.infs3634.covidtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button myButton = (Button) findViewById(R.id.button); // created an instance of the Button class, by accessing the relevant element in our layout

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    launchDetailActivity("40735414-f500-4ba6-a05f-375fb7e93db8");
            }
        });
    }
    public void launchDetailActivity(String message) {
        Intent intent = new Intent (MainActivity.this, DetailActivity.class);
        intent.putExtra(DetailActivity.INTENT_MESSAGE, message);
        startActivity(intent);
    }
}