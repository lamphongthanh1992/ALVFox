package com.basic.utils;

import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class TextUtils {
	public String convertText(double price) {
      Locale locale = new Locale("vi", "VN");
      Currency currency = Currency.getInstance("VND");

      DecimalFormatSymbols df = DecimalFormatSymbols.getInstance(locale);
      df.setCurrency(currency);
      NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
      numberFormat.setCurrency(currency);
      //System.out.println(numberFormat.format(20000000));
      //System.out.println(numberFormat.format(price));
     
		return numberFormat.format(price);
	}
}
