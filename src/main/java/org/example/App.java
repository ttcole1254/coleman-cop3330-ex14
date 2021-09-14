package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/*
 *  UCF COP3330 Fall 2021 Assignment 14 Solution
 *  Copyright 2021 Tyler Coleman
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner in = new Scanner(System.in);
        System.out.println("What is the order amount? ");
        String orderAmountS = in.nextLine();
        System.out.println("What is the state? ");
        String state = in.nextLine();
        double orderAmount = Double.parseDouble(orderAmountS);
        double taxRate = 0.0;
        if (state.equals("WI")) {
            taxRate = 0.055;
        }
        double tax = orderAmount * taxRate;
        double total = orderAmount + tax;
        BigDecimal result = new BigDecimal(total).setScale(3, RoundingMode.HALF_UP);
        NumberFormat usdCostFormat = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.printf("The subtotal is $%.02f.\nThe tax is $%.02f.\nThe total is %s.", orderAmount, tax, usdCostFormat.format(result.doubleValue()));
    }
}
