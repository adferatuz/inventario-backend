package com.inventario.inventario_backend.config;

import com.inventario.inventario_backend.entity.Product;
import com.inventario.inventario_backend.entity.User;
import com.inventario.inventario_backend.repository.ProductRepository;
import com.inventario.inventario_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Crear usuario administrador por defecto si no existe
        if (!userRepository.existsByUsername("admin")) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setEmail("admin@inventario.com");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setFirstName("Administrador");
            admin.setLastName("Sistema");
            admin.setRole(User.Role.ADMIN);
            userRepository.save(admin);
            System.out.println("Usuario administrador creado: admin / admin123");
        }

        // Crear usuario normal por defecto si no existe
        if (!userRepository.existsByUsername("usuario")) {
            User user = new User();
            user.setUsername("usuario");
            user.setEmail("usuario@inventario.com");
            user.setPassword(passwordEncoder.encode("usuario123"));
            user.setFirstName("Usuario");
            user.setLastName("Normal");
            user.setRole(User.Role.USER);
            userRepository.save(user);
            System.out.println("Usuario normal creado: usuario / usuario123");
        }

        // Crear productos de ejemplo si no existen
        if (productRepository.count() == 0) {
            Product product1 = new Product();
            product1.setName("Laptop Dell Inspiron 15");
            product1.setDescription("Laptop Dell Inspiron 15 con procesador Intel Core i5, 8GB RAM, 256GB SSD");
            product1.setSku("DELL-INS-15-001");
            product1.setPrice(new BigDecimal("899.99"));
            product1.setStockQuantity(25);
            product1.setMinimumStock(5);
            product1.setCategory("Computadoras");
            product1.setBrand("Dell");
            productRepository.save(product1);

            Product product2 = new Product();
            product2.setName("Mouse Logitech MX Master 3");
            product2.setDescription("Mouse inalámbrico ergonómico con sensor de alta precisión");
            product2.setSku("LOG-MX-M3-001");
            product2.setPrice(new BigDecimal("99.99"));
            product2.setStockQuantity(50);
            product2.setMinimumStock(10);
            product2.setCategory("Accesorios");
            product2.setBrand("Logitech");
            productRepository.save(product2);

            Product product3 = new Product();
            product3.setName("Monitor Samsung 24 pulgadas");
            product3.setDescription("Monitor LED Full HD de 24 pulgadas con tecnología IPS");
            product3.setSku("SAM-MON-24-001");
            product3.setPrice(new BigDecimal("199.99"));
            product3.setStockQuantity(15);
            product3.setMinimumStock(3);
            product3.setCategory("Monitores");
            product3.setBrand("Samsung");
            productRepository.save(product3);

            Product product4 = new Product();
            product4.setName("Teclado Mecánico RGB");
            product4.setDescription("Teclado mecánico con switches Cherry MX Blue e iluminación RGB");
            product4.setSku("MECH-KB-RGB-001");
            product4.setPrice(new BigDecimal("129.99"));
            product4.setStockQuantity(2);
            product4.setMinimumStock(5);
            product4.setCategory("Accesorios");
            product4.setBrand("Corsair");
            productRepository.save(product4);

            System.out.println("Productos de ejemplo creados");
        }
    }
}


