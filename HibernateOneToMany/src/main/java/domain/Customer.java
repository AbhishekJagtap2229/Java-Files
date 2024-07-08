package domain;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "customer_info")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerId;
    @Column(name = "customer_name")
    private String customerName;
    @Column(name = "customer_email")
    private String customerEmail;
    @OneToMany(mappedBy = "customerRef",cascade = CascadeType.ALL)
    private List<Orders> ordersList;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }

    public void addOrder(Orders ordRef){
        if (ordersList==null){
            ordersList=new LinkedList<>();
        }
        ordersList.add(ordRef);
        ordRef.setCustomerRef(this);
    }
}
