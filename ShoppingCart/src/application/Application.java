package application;
import products.Product;
import shoppingcart.ShoppingCart;


public class Application {

	public static void main(String[] args) {
		ShoppingCart cart = new ShoppingCart();
		Product p1 = new Product("A123", 100.0, "TV");
		cart.add(p1);
		Product p2 = new Product("A665", 75.0, "MP3 Player");
		cart.add(p2);
		Product p3 = new Product("A665", 75.0, "MP3 Player");
		cart.add(p3);
		
		cart.print();
		
		cart.remove(p3);
		cart.remove(p2);
		
		cart.print();

	}

}
