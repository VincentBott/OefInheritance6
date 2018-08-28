package com.company;

import java.util.ArrayList;
import java.util.Objects;


public class BankMain {

    public static void main(String[] args) {

        Bank bank = new Bank();

        String[] rekeningnummers = {"000-0000011-11", "000-0000022-22", "000-0000033-33"};

        for(String rekeningnummer: rekeningnummers){

            bank.addRekening(new BankRekening(rekeningnummer));
        }

        System.out.println("Probeer dubbele rekening toe te voegen:");

        try{
            bank.addRekening(new BankRekening(rekeningnummers[0]));

        } catch (IllegalArgumentException ex){

            System.out.println(ex.getMessage());
        }

        //for(BankRekening bankrek: bank){
        //    System.out.println(bankrek.getRekeningnummer());
        //}
    }
}


class Bank {

    private ArrayList<BankRekening> rekeningen = new ArrayList<>();

    public void addRekening(BankRekening rekening){

        if (bestaatBankRekening(rekening))

            throw new IllegalArgumentException(String.format("Rekening %s bestaat al", rekening.getRekeningnummer()));
        rekeningen.add(rekening);

    }

    public boolean bestaatBankRekening(BankRekening rekening){
        return rekeningen.contains(rekening);
    }

}


class BankRekening extends Bank {

    private String rekeningnummer;


    public BankRekening(String rekeningnummer) {

        this.rekeningnummer = rekeningnummer;
    }

    public String getRekeningnummer() {

        return this.rekeningnummer;
    }




}

