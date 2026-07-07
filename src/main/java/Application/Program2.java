package Application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.ArrayList;
import java.util.List;

public class Program2 {

    public static void main(String[] args){
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("====== test 1: department insert ========");
        Department newDepartment = new Department(null, "Ifood");
        departmentDao.insert(newDepartment);
        System.out.println("Insert Department ID = " + newDepartment.getId());

        System.out.println("====== test 2: department update ========");
        newDepartment = departmentDao.findById(1);
        newDepartment.setName("Moveis");
        departmentDao.update(newDepartment);
        System.out.println("Update completed!!");

        System.out.println("====== test 3: department deleteById ========");
        int id = 16;
        departmentDao.deleteById(id);
        System.out.println("Delete completed!!");

        System.out.println("====== test 4: department findById ========");
        newDepartment = departmentDao.findById(3);
        System.out.println(newDepartment);


        System.out.println("====== test 5: department findAll ========");
        List<Department> list = departmentDao.findAll();
        for (Department obj: list){
            System.out.println(obj);
        }
    }



}
