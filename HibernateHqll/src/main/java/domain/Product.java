package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "product_info")
public class Product {

        @Id
        @Column(name = "product_id")
        private int productId;
        @Column(name = "product_name")
        private String productName;
        @Column(name = "product_category")
        private String productCategory;
        @Column(name = "product_price")
        private double productPrice;

        public int getProductId() {
        return productId;
    }

    public Product() {
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

        public String getProductName() {
        return productName;
    }

        public void setProductName(String productName) {
        this.productName = productName;
    }

        public String getProductCategory() {
        return productCategory;
    }

        public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

        public double getProductPrice() {
        return productPrice;
    }

        public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

        @Override
        public String toString() {
            return productId + "\t" + productName + "\t" + productCategory + "\t" + productPrice;

        }
}
