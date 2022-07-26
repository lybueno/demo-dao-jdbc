package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();
        Scanner sc = new Scanner(System.in);

        System.out.println("=== TEST 1: Seller findByID ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("=== TEST 2: Seller findByDepartment ===");
        List<Seller> list = sellerDao.findByDepartment(new Department(2, null));
        for(Seller obj : list ){
            System.out.println(obj);
        }

        System.out.println("=== TEST 3: Seller findAll ===");
        list = sellerDao.findAll();
        for(Seller obj : list ){
            System.out.println(obj);
        }

        System.out.println("=== TEST 4: Seller insert ===");
        //Seller newSeller = new Seller(null, "Greg Geller", "greg@gmail.com", new Date(), 4000.0, new Department(2, null));
        //sellerDao.insert(newSeller);
        //System.out.println("Inserted! New Id = " + newSeller.getId());

        System.out.println("=== TEST 5: Seller update ===");
        seller = sellerDao.findById(1);
        seller.setName("Martha Waine");
        sellerDao.udpate(seller);
        System.out.println("Update completed!");

        System.out.println("=== TEST 6: Seller delete ===");
        System.out.println("Enter id for delete test: ");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Delete completed");

        sc.close();
    }
}
