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

//            Insert data
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

//            Find by Id SELECT
//            Customer customer = customerDao.findById(10000);
//            System.out.println(customer.getFirstName() +" "+customer.getLastName());

//            Update Data
//            Customer customer = customerDao.findById(10000);
//            System.out.println(customer.getFirstName() + " " + customer.getLastName() + " " +
//                    customer.getEmail());
//            customer.setEmail("gwashington@wh.gov");
//            customer = customerDao.update(customer);
//            System.out.println(customer.getFirstName() + " " + customer.getLastName() + " " +
//                    customer.getEmail());
//

//            CRUD complete
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
//
//            Customer dbCustomer = customerDao.create(customer);
//            System.out.println(dbCustomer.getFirstName());
//            dbCustomer = customerDao.findById(dbCustomer.getId());
//            System.out.println(dbCustomer.getFirstName());
//            dbCustomer.setEmail("john.adams@wh.gov");
//            dbCustomer = customerDao.update(dbCustomer);
//            System.out.println(dbCustomer.getFirstName());
//            customerDao.delete(dbCustomer.getId());

//            Get order details by Join
//            OrderDAO orderDAO = new OrderDAO(connection);
//            Order order = orderDAO.findById(1000);
//            System.out.println(order);

//            Stored Procedure
//            OrderDao orderDAO = new OrderDao(connection);
//            List<Order> orders = orderDAO.getOrdersForCustomer(789);
//            orders.forEach(System.out::println);

//            Order & Limit
//            CustomerDao customerDAO = new CustomerDao(connection);
//            customerDAO.findAllSorted(20).forEach(System.out::println);

//            Paging
            CustomerDao customerDAO = new CustomerDao(connection);
            customerDAO.findAllSorted(20).forEach(System.out::println);
            System.out.println("Paged");
            for(int i=1;i<3;i++){
                System.out.println("Page number: " + i);
                customerDAO.findAllPaged(10, i).forEach(System.out::println);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
