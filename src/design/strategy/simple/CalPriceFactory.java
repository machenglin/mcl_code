package design.strategy.simple;

/**
 * Created by Mcl on 2017/11/13.
 */
public class CalPriceFactory {

    private CalPriceFactory() {
    }

    public static CalPrice createCalPrice(Customer customer) {
        Double totalAmount = customer.getTotalAmount();
        if (totalAmount > GoldVip.minPrice) {
            return new GoldVip();
        } else if (totalAmount > SuperVip.minPrice) {
            return new SuperVip();
        } else if (totalAmount > Vip.minPrice) {
            return new Vip();
        } else {
            return new Common();
        }
    }

}
