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

       System.out.println("====== test 4: findAll ========");
       Seller newSeller = new Seller(null, "Jhon", "greg@gmail.com", LocalDate.now(), 4000.00, department );
       sellerDao.insert(newSeller);
       System.out.println("Inserted, new Id = " + newSeller.getId());
    }
}
