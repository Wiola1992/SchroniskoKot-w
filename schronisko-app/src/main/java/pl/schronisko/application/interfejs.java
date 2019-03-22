/*
 * Decompiled with CFR 0_123.
 * 
 * Could not load the following classes:
 *  kot.cat
 *  kot.kotDAO
 */
package pl.schronisko.application;

import java.io.InputStream;
import java.io.PrintStream;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import pl.schronisko.domain.cat;

public class interfejs {
    static Scanner s1 = new Scanner(System.in);

    public static String getUsserInput() {
        return s1.nextLine().trim();
    }

    /* public static void viewMenu() {
        System.out.println("Witaj na portalu schronisko");
        System.out.println("Nacisnij: ");
        System.out.println("1 - dodaj nowego kotka");
        System.out.println("2 - obejrzyj wszystkie koty");
        System.out.println("x - zakoncz program");
    }

    public static void main(String[] args) {
        String choice;
        do {
            interfejs.viewMenu();
            choice = interfejs.getUsserInput();
           if (choice.equalsIgnoreCase("1")) {
                interfejs.dodajKotka();
                continue;
            }
            if (choice.equalsIgnoreCase("2")) {
                //interfejs.pokazKoty();
                continue;
            }
            if (!choice.equalsIgnoreCase("z")) continue;
            System.out.println("koniec?");
        } while (!choice.equalsIgnoreCase("x"));
    } */

 /*   public static void dodajKotka() {
        cat c2 = new cat();
        System.out.println("Podaj imie kota i jego opiekuna");
        c2.setName(interfejs.getUsserInput());
        c2.setGuardian(interfejs.getUsserInput());
        c2.przedstawSie();
        System.out.println("podaj date urodzenia " + c2.getName() + " w formacie rrrr.mm.dd np. 2000.05.30 ");
        Pattern datePattern = Pattern.compile("[0-9]{4}\\.[01]?[0-9]\\.[0-3]?[0-9]");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        do {
            boolean dateP;
            String dataWczytana;
            Matcher dateMatcher;
            if (dateP = (dateMatcher = datePattern.matcher(dataWczytana = interfejs.getUsserInput())).matches()) {
                try {
                    c2.setDateOfBirth((Date) sdf.parse(dataWczytana));
                }
                catch (ParseException pe) {
                    System.out.println("Co\u015b jest nie tak z formatem daty!");
                }
                continue;
            }
            System.out.println("Co\u015b jest nie tak z formatem daty! Sprobuj jeszcze raz. (rrrr.mm.dd np. 2000.05.30) ");
        } while (c2.getDateOfBirth() == null);
        System.out.println(String.valueOf(c2.getName()) + " urodzil si\u0119 " + c2.getDateOfBirth());
        System.out.println("a teraz podaj wage");
        Pattern weightPattern = Pattern.compile("[0-9]?[0-9]\\,?\\.?[0-9]?");
        while (c2.getWeight() == 0.0) {
            String wprowadzonaWaga = interfejs.getUsserInput();
            Matcher weightMatcher = weightPattern.matcher(wprowadzonaWaga);
            boolean weightB = weightMatcher.matches();
            if (weightB) {
                try {
                    c2.setWeight(Double.valueOf(wprowadzonaWaga).doubleValue());
                }
                catch (NumberFormatException nfe) {
                    System.out.println("Zly format, waga np. 5.0 kg ");
                }
                continue;
            }
            System.out.println("Co\u015b jest nie tak z formatem! Sprobuj jeszcze raz, waga musi by\u0107 liczb\u0105 np 9,2  ");
        }
        c2.przedstawSie();
    }
*/
 

  
}
