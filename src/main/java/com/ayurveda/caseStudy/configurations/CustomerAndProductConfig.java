package com.ayurveda.caseStudy.configurations;

import com.ayurveda.caseStudy.models.Customer;
import com.ayurveda.caseStudy.models.Product;
import com.ayurveda.caseStudy.repo.CustomerRepo;
import com.ayurveda.caseStudy.repo.ProductRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CustomerAndProductConfig {
    @Bean
//this method runs
    CommandLineRunner commandLineRunner(CustomerRepo repositoryOne,ProductRepo repositoryTwo){//we are injecting CustomerRepository and productRepository
        return args -> {
            Customer customerOne = new Customer(
                    "James",
                    "Butt",
                    "jbutt@gmail.com",
                    "JamesButt2@21",
                    "6649 N Blue Gum St"

            );
           Customer customerTwo = new Customer(
                    "Josephine",
                    "Darakjy",
                    "josephine_darakjy@darakjy.org",
                   "JoseDarak2@31",
                   "4 B Blue Ridge Blvd"
            );
            Customer customerThree = new Customer(
                    "Art",
                    "Venere",
                    "art@venere.org",
                    "Artvenere2@41",
                    "8 W Cerritos Ave #54"
            );
            Customer customerFour = new Customer(
                    "Lenna",
                    "Paprocki",
                    "lpaprocki@hotmail.com",
                    "Paprocki2#55",
                    "639 Main St"
            );
            Customer customerFive = new Customer(
                    "Donette",
                    "Foller",
                    "donette.foller@cox.net",
                    "Foller2&110",
                    "434 Center St"
            );
            Product productOne = new Product(
                    "Triphala",
                    14.99,
                    15,
                    "Triphala is a powerful herbal remedy that consists of Haritaki, Bibhitaki and amla."+"\n" +"It is used in traditional Ayurvedic medicine to prevent disease and"+"\n" +"treat a number of symptoms, including constipation and inflammation.",
                    ""

            );
            Product productTwo = new Product(
                    "Aswagandha",
                    15.99,
                    16,
                    "Ashwagandha is an ancient medicinal herb with multiple health benefits."+"\n"+"It can reduce anxiety and stress, help fight depression,"+" \n"+"boost fertility and testosterone in men, and even boost brain function.",
                    "ashwagandha.jpeg"

            );
            Product productThree = new Product(
                    "Chyavanprash",
                    17.99,
                    19,
                    "Chyawanprash (CP) is an Ayurvedic health supplement which is made up of a super-concentrated blend of nutrient-rich herbs and minerals."+"\n"+"It is meant to restore drained reserves of life force (ojas) "+"\n"+"and to preserve strength, stamina, and vitality, while stalling the course of aging.",
                    ""
            );
            Product productFour = new Product(
                    "Avipattikar",
                    12.99,
                    10,
                    "Avipattikar is an herbal remedy used in Ayurveda, the traditional medicine of India."+"\n"+" Available in dietary supplement form, it contains a number of different ayurvedic herbs and is generally used to treat digestive problems."+"\n"+" Avipattikar contains the following herbs: Amla (Emblica officinalis)",
                    ""
            );
            Product productFive = new Product(
                    "Shatavari",
                    17.99,
                    12,
                    "Shatavari is also known as Asparagus racemosus."+"\n"+" It’s a member of the asparagus family. It’s also an adaptogenic herb."+"\n"+" Adaptogenic herbs are said to help your body cope with physical and emotional stress.",
                    ""

            );
            repositoryOne.saveAll(List.of(customerOne,customerTwo,customerThree,customerFour,customerFive));
            repositoryTwo.saveAll(List.of(productOne,productTwo,productThree,productFour,productFive));


        };
    }
}
