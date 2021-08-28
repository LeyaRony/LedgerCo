
/**
 * Write a description of class InputRead here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class LoanProcessor 
    {
        

    public void LoanProcessor()
    {

    }
    private Map<String, Loan> LoanMap = new HashMap<>();
    void addLoan(String bankName, String borrowerName, int principal, int noOfYears, int rateOfInterest) 
    {
        Loan loan = new Loan(bankName, borrowerName, principal, noOfYears, rateOfInterest);
        String identifier = getIdentifier(bankName, borrowerName);
        LoanMap.put(identifier, loan);
    }
    void  checkBalance(String bankName, String borrowerName, int EMI_NO) {
        String identifier = getIdentifier(bankName, borrowerName);
        Loan loan = getLoanInfo(identifier);
        if(loan!=null)
            processLoanBalance(loan, EMI_NO);
    }
    void  makePayment(String bankName, String borrowerName, int lumpSum, int EMI_NO) {
        String identifier = getIdentifier(bankName, borrowerName);
        Loan loan = getLoanInfo(identifier);
        if(loan!=null)
            loan.putLumpSumData(EMI_NO, lumpSum);
    }
    private Loan getLoanInfo(String identifier) {
        Loan loan = null;
        if (LoanMap.containsKey(identifier))
            loan = LoanMap.get(identifier);
        else {
            System.out.println(" No such loan exist error!!");
        }
        return loan;
    }
    String getIdentifier(String bankName, String borrowerName)
    {
        return bankName + ":" + borrowerName;
    }
    private void processLoanBalance(Loan loan, int EMI_NO) 
    {
        int totalMonths = loan.getNoOfYears() * 12;
        float interest = (loan.getPrinciple() * loan.getRateOfInterest() * loan.getNoOfYears()) / 100;
        float totalPayable = loan.getPrinciple() + interest;
        int monthlyEMI = (int) Math.ceil(totalPayable / totalMonths);
        int paid = EMI_NO * monthlyEMI;
        Map<Integer, Integer> lumpSumMap = loan.getLumpSumMap();

        for (Map.Entry lumpSumEntry : lumpSumMap.entrySet()) {
            int key = (int) lumpSumEntry.getKey();
            int value = (int) lumpSumEntry.getValue();

            if (key <= EMI_NO) {
                paid += value;
            } else {
                break;
            }
        }
        int amountRemaining = (int) Math.ceil(totalPayable - paid);
        int newTenureMonths = (int) Math.ceil((float) amountRemaining / monthlyEMI);
        int totalPayableInt = (int) Math.ceil(totalPayable);
        if (paid > totalPayableInt)
            paid = totalPayableInt;
        printOutput(loan.getBankName(), loan.getBorrowerName(), paid, newTenureMonths);
    }
    private void printOutput(String bankName, String borrowerName, int paid, int newTenureMonths) {
        System.out.println(bankName + " " + borrowerName + " " + paid + " " + newTenureMonths);
    }

}