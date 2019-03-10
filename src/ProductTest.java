package uSearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * ProductTest is collection of test cases used to test the product type.
 */
class ProductTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testProductData() {
		String[] similar1 = { "Product1", "Product2" };
		Product product1 = new Product("P1", "Product1", "Book", similar1, 4.5);
		assertTrue(product1.getAsin().equals("P1"));
		assertTrue(product1.getTitle().equals("Product1"));
		assertTrue(product1.getGroup().equals("Book"));
		assertTrue(product1.getSimilar()[0].equals("Product1"));
		assertTrue(Math.abs(product1.getRating() - 4.5) < 0.00001);
	}

	@Test
	void testCompareASIN() {
		String[] similar1 = { "Product1", "Product2" };
		Product product1 = new Product("P1", "Product1", "Book", similar1, 4.5);
		Product product2 = new Product("P2", "Product1", "Book", similar1, 4.5);
		Product product3 = new Product("P2", "Product1", "Book", similar1, 4.5);
		assertTrue(product1.compareAsin(product2) < 0);
		assertTrue(product2.compareAsin(product3) == 0);
		assertTrue(product3.compareAsin(product1) > 0);
	}

	@Test
	void testCompareTitle() {
		String[] similar1 = { "Product1", "Product2" };
		Product product1 = new Product("P1", "Product1", "Book", similar1, 4.5);
		Product product2 = new Product("P2", "Product2", "Book", similar1, 4.5);
		Product product3 = new Product("P2", "Product1", "Book", similar1, 4.5);
		assertTrue(product1.compareTitle(product2) < 0);
		assertTrue(product2.compareTitle(product1) > 0);
		assertTrue(product3.compareTitle(product1) > 0);
	}

	@Test
	void testCompareRating() {
		String[] similar1 = { "Product1", "Product2" };
		Product product1 = new Product("P2", "Product1", "Book", similar1, 4.5);
		Product product2 = new Product("P1", "Product2", "Book", similar1, 5.5);
		Product product3 = new Product("P1", "Product1", "Book", similar1, 4.5);
		assertTrue(product1.compareRating(product2) < 0);
		assertTrue(product2.compareRating(product1) > 0);
		assertTrue(product3.compareRating(product1) < 0);
	}

}
