package AdapterPattern;

/**
 * Created by Oliver Coulson on 25/01/2016.
 */
public class Script {
    public static void main(String[] args) {
        Xpay original = new XpayImpl("324523452", "Dave Jones", "July", "2009", (short) 343, 12.00);

        PayD payD = new PayDImpl("24454334", "Arthur Midas", "12/19", 111, 12.00);
        Xpay adapter = new XpayToPayDAdapter(payD);

        System.out.println(original.getAmount());


        System.out.println(payD.getTotalAmount());
        System.out.println(adapter.getAmount());


    }
}
