package com.example.android.indiaquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;

/**
 * This app displays the score of quiz app.
 */
public class MainActivity extends AppCompatActivity {

    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * This method is called when the view score button is clicked.
     */
    public void submitOrder(View view) {
        //if the user select new delhi
        RadioButton radioButtonNameOfNewDelhi = (RadioButton) findViewById(R.id.NewDelhi);
        boolean hasNewDelhi = radioButtonNameOfNewDelhi.isChecked();

        // figure out if user type hindi
        EditText hindi = (EditText) findViewById(R.id.Language);
        String text = hindi.getText().toString();
        // Figure out if the user select seven
        CheckBox sevenCheckBox = (CheckBox) findViewById(R.id.Seven);
        boolean hasSeven = sevenCheckBox.isChecked();
        // figure out if the user select Twelve
        CheckBox twelveCheckBox = (CheckBox) findViewById(R.id.Twelve);
        boolean hasTwelve = twelveCheckBox.isChecked();
        // figure out if user select ninteen
        CheckBox NinteenCheckBox = (CheckBox) findViewById(R.id.Ninteen);
        boolean hasNinteen = NinteenCheckBox.isChecked();
        // figure out if user select Twentyone
        CheckBox TwentyoneCheckBox = (CheckBox) findViewById(R.id.Twentyone);
        boolean hasTwentyone = TwentyoneCheckBox.isChecked();

        // Figure out if the user select haryana
        CheckBox haryanaCheckBox = (CheckBox) findViewById(R.id.Haryana);
        boolean hasHaryana = haryanaCheckBox.isChecked();
        // figure out if the user select punjab
        CheckBox punjabCheckBox = (CheckBox) findViewById(R.id.Punjab);
        boolean hasPunjab = punjabCheckBox.isChecked();
        // figure out if the user select bihar
        CheckBox biharCheckBox = (CheckBox) findViewById(R.id.Bihar);
        boolean hasBihar = biharCheckBox.isChecked();
        // figure out if the user select west bengal
        CheckBox westbengalCheckBox = (CheckBox) findViewById(R.id.Westbengal);
        boolean hasWestbengal = westbengalCheckBox.isChecked();

        //if user select panaji
        RadioButton radioButtonNameOfPanaji = (RadioButton) findViewById(R.id.panaji);
        boolean hasPanaji = radioButtonNameOfPanaji.isChecked();

        //if user select jammu and kashmir
        RadioButton radioButtonNameOfJammu = (RadioButton) findViewById(R.id.jammu);
        boolean hasJammu = radioButtonNameOfJammu.isChecked();

        // Display the score summary on the screen
        int score = calculateScore(text, hasSeven, hasTwelve, hasNinteen, hasTwentyone, hasHaryana, hasPunjab, hasBihar, hasWestbengal, hasNewDelhi, hasPanaji, hasJammu);
        String scoreMessage = createOrderSummary(score, text, hasSeven, hasTwelve, hasNinteen, hasTwentyone, hasHaryana, hasPunjab, hasBihar, hasWestbengal, hasNewDelhi, hasPanaji, hasJammu);
        displayMessage(scoreMessage);
    }

    /**
     * Calculates the score of the quiz.
     * @param addSeven is wheather or not the user select seven
     * @param addHaryana and addPunjab is wheather or not the user select both haryana and punjab
     * @return final score
     */
    private int calculateScore(String textField, boolean addSeven, boolean addTwelve, boolean addNinteen, boolean addTwentyone, boolean addHaryana, boolean addPunjab, boolean addBihar, boolean addWestbengal, boolean addNewDelhi, boolean addpanaji, boolean addJammu ) {
        score = 0; /* reset score */
        /** define the variables that hold the answers */

        // hindi
        if (textField.equals("Hindi") || textField.equals("hindi")){
            score = score + 1;
        }else {
            // Do Nothing
        }
        if (addNewDelhi) {
            score = score + 1;
        }else {
            //Do Nothing
        }
        //add one if the user select seven,twelve,ninteen and twenty one
        if (addSeven && addTwelve && addNinteen && addTwentyone) {
            score = score + 1;
        }else{
            //do nothing
        }
        //add one if the user select haryana,punjab,bihar and west bengal
        if (addHaryana && addPunjab && addBihar && addWestbengal) {
            score = score + 1;
        }else {
            //Do Nothing
        }
        //add one if the user select panaji
        if (addpanaji) {
            score = score + 1;
        }else {
            //Do Nothing
        }
        //add one if the user select jammu and kashmir
        if (addJammu) {
            score = score + 1;
        }else {
            //Do Nothing
        }
        //calculate the total score by multiplying by number
        return score + score;
    }

    /**
     * Create summary of the order.
     *
     * @param score summary of the quiz app
     * @return text summary
     */
    private String createOrderSummary(int score, String textField,  boolean addSeven, boolean addTwelve, boolean addNinteen, boolean addTwentyone, boolean addHaryana, boolean addPunjab, boolean addBihar, boolean addWestbengal, boolean addNewDelhi, boolean addPanaji, boolean addJammu) {
        String scoreMessage = "Thank you";
    return scoreMessage;

    }
    /**
     * This method displays the given text on the screen.
     */

    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);

        Context context = getApplicationContext();
        CharSequence text =" Your Score " + score + " out of 6 ";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

}

