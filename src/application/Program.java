package application;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		String name;
		double price, fee;
		
		
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		List<Product> list = new ArrayList<>();
		
		System.out.println("Enter the number of products: ");
		
		int n = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			
			System.out.println("Product #" + i + " data:");
			System.out.println("Common, used pr imported (c/u/i)?");
			char ch = sc.next().charAt(0);
			
			if(ch == 'c') {
				System.out.println("Name: ");
				name = sc.next();
				
				System.out.println("Price: ");
				price = sc.nextDouble();
				
				list.add(new Product(name,price));
				
			}
				
				if(ch == 'u'){
			
				
				System.out.println("Name: ");
				String name1 = sc.next();
				System.out.println("Price: ");
				price = sc.nextDouble();
				System.out.println("Manufacture date (DD/MM/YYYY)");
				String manufacture = sc.nextLine();
				
				DateFormat date = new SimpleDateFormat("dd/MM/yyyy");			    
				Date data = date.parse(manufacture);
			
				list.add(new UsedProduct(name1,price, data));
				}
				
			if(ch == 'i') {
				
				System.out.println("Name: ");
				String name2 = sc.next();
				System.out.println("Price: ");
				price = sc.nextDouble();
				System.out.println("Customs fee: $");
				fee = sc.nextInt();
				
			
				list.add(new ImportedProduct(name2,price, fee));
				
			}
			
			
		}
		
			System.out.println();
			System.out.println("PRICE TAGS:");
			for(Product prodt : list) {
				
				System.out.println(prodt.getName() + " $ " + String.format("%.2f", prodt.priceTag()) );
				
			}
		
		sc.close();
		
	}

}
