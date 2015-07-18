package com.theoneandonly.saigatram.helloworld;

import android.nfc.Tag;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity  {
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RelativeLayout touch = (RelativeLayout) findViewById(R.id.touch);
        final TextView quoteText = (TextView) findViewById(R.id.quote);
        final TextView personText = (TextView) findViewById(R.id.person);

        final ArrayList<Quote> quoteList = new ArrayList<Quote>();

        Quote quote4 = new Quote("You're more of a fun vampire. You don't suck blood, you just suck.", "Troy Barnes");
        quoteList.add(quote4);

        Quote quote1 = new Quote("Cool Beans", "Rod Kimble");
        quoteList.add(quote1);

        Quote quote2 = new Quote("How can mirrors be real if our eyes aren't real", "Jaden Smith");
        quoteList.add(quote2);

        Quote quote3 = new Quote("That's like me blaming owls for how bad I suck at analogies.", "Britta Perry");
        quoteList.add(quote3);

        Quote quote5 = new Quote("I was gonna be the first person in my family to graduate from community college. Everyone else graduated from normal college", "Troy Barnes");
        quoteList.add(quote5);

        //Add more quotes here


        touch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (count < quoteList.size()) {

                    Quote q = quoteList.get(count);

                    quoteText.setText(q.getQuote());

                    personText.setText(q.getPerson());

                    count = count + 1;


                } else{

                    count = 0;

                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private EditText zipCode;
    private TextView textOut;


    public void buttonOnClick(View first)
    {
        final Button button = (Button) first;
        zipCode = (EditText) findViewById(R.id.zipCode);
        textOut = (TextView) findViewById(R.id.zipOutput);
        textOut.setText("Your Zip Code is: " + zipCode.getText());
        ((Button) first).setText("Made by Sai Gatram");
    }

}