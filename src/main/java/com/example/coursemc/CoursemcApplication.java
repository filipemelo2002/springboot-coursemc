package com.example.coursemc;

import com.example.coursemc.domain.*;
import com.example.coursemc.domain.enums.ClientType;
import com.example.coursemc.domain.enums.PaymentState;
import com.example.coursemc.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@SpringBootApplication
public class CoursemcApplication implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final StateRepository stateRepository;
    private final CityRepository cityRepository;
    private final AddressRepository addressRepository;
    private final ClientRepository clientRepository;
    private final ClientOrderRepository clientOrderRepository;
    private final PaymentRepository paymentRepository;
    private final OrderItemRepository orderItemRepository;

    public CoursemcApplication (CategoryRepository categoryRepository,
                                ProductRepository productRepository,
                                StateRepository stateRepository,
                                CityRepository cityRepository,
                                AddressRepository addressRepository,
                                ClientRepository clientRepository,
                                ClientOrderRepository clientOrderRepository,
                                PaymentRepository paymentRepository,
                                OrderItemRepository orderItemRepository
    ) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.stateRepository = stateRepository;
        this.cityRepository = cityRepository;
        this.addressRepository = addressRepository;
        this.clientRepository = clientRepository;
        this.clientOrderRepository = clientOrderRepository;
        this.paymentRepository = paymentRepository;
        this.orderItemRepository = orderItemRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(CoursemcApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Category cat1 = new Category(null, "Informática");
        Category cat2 = new Category(null, "Escritório");

        Product p1 = new Product(null, "Computer", 2000.00);
        Product p2 = new Product(null, "Impressora", 1300.00);
        Product p3 = new Product(null, "Mouse", 80.00);

        cat1.getProducts().addAll(Arrays.asList(p1,p2, p3));
        cat2.getProducts().add(p2);

        p1.getCategories().add(cat1);
        p2.getCategories().addAll(Arrays.asList(cat1, cat2));
        p3.getCategories().add(cat1);

        categoryRepository.saveAll(Arrays.asList(cat1, cat2));
        productRepository.saveAll(Arrays.asList(p1, p2,p3));

        State s1 = new State(null, "Pernambuco");
        State s2 = new State(null, "São Paulo");

        City c1 = new City(null, "Recife", s1);
        City c2 = new City(null, "Guarulhos", s2);
        City c3 = new City(null, "Jaboatão dos Guararapes", s1);

        s1.getCities().addAll(Arrays.asList(c1, c3));
        s2.getCities().addAll(Arrays.asList(c2));

        stateRepository.saveAll(Arrays.asList(s1,s2));
        cityRepository.saveAll(Arrays.asList(c1,c2,c3));

        Client cl1 = new Client(null, "Filipe Melo", "filipe@email.com", "111111111", ClientType.PESSOAFISICA);
        cl1.getCellphones().addAll(Arrays.asList("12312312","34234342"));

        Address a1 = new Address(null, "Rua teste", "213", "Complemento", "Bairro", "23409-500", cl1, c1);
        Address a2 = new Address(null, "Rua teste 2", "345", "Complemento 2", "Bairro 2", "23456-500", cl1, c2);

        cl1.getAddresses().addAll(Arrays.asList(a1, a2));

        clientRepository.saveAll(Arrays.asList(cl1));
        addressRepository.saveAll(Arrays.asList(a1, a2));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        ClientOrder ped1 = new ClientOrder(null, sdf.parse("31/12/2021 15:09"), cl1, a1);
        ClientOrder ped2 = new ClientOrder(null, sdf.parse("10/10/2021 15:09"), cl1, a2);

        Payment pag1 = new PaymentCard(null, PaymentState.QUITADO, ped1, 6);
        ped1.setPayment(pag1);

        Payment pag2 = new PaymentBoleto(null, PaymentState.PENDENTE, ped2, sdf.parse("20/10/2021 00:00"), null);
        ped2.setPayment(pag2);

        cl1.getClientOrders().addAll(Arrays.asList(ped1, ped2));

        clientOrderRepository.saveAll(Arrays.asList(ped1, ped2));

        paymentRepository.saveAll(Arrays.asList(pag1, pag2));

        OrderItem ip1 = new OrderItem(ped1, p1, 0.0, 1, 2000.00);
        OrderItem ip2 = new OrderItem(ped1, p3, 0.0, 2, 80.00);
        OrderItem ip3 = new OrderItem(ped2, p2, 100.0, 1, 800.00);

        ped1.getItems().addAll(Arrays.asList(ip1, ip3));
        ped2.getItems().addAll(Arrays.asList(ip2));

        p1.getItems().add(ip1);
        p2.getItems().add(ip3);
        p3.getItems().add(ip2);

        orderItemRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
    }
}
