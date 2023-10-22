package com.webservice.project.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.webservice.project.entities.Category;
import com.webservice.project.entities.Order;
import com.webservice.project.entities.OrderItem;
import com.webservice.project.entities.Payment;
import com.webservice.project.entities.Product;
import com.webservice.project.entities.User;
import com.webservice.project.entities.enums.OrderStatus;
import com.webservice.project.repositories.CategoryRepository;
import com.webservice.project.repositories.OrderItemRepository;
import com.webservice.project.repositories.OrderRepository;
import com.webservice.project.repositories.ProductRepository;
import com.webservice.project.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "Electronics"); 
        Category cat2 = new Category(null, "Games"); 
        Category cat3 = new Category(null, "Computers");

        Product p1 = new Product(null, "Elden Ring", "Lorem ipsum dolor sit amet, consectetur.", 90.5, ""); 
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, ""); 
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, ""); 
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, ""); 
        Product p5 = new Product(null, "Cyberpunk 2077", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
        Product p6 = new Product(null, "iPhone 13", "Apple's latest smartphone with A15 Bionic chip.", 1099.0, "iphone13.jpg");
        Product p7 = new Product(null, "Samsung 4K Smart TV", "65-inch QLED 4K UHD TV with HDR.", 1499.0, "samsungtv.jpg");
        Product p8 = new Product(null, "Dell XPS 13", "13-inch laptop with Intel Core i7 and InfinityEdge display.", 1299.0, "dellxps13.jpg");
        Product p9 = new Product(null, "PlayStation 5", "Next-gen gaming console with high-speed SSD.", 499.0, "ps5.jpg");
        Product p10 = new Product(null, "Logitech G Pro X Keyboard", "Mechanical gaming keyboard with customizable switches.", 129.99, "gprokeyboard.jpg");


        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10));

        p1.getCategories().add(cat2);

        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);

        p3.getCategories().add(cat3);

        p4.getCategories().add(cat3);

        p5.getCategories().add(cat2);
        p6.getCategories().add(cat1);
        p7.getCategories().add(cat1); 
        p8.getCategories().add(cat3);
        p9.getCategories().add(cat2);
        p10.getCategories().add(cat2);

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
        User u3 = new User(null, "Laura Smith", "laura@gmail.com", "966666666", "123456");
        User u4 = new User(null, "John Johnson", "john@gmail.com", "955555555", "123456");
        User u5 = new User(null, "Emily Davis", "emily@gmail.com", "944444444", "123456");
        User u6 = new User(null, "Michael Wilson", "michael@gmail.com", "933333333", "123456");
        User u7 = new User(null, "Sophia Lee", "sophia@gmail.com", "922222222", "123456");
        User u8 = new User(null, "William Moore", "william@gmail.com", "911111111", "123456");
        User u9 = new User(null, "Olivia Anderson", "olivia@gmail.com", "900000000", "123456");
        User u10 = new User(null, "James Martin", "james@gmail.com", "899999999", "123456");
        User u11 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u12 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");


        Order o1 = new Order(null, Instant.parse("2023-06-20T19:53:07Z"), OrderStatus.PAID, u1); 
        Order o2 = new Order(null, Instant.parse("2023-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2); 
        Order o3 = new Order(null, Instant.parse("2023-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1); 
        Order o4 = new Order(null, Instant.parse("2023-08-10T10:15:30Z"), OrderStatus.PAID, u3);
        Order o5 = new Order(null, Instant.parse("2023-08-15T14:27:45Z"), OrderStatus.SHIPPED, u4);
        Order o6 = new Order(null, Instant.parse("2023-09-05T08:30:18Z"), OrderStatus.DELIVERED, u5);
        Order o7 = new Order(null, Instant.parse("2023-09-12T20:10:05Z"), OrderStatus.CANCELED, u6);
        Order o8 = new Order(null, Instant.parse("2023-09-20T16:45:02Z"), OrderStatus.PAID, u7);
        Order o9 = new Order(null, Instant.parse("2023-09-25T09:55:57Z"), OrderStatus.SHIPPED, u8);
        Order o10 = new Order(null, Instant.parse("2023-10-02T17:30:42Z"), OrderStatus.DELIVERED, u9);

        userRepository.saveAll(Arrays.asList(u1, u2, u3, u4, u5, u6, u7, u8, u9, u10, u11, u12));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3, o4, o5, o6, o7, o8, o9, o10));

        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice()); 
        OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice()); 
        OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice()); 
        OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
        OrderItem oi5 = new OrderItem(o4, p2, 3, p2.getPrice()); 
        OrderItem oi6 = new OrderItem(o5, p4, 2, p4.getPrice()); 
        OrderItem oi7 = new OrderItem(o6, p5, 1, p5.getPrice()); 
        OrderItem oi8 = new OrderItem(o7, p1, 4, p1.getPrice()); 


        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4, oi5, oi6, oi7, oi8));

        Payment pay1 = new Payment(null, Instant.parse("2023-06-20T21:53:07Z"), o1);
        o1.setPayment(pay1);

        orderRepository.save(o1);
    }
}
