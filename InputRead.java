
/**
 * Write a description of class InputRead here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
class InputRead
 {
    public static void main(String[] args) 
    {
        InputRead bank = new InputRead();

        
        BufferedReader reader ;
        try {
            reader = new BufferedReader(new FileReader("Ledg.txt")); //input file//
            String line;
            while ((line = reader.readLine()) != null) 
            {
                System.out.println(line);
              
                
            }
            reader.close();
        } 
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
public enum RequestType
    {
    BALANCE, LOAN, PAYMENT;
    }
    public void handle(String request)
    {
        final String[] details = request.split(" ");
        RequestType Details = RequestType.valueOf(details[0]);
        switch (Details) 
        {
            case LOAN:
                String bankName = details[1];
                String borrowerName = details[2];
                Integer principal = Integer.parseInt(details[3]);
                Integer noOfYears = Integer.parseInt(details[4]);
                Integer rateOfInterest = Integer.parseInt(details[5]);
                LoanProcessor.addLoan(bankName ,borrowerName,principal, noOfYears, rateOfInterest);
                break;
            case PAYMENT:
                int lumpSum = Integer.parseInt(details[3]);
                int EMI_NO = Integer.parseInt(details[4]);
                LoanProcessor.makePayment(bankName, borrowerName, lumpSum, EMI_NO);
                break;
            case BALANCE:
                EMI_NO = Integer.parseInt(details[3]);
                LoanProcessor.checkBalance(bankName, borrowerName, EMI_NO);
                break;
        }
    }
}
