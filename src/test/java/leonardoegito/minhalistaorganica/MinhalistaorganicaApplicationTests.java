package leonardoegito.minhalistaorganica;

import leonardoegito.minhalistaorganica.model.Price;
import leonardoegito.minhalistaorganica.model.Product;
//import org.junit.Test;
//import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;
import java.util.TreeSet;

@SpringBootTest
class MinhalistaorganicaApplicationTests {

	void contextLoads() {
		Price priceTest = new Price();
		Set<Price> priceSetTest = new TreeSet<Price>();
		priceSetTest.add(priceTest);
//		Product productTest = new Product(1, "Banana da Terra", null, 5.99,priceSetTest);
		Product newProduct = new Product("Banana da Terra", "Banana da terra organica 1kg", 5.99);
		System.out.println(newProduct.getName());
	}

}
