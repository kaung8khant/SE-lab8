package shoppingcart;
import java.util.ArrayList;


import java.util.Iterator;

import products.Product;

public class ShoppingCart {
	ArrayList<CartLine> list = new ArrayList<CartLine>();

	public void add(Product product) {
		for (CartLine cline : list) {
			if (cline.getProduct().getProductnumber().equals(product.getProductnumber())) {
				cline.setQuantity(cline.getQuantity()+1);
				return;
			}
		}
		CartLine cline = new CartLine();
		cline.setProduct(product);
		cline.setQuantity(1);
		list.add(cline);
	}
	
	public void remove(Product product) {
		Iterator<CartLine> iter = list.iterator();
		while (iter.hasNext()){
			CartLine cline = iter.next();
			if (cline.getProduct().getProductnumber().equals(product.getProductnumber())){
				if (cline.getQuantity()>1){
					cline.setQuantity(cline.getQuantity()-1);
				}
				else{
					iter.remove();
				}
			}
		}
	}
	
	public void print() {
		System.out.println("Content of the shoppingcart:");
		for (CartLine cline : list) {
			System.out.println(cline.getQuantity() + " "
					+ cline.getProduct().getProductnumber() + " "
					+ cline.getProduct().getDescription() + " "
					+ cline.getProduct().getPrice());
		}
		System.out.println("Total price ="+getT());
	}
	
	// get total price
	public double getT(){
		double tp = 0.0;
		for (CartLine c : list) {
			tp=tp+(c.getProduct().getPrice() * c.getQuantity());
		}
		return tp;
	}
}
