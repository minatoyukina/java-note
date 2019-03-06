package netty.netty.xml;

import netty.netty.xml.pojo.Address;
import netty.netty.xml.pojo.Customer;
import netty.netty.xml.pojo.Order;
import netty.netty.xml.pojo.Shipping;

public class OrderFactory {
    public static Order create(int i) {
        Customer customer = new Customer();
        customer.setCustomerNumber(i);
        customer.setFirstName("李");
        customer.setLastName("林峰");
        Address address = new Address();
        address.setStreet1("龙眠大道");
        address.setCity("南京市");
        address.setState("江苏省");
        address.setPostCode("123321");
        address.setCountry("中国");
        Order order = new Order();
        order.setCustomer(customer);
        order.setOrderNumber(i);
        order.setBillTo(address);
        order.setShipTo(address);
        order.setTotal(9999.9999F);
        order.setShipping(Shipping.INTERNATIONAL_MAIL);
        return order;
    }
}
