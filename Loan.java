import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class Loan 
{
    private String bankName;
    private String borrowerName;
    private int principal;
    private int noOfYears;
    private int rateOfInterest;
    private Map<Integer, Integer> lumpSumMap;
    Loan(String bankName, String borrowerName, int principal, int noOfYears, int rateOfInterest)
    {
        this.bankName = bankName;
        this.borrowerName = borrowerName;
        this.principal = principal;
        this.noOfYears = noOfYears;
        this.rateOfInterest = rateOfInterest;
        this.lumpSumMap = new TreeMap<>();
    }
    int getNoOfYears() {
        return this.noOfYears;
    }
    int getPrinciple() {
        return this.principal;
    }
    int getRateOfInterest() {
        return this.rateOfInterest;
    }

    String getBankName() {
        return this.bankName;
    }

    String getBorrowerName() {
        return this.borrowerName;
    }

    Map<Integer, Integer> getLumpSumMap() {
        return this.lumpSumMap;
    }

    void putLumpSumData(int EMI, int lumpSum) {
        if (this.lumpSumMap.containsKey(EMI)) {
            this.lumpSumMap.put(EMI, this.lumpSumMap.get(EMI) + lumpSum);
        } else {
            this.lumpSumMap.put(EMI, lumpSum);
        }
    }
}
