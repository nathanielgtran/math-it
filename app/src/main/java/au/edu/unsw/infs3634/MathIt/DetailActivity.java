package au.edu.unsw.infs3634.MathIt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.Timer;
import java.util.TimerTask;

public class DetailActivity extends AppCompatActivity {

    int min = 0;
    int max = 100;
    int minOp = 1;
    int maxOp = 4;
    double math = 0;
    int score = 0;
    double mathResult;
    int totalScore = 0;

    private EditText answer;
    private TextView edit;
    View screenView;
    ProgressBar progressBar;
    int counter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        timer();
        changeNumbers();
        endTimer();
        answer = findViewById(R.id.tvAnswer);
        Button checkButton = findViewById(R.id.btnCheck);
        final TextView edit = findViewById(R.id.tvOutput);


        answer.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) { //used to enable keyboard enter as button click
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    checkButton.performClick();
                    return true;
                }
                return false;
            }
        });

    }

    public void timer() { //create timer that shows how long user has left
        progressBar = findViewById(R.id.progressbar);
        final Timer t = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                counter++;
                progressBar.setProgress(counter);
                if (counter == 100)
                    t.cancel();
            }
        };
        t.schedule(tt, 0, 600);

    }

    public void endTimer() { //when timer ends after 60secs moves on to new activity


        new Handler().postDelayed(new Runnable() {

            public void run() {

                Intent intent = new Intent(DetailActivity.this, SummaryActivity.class);
                startActivity(intent);
                sendScore(score + "/" + totalScore);

            }
        }, 60000); //CHANGE

    }

    public void sendScore(String message) { //sends a message intent to SummaryActivity w score
        System.out.println(score + "/" + totalScore);
        Intent intent = new Intent(DetailActivity.this, SummaryActivity.class);
        intent.putExtra(SummaryActivity.SCORE_MESSAGE, message);
        startActivity(intent);
    }

    private void changeNumbers() { //generates new random numbers and operator for game
        final TextView num1 = findViewById(R.id.tvNum1);
        final TextView num2 = findViewById(R.id.tvNum2);
        final TextView operation = findViewById(R.id.tvOperator);
        Button checkButton = findViewById(R.id.btnCheck);
        final TextView edit = findViewById(R.id.tvOutput);
        TextView tvScore = findViewById(R.id.tvScore);
        screenView = findViewById(R.id.rView);

        double random_int1 = (int) (Math.random() * (max - min + 1) + min); //generating number 1
        double random_int2 = (int) (Math.random() * (max - min + 1) + min); //generating number 2
        int randomOp = (int) (Math.random() * (maxOp - minOp + 1) + min); //generating operator
        String operator = "+";

        if (randomOp == 0) { //convert operating into string
            operator = "+";
        } else if (randomOp == 1) {
            operator = "-";
        } else if (randomOp == 2) {
            operator = "X";
        } else if (randomOp == 3) {
            operator = "/";
        }
        num1.setText(String.valueOf(random_int1));
        num2.setText(String.valueOf(random_int2));
        operation.setText(operator);

        if (randomOp == 0) {
            math = random_int1 + random_int2;
        } else if (randomOp == 1) {
            math = random_int1 - random_int2;
        } else if (randomOp == 2) {
            math = random_int1 * random_int2;
        } else if (randomOp == 3) {
            math = random_int1 / random_int2;
        }
        double mathResult = (double) Math.round(math * 100) / 100; //ensuring that all answers are 2.dp

        int rand1 = (int) random_int1;
        int rand2 = (int) random_int2;

        num1.setText(String.valueOf(rand1));
        num2.setText(String.valueOf(rand2));


        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //onclick method that applies random number and operator


                double mathResult = (double) Math.round(math * 100) / 100;

                if (answer.getText().toString().length() == 0) { //check if field is empty
                    edit.setText("OOPS!");

                    edit.setTextColor(Color.parseColor("#f52c3c"));

                    new Handler().postDelayed(new Runnable() {

                        public void run() {
                            edit.setTextColor(Color.parseColor("#FFFFFF"));
                            edit.setText("");


                        }
                    }, 1500);
                } else {
                    totalScore++;
                    double numAnswer = Double.parseDouble(answer.getText().toString());


                    String output;
                    double numAnswerRounded = (double) Math.round(numAnswer * 100) / 100;
                    if (numAnswerRounded == mathResult) {
                        output = "correct";
                    } else {
                        output = "incorrect";
                    }
                    System.out.println("Answer " + numAnswer);
                    System.out.println("math " + mathResult);


                    double random_int1 = (int) (Math.random() * (max - min + 1) + min);
                    double random_int2 = (int) (Math.random() * (max - min + 1) + min);
                    int randomOp = (int) (Math.random() * (maxOp - minOp + 1) + min);
                    String operator = "+";
                    if (randomOp == 0) {
                        operator = "+";
                    } else if (randomOp == 1) {
                        operator = "-";
                    } else if (randomOp == 2) {
                        operator = "X";
                    } else if (randomOp == 3) {
                        operator = "/";
                    }

                    if (randomOp == 0) {
                        math = random_int1 + random_int2;
                    } else if (randomOp == 1) {
                        math = random_int1 - random_int2;
                    } else if (randomOp == 2) {
                        math = random_int1 * random_int2;
                    } else if (randomOp == 3) {
                        math = random_int1 / random_int2;
                    }


                    int rand1 = (int) random_int1;
                    int rand2 = (int) random_int2;

                    System.out.println(mathResult);
                    num1.setText(String.valueOf(rand1));
                    num2.setText(String.valueOf(rand2));
                    operation.setText(operator);
                    edit.setText(output);


                    if (output == "correct") { //generating outputs + some effects
                        score++;
                        edit.setText(output);
                        edit.setTextColor(Color.parseColor("#3ab855"));

                        new Handler().postDelayed(new Runnable() {

                            public void run() {
                                edit.setTextColor(Color.parseColor("#FFFFFF"));
                                edit.setText("");

                            }
                        }, 1500);

                        answer.getText().clear();

                    } else {
                        edit.setText(output);
                        edit.setTextColor(Color.parseColor("#f52c3c"));

                        new Handler().postDelayed(new Runnable() {

                            public void run() {
                                edit.setTextColor(Color.parseColor("#FFFFFF"));
                                edit.setText("");
                            }
                        }, 1500);
                    }

                    String scoreOutput = (score + "/" + totalScore);
                    tvScore.setText(scoreOutput);
                    answer.getText().clear();


                }
            }
        });
    }


}

