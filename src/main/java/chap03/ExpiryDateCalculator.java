package chap03;

import java.time.LocalDate;

public class ExpiryDateCalculator {
    public LocalDate calculateExpiryDate(LocalDate billingDate,int payAmount){
        return billingDate.plusMonths(1);
    }

    public LocalDate calculdateExpiryDate2(LocalDate billingDate2,int payAmount2){
        return LocalDate.of(2019,5,1);
    }
}
