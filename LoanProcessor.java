

import java.util.HashMap;
import java.util.Map;

class LedgCo 
{

	LedgCo() 
	{

    }

    public void addLoan(String BANK_NAME, String BORROWER_NAME, int PRINCIPAL, int NO_OF_YEARS, int RATE_OF_INTEREST) 
    {
        Loan loan = new Loan(BANK_NAME, BORROWER_NAME, PRINCIPAL, NO_OF_YEARS, RATE_OF_INTEREST);
        String identifier = getIdentifier(BANK_NAME,BORROWER_NAME);
        LoanMap.put(identifier, loan);
    }

    public void makePayment(String BANK_NAME, String BORROWER_NAME, int LUMP_SUM_AMOUNT, int EMI_NO) {
        String identifier = getIdentifier(BANK_NAME,BORROWER_NAME);
        Loan loan = getLoanInfo(identifier);
        if(loan!=null)
            loan.putLumpSumData(EMI_NO, LUMP_SUM_AMOUNT);
    }
    }
     
   public void checkBalance(String BANK_NAME, String BORROWER_NAME, int EMI_NO)
   {
        String identifier = getIdentifier(BANK_NAME, BORROWER_NAME);
        Loan loan = getLoanInfo(identifier);
        if(loan!=null)
            processLoanBalance(loan, EMI_NO);
    }

    
    public Loan getLoanInfo(String identifier)
    {
        Loan loan = null;
        if (LoanMap.containsKey(identifier))
            loan = LoanMap.get(identifier);
        else 
        {
            System.out.println(" No such loan exist error!!");
        }
        return loan;
    }

    
    String getIdentifier(String BANK_NAME, String BORROWER_NAME)
    {
        return BANK_NAME + ":" + BORROWER_NAME;
    }

        public void processLoanBalance(Loan loan, int EMI_NO) 
        {
        int TotalMonths = loan.getNO_OF_YEARS() * 12;
        float I = (loan.getPRINCIPAL() * loan.getRATE_OF_INTEREST() * loan.getNO_OF_YEARS()) / 100;
        float A = loan.getPRINCIPAL() + I;
        int MonthlyEMI = (int) Math.ceil(A / TotalMonths);
        int paid = EMI_NO * MonthlyEMI;
        Map<Integer, Integer> lumpSumMap = loan.getLumpSumMap();

        for (Map.Entry lumpSumEntry : lumpSumMap.entrySet()) {
            int key = (int) lumpSumEntry.getKey();
            int value = (int) lumpSumEntry.getValue();

            if (key <= EMI) {
                paid += value;
            } 
            else 
            {
                break;
            }
        }
        int amountRemaining = (int) Math.ceil(A - paid);
        int newTenureMonths = (int) Math.ceil((float) amountRemaining / MonthlyEMI);
        int totalPayableInt = (int) Math.ceil(totalPayable);
        if (paid > totalPayableInt)
            paid = totalPayableInt;
        printOutput(loan.getBANK_NAME(), loan.getBORROWER_NAME(), paid, newTenureMonths);
    }

   
    public void Output(String BANK_NAME, String BORROWER_NAME, int paid, int newTenureMonths) 
    {
        System.out.println(BANK_NAME + " " + BORROWER_NAME + " " + paid + " " + newTenureMonths);
    }

}
