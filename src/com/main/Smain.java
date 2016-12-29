/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.main;

import com.controller.CustomerJpaController;
import com.controller.ProductJpaController;
import com.customer.Customer;
import com.product.Product;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Persistence;

/**
 *
 * @author ajay
 */
public class Smain {
    public static void main(String args[]){
        ProductJpaController controller = 
                new ProductJpaController(Persistence.createEntityManagerFactory("SalesManagementPU"));
        CustomerJpaController cController = 
                new CustomerJpaController(Persistence.createEntityManagerFactory("SalesManagementPU"));
        
//        Product[] p = {
//            new Product("laptop", 30000),
//            new Product("PC", 20000),
//            new Product("Mobiles", 10000),
//            new Product("Headphones", 1000),
//            new Product("Tv", 12000),
//        };
//        for (Product p1 : p) {
//            controller.create(p1);
//        }
//        
//        List<Product> list1 = new ArrayList<>();
//        list1.add(p[0]);
//        list1.add(p[1]);
//        list1.add(p[2]);
//        
//        List<Product> list2 = new ArrayList<>();
//        list2.add(p[3]);
//        list2.add(p[4]);
//        
//        Customer[] c = {
//            new Customer("John", list1),
//            new Customer("Marry", list2),
//        };
//        for (Customer c1 : c) {
//            cController.create(c1);
//        }

  
//      Long product = cController.getCustomers("John");
//      System.out.println(product);
        List<Customer> list = cController.findCustomerEntities();
        for (Customer cus : list) {
            List<Product> products = cus.getProducts();
            for (Product prod : products)
                System.out.println(cus.getName() + " has " + prod.getName());
        }
                        
    }
}
