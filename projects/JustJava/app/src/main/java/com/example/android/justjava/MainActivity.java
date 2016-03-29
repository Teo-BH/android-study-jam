package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private int quantity = 2;

    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        if (quantity < 100) {
            quantity++;
            display(quantity);
        } else {
            String txt = getResources().getString(R.string.CannotHaveMore100Coffees);
            Toast toast = Toast.makeText(getApplicationContext(), txt, Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        if (quantity > 1) {
            quantity--;
            display(quantity);
        } else {
            String txt = getResources().getString(R.string.CannotHaveLess1Coffee);
            Toast toast = Toast.makeText(getApplicationContext(), txt, Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        // Name
        EditText nameEditText = (EditText)findViewById(R.id.name_field);
        String name = nameEditText.getText().toString();
        Log.v("MainActivity", "Name " + name);

        // Whipped Cream Topping
        CheckBox whippedCreamCheckBox = (CheckBox)findViewById(R.id.whipped_cream_check_box);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        Log.v("MainActivity", "Has whipped cream " + hasWhippedCream);

        // Whipped Cream Topping
        CheckBox chocolateCheckBox = (CheckBox)findViewById(R.id.chocolate_check_box);
        boolean hasChocolate = chocolateCheckBox.isChecked();
        Log.v("MainActivity", "Has chocolate " + hasChocolate);

        int price = calculatePrice(hasWhippedCream, hasChocolate);
        String priceMessage = this.createOrderSummary(name, price, hasWhippedCream, hasChocolate);
        String subject = String.format(getResources().getString(R.string.email_subject), name);
        composeEmail(subject, priceMessage);
    }

    /**
     * Calculates the price of the order.
     *
     * @param addWhippedCream is whether or not the user wants whipped cream topping
     * @param addChocolate is whether or not the user wants chocolate topping
     * @return total price
     */
    private int calculatePrice(boolean addWhippedCream, boolean addChocolate) {
        int basePrice = 5;
        if (addWhippedCream) {
            basePrice += 1;
        }
        if (addChocolate) {
            basePrice += 2;
        }

        basePrice *= quantity;

        return basePrice;
    }

    private String createOrderSummary(String name, int price, boolean addWhippedCream, boolean addChocolate) {
        String txt = getResources().getString(R.string.email_body);
        String result = String.format(txt, name, addWhippedCream, addChocolate, quantity, price);
        return result;
    }

    public void composeEmail(String subject, String body) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, body);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
}