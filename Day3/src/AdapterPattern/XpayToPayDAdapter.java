package AdapterPattern;

/**
 * Created by Oliver Coulson on 22/01/2016.
 */
public class XpayToPayDAdapter implements Xpay {
    @Override
    public String getCreditCardNo() {
        return null;
    }

    @Override
    public void setCreditCardNo(String creditCardNo) {

    }

    @Override
    public String getCustomerName() {
        return null;
    }

    @Override
    public void setCustomerName(String customerName) {

    }

    @Override
    public String getCardExpMonth() {
        return null;
    }

    @Override
    public void setCardExpMonth(String cardExpMonth) {

    }

    @Override
    public String getCardExpYear() {
        return null;
    }

    @Override
    public void setCardExpYear(String cardExpYear) {

    }

    @Override
    public Short getCardCVVNo() {
        return null;
    }

    @Override
    public void setCardCVVNo(Short cardCVVNo) {

    }

    @Override
    public Double getAmount() {
        return null;
    }

    @Override
    public void setAmount(Double amount) {

    }

    @Override
    public String toString() {
        return super.toString();
    }
}
