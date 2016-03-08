package AdapterPattern;

import lombok.Data;

/**
 * Created by Oliver Coulson on 25/01/2016.
 */
@Data
public class PayDImpl implements PayD {
    private String custCardNo;
    private String cardOwnerName;
    private String cardExpMonthDate;
    private Integer CVVNo;
    private Double totalAmount;

    public PayDImpl(String custCardNo, String cardOwnerName, String cardExpMonthDate, Integer CVVNo, Double totalAmount) {
        this.custCardNo = custCardNo;
        this.cardOwnerName = cardOwnerName;
        this.cardExpMonthDate = cardExpMonthDate;
        this.CVVNo = CVVNo;
        this.totalAmount = totalAmount;
    }

}
