package application;

import Entities.ImportedProduct;
import Entities.Product;
import Entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();

        List<Product> list = new ArrayList<>();
         for (int i = 0; i < n; i++) {
             System.out.println("Product #"+(i + 1)+" data:");
             System.out.print("Common, used or imported (c/u/i)?");
             char type = sc.next().charAt(0);
             System.out.print("Name: ");
             sc.nextLine();
             String name = sc.nextLine();
             System.out.print("Price: ");
             double price = sc.nextDouble();

             if ( type == 'c'){
                 list.add(new Product(name,price));
             }
             else if ( type == 'i') {
                 System.out.print("Customs fee: ");
                 double customsFee = sc.nextDouble();
                 list.add(new ImportedProduct(name, price, customsFee));
             }
             else {
                 System.out.print("Manufacture date (DD/MM/YYYY): ");
                 Date date = sdf.parse(sc.next());
                 list.add(new UsedProduct(name, price, date));
             }
         }

         System.out.println("PRICE TAGS: ");
        for (Product p : list) {
            System.out.println(p.priceTag());
        }

        sc.close();

    }
}
