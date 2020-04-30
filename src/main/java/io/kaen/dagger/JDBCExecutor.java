package io.kaen.dagger;

import io.kaen.dagger.dao.CustomerDao;
import io.kaen.dagger.dao.OrderDao;
import io.kaen.dagger.model.Order;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class JDBCExecutor {
    public static void main(String[] args) {
        DatabaseConnectionManager dcm = new DatabaseConnectionManager(
                "localhost",
                "hplussport",
                "postgres",
                "password"
        );
        try{
            Connection connection = dcm.getConnection();
            CustomerDao customerDao = new CustomerDao(connection);
//            Customer customer = new Customer();
//            customer.setFirstName("Rohan");
//            customer.setLastName("Maity");
//            customer.setEmail("rmaity@pui.com");
//            customer.setPhone("(+91) 9999884423");
//            customer.setAddress("1/3 avenue road, South venice");
//            customer.setCity("Venice");
//            customer.setState("Italy");
//            customer.setZipCode("908-9081");
//            customerDao.create(customer);

//            Customer customer = customerDao.findById(10000);
//            System.out.println(customer.getFirstName() +" "+customer.getLastName());

//            Customer customer = customerDao.findById(10000);
//            System.out.println(customer.getFirstName() + " " + customer.getLastName() + " " +
//                    customer.getEmail());
//            customer.setEmail("gwashington@wh.gov");
//            customer = customerDao.update(customer);
//            System.out.println(customer.getFirstName() + " " + customer.getLastName() + " " +
//                    customer.getEmail());
//
//            Customer customer = new Customer();
//            customer.setFirstName("John");
//            customer.setLastName("Adams");
//            customer.setEmail("jadams.wh.gov");
//            customer.setAddress("1234 Main St");
//            customer.setCity("Arlington");
//            customer.setState("VA");
//            customer.setPhone("(555) 555-9845");
//            customer.setZipCode("01234");
//
//            Customer dbCustomer = customerDao.create(customer);
//            System.out.println(dbCustomer.getFirstName());
//            dbCustomer = customerDao.findById(dbCustomer.getId());
//            System.out.println(dbCustomer.getFirstName());
//            dbCustomer.setEmail("john.adams@wh.gov");
//            dbCustomer = customerDao.update(dbCustomer);
//            System.out.println(dbCustomer.getFirstName());
//            customerDao.delete(dbCustomer.getId());


//            OrderDAO orderDAO = new OrderDAO(connection);
//            Order order = orderDAO.findById(1000);
//            System.out.println(order);


            OrderDao orderDAO = new OrderDao(connection);
            List<Order> orders = orderDAO.getOrdersForCustomer(789);
            orders.forEach(System.out::println);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
