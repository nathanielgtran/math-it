package au.edu.unsw.infs3634.covidtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    public static final String INTENT_MESSAGE = "au.edu.unsw.infs3634.covidtracker.intent_message";
    ;

    private TextView mCountry ;
    private TextView  mNewCases;
    private TextView  mTotalCases;
    private TextView  mNewDeaths;
    private TextView  mTotalDeaths;
    private TextView  mNewRecovered;
    private TextView  mTotalRecovered;
    private Button  mSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mCountry = findViewById(R.id.tvCountry);
        mNewCases = findViewById(R.id.tvNewCasesDesc);
        mTotalCases = findViewById(R.id.tvTotalCasesDesc);
        mNewDeaths = findViewById(R.id.tvNewCasesDesc);
        mTotalDeaths = findViewById(R.id.tvTotalDeathsDesc);
        mNewRecovered = findViewById(R.id.tvNewRecoverdDesc);
        mTotalCases = findViewById(R.id.tvTotalCases);
        mTotalRecovered = findViewById(R.id.tvTotalRecovered);
        mSearch = findViewById(R.id.bSearch);

        Intent intent = getIntent();
        String id = getIntent().getStringExtra(INTENT_MESSAGE);

        Country country = Country.getCountry(id);
        if(country != null) {
            setTitle(country.getCountryCode());
            mCountry.setText(country.getCountry());
            mNewCases.setText(country.getCountry());
            mTotalCases.setText(country.getCountry());
            mNewDeaths.setText(country.getCountry());
            mTotalDeaths.setText(country.getCountry());
            mNewRecovered.setText(country.getCountry());
            mTotalRecovered.setText(country.getCountry());
            mSearch.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){ searchCountryYT(country.getCountry());}
            });
        }

    }
    private void searchCountryYT(String country) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=covid " + country));
        startActivity(intent);

    }
}

