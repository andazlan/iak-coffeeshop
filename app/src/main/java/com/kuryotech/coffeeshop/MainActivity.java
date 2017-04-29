package com.kuryotech.coffeeshop;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity  {
    int qty = 0;
    TextView quantity, totalOrder;
    EditText name;
    CheckBox whippedCream, chocolate;
    Button plus, minus;



    private double total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.edt_name);
        quantity = (TextView) findViewById(R.id.txt_quantity);
        totalOrder = (TextView) findViewById(R.id.txt_show_order);
        whippedCream = (CheckBox) findViewById(R.id.chk_whipped_cream);
        chocolate = (CheckBox) findViewById(R.id.chk_chocolate);

        plus = (Button) findViewById(R.id.btn_plus);
        plus.setOnClickListener(plusClick);

        minus = (Button) findViewById(R.id.btn_minus);
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (qty == 0){
                    return;
                }

                qty--;
                quantity.setText(String.valueOf(qty));
            }
        });

        /*
        Order order = new Order();
        Log.d(MainActivity.class.getSimpleName(), order.getName());
        Log.d(MainActivity.class.getSimpleName(), String.valueOf(order.getQty()));
        Log.d(MainActivity.class.getSimpleName(), String.valueOf(order.isWhippedCream()));
        Log.d(MainActivity.class.getSimpleName(), String.valueOf(order.isChocolate()));
        */
    }

    private View.OnClickListener plusClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (qty >= 10) {
                Toast.makeText(MainActivity.this, "maksimal order 10", Toast.LENGTH_SHORT).show();
                return;
            }

            qty++;
            quantity.setText(String.valueOf(qty));
        }
    };

    public void showTotal(View view) {
        if (name.getText().toString().isEmpty()){
            Toast.makeText(this, "Nama ndak boleh kosong", Toast.LENGTH_SHORT).show();
            return;
        }

        if (quantity.getText().toString().equals("0")){
            Toast.makeText(this, "Quantity tidak bole 0", Toast.LENGTH_SHORT).show();
            return;
        }

        Order order = new Order(name.getText().toString(), qty,
                whippedCream.isChecked(), chocolate.isChecked());
        String keterangan = order.getKeterangan(this);
        totalOrder.setText(keterangan);

        /*
        double subTotal = qty * 10;
        double total = getTotal(subTotal, whippedCream.isChecked(), chocolate.isChecked());

        keterangan = keterangan + getString(R.string.label_whipped_cream) + " = 3";

        keterangan = keterangan + "\n" + getString(R.string.label_chocolate) + " = 4";

        keterangan = keterangan + "\n" + name.getText().toString() + " " + getString(R.string.label_order)
                + " : " + subTotal;

        keterangan = keterangan + "\n" + "Grand total : " + total;

        */


    }

    /*
    public double getTotal(double subTotal, boolean isWhippedCream, boolean isChocolate) {

        float total = (float) subTotal;

        if (isWhippedCream){
            total = total + 3;
        }

        if (isChocolate){
            total = total + 4;
        }

        return total;
    }
    */
}
