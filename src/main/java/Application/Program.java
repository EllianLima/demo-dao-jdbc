package Application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.time.LocalDate;
import java.util.List;

public class Program {
   public static void main(String[] args) {
       SellerDao sellerDao = DaoFactory.createSellerDao();

       System.out.println("====== test 1: findById ========");
       Seller seller = sellerDao.findById(3);
       System.out.println(seller);

       System.out.println("====== test 2: findByDepartment ========");
       Department department = new Department(2, null);
       List<Seller> list = sellerDao.findByDepartment(department);
       for (Seller obj: list){
           System.out.println(obj);
       }

       System.out.println("====== test 3: findAll ========");
       list = sellerDao.findAll();
       for (Seller obj: list){
           System.out.println(obj);
       }

       System.out.println("====== test 4: seller insert ========");
       Seller newSeller = new Seller(null, "Jhon", "greg@gmail.com", LocalDate.now(), 4000.00, department );
       sellerDao.insert(newSeller);
       System.out.println("Inserted, new Id = " + newSeller.getId());

       System.out.println("====== test 5: seller update ========");
       seller = sellerDao.findById(1);
       seller.setName("Matha Waine");
       sellerDao.update(seller);
       System.out.println("Update completed");

       System.out.println("====== test 6: seller delete ========");
       int id = 9;
       sellerDao.deleteById(id);

    }
}
