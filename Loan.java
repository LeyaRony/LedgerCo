package com.geektrust.theledgerco;

import java.util.Map;
import java.util.TreeMap;

class Loan {
    private String BANK_NAME;
    private String BORROWER_NAME;
    private int PRINCIPAL;
    private int NO_OF_YEARS;
    private int RATE_OF_INTEREST;
    private Map<Integer, Integer> LUMP_SUM_AMOUNTMap;

    Loan(String BANK_NAME, String BORROWER_NAME, int PRINCIPAL, int NO_OF_YEARS, int RATE_OF_INTEREST)
    {
        this. BANK_NAME =  BANK_NAME;
        this.BORROWER_NAME = BORROWER_NAME;
        this.PRINCIPAL = PRINCIPAL;
        this.NO_OF_YEARS = NO_OF_YEARS;
        this.RATE_OF_INTEREST = RATE_OF_INTEREST;
        this.LUMP_SUM_AMOUNTMap = new TreeMap<>();
    }


    int getYears()
    {
        return this.NO_OF_YEARS;
    }

  
    int getPrincipal() {
        return this.PRINCIPAL;
    }

    int getRateOfInterest() {
        return this.RATE_OF_INTEREST;
    }

    
    String getBankName() {
        return this.BANK_NAME;
    }

    
    String getPersonName() {
        return this.BORROWER_NAME;
    }

    
    Map<Integer, Integer> getLumpSumMap() {
        return this.LUMP_SUM_AMOUNTMap;
    }

   
    void putLumpSumData(int EMI, int LUMP_SUM_AMOUNT) {
        if (this.LUMP_SUM_AMOUNTMap.containsKey(EMI)) {
            this.LUMP_SUM_AMOUNTMap.put(EMI, this.LUMP_SUM_AMOUNTMap.get(EMI) + LUMP_SUM_AMOUNT);
        } else
        {
            this.LUMP_SUM_AMOUNTMap.put(EMI, LUMP_SUM_AMOUNT);
        }
    }
}
