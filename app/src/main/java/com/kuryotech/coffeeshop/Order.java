package com.kuryotech.coffeeshop;

import android.content.Context;

/**
 * Created by azlan on 4/29/17.
 */

public class Order {
    public static int PRICE = 10;
    public static int WHIPPED_CREAM_PRICE = 4;
    public static int CHOCOLATE_PRICE = 3;

    private String mName;
    private int mQty;
    private boolean mWhippedCream, mChocolate;

    // default constructor
    public Order() {
        this.mName = "no name";
        this.mQty = 0;
        this.mWhippedCream = false;
        this.mChocolate = false;
    }

    public Order(String name, int qty) {
        this.mName = name;
        this.mQty = qty;
        this.mWhippedCream = false;
        this.mChocolate = false;
    }

    public Order(String name, int qty, boolean whippedCream, boolean chocolate) {
        this.mName = name;
        this.mQty = qty;
        this.mWhippedCream = whippedCream;
        this.mChocolate = chocolate;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public int getQty() {
        return mQty;
    }

    public void setQty(int mQty) {
        this.mQty = mQty;
    }

    public boolean isWhippedCream() {
        return mWhippedCream;
    }

    public void setWhippedCream(boolean mWhippedCream) {
        this.mWhippedCream = mWhippedCream;
    }

    public boolean isChocolate() {
        return mChocolate;
    }

    public void setChocolate(boolean mChocolate) {
        this.mChocolate = mChocolate;
    }

    /**
     * method untuk menghitung sub total yang hasilnya dikembalikan
     * @return double subtotal
     */

    public double getSubTotal(){
        if (mQty == 0){
            return 0;
        }
        return mQty * PRICE;
    }

    /**
     * method untuk menghitung total yang hasilnya dikembalikan
     * @return double total
     */
    public double getTotal(){
        double total = getSubTotal();
        if (isWhippedCream()){
            total = total + WHIPPED_CREAM_PRICE;
        }

        if (isChocolate()){
            total = total + CHOCOLATE_PRICE;
        }
        return total;
    }

    /*
    Getter buat mangambil keterangan
     */
    public String getKeterangan(Context context){
        String keterangan = "";
        if (this.isWhippedCream()) {
            keterangan = keterangan + context.getString(R.string.label_whipped_cream) + " = " + WHIPPED_CREAM_PRICE;
        }

        if (this.isChocolate()) {
            keterangan = keterangan + "\n" + context.getString(R.string.label_chocolate) + " = " + CHOCOLATE_PRICE;
        }

        keterangan = keterangan + "\n" + this.getName() + " " + context.getString(R.string.label_order)
                + " : " + this.getSubTotal();

        keterangan = keterangan + "\n" + "Grand total : " + this.getTotal();
        return keterangan;
    }
}
