package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;
import java.util.Scanner;

public class Program2 {

    public static void main(String[] args) {

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
        Scanner sc = new Scanner(System.in);

        System.out.println("=== TEST 1: Department insert ====");
        Department newDep = new Department(null, "Food");
        //departmentDao.insert(newDep);
        //System.out.println("Inserted! New Id = " + newDep.getId());

        System.out.println("=== TEST 3: Department findById ====");
        Department dep = departmentDao.findById(2);
        System.out.println(dep);

        System.out.println("=== TEST 3: Department update ====");
        dep = departmentDao.findById(6);
        dep.setName("Music");
        departmentDao.update(dep);
        System.out.println("Update completed!");

        System.out.println("=== TEST 3: Department delete ====");
        System.out.print("Enter id for delete test: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete completed");

        System.out.println("=== TEST 3: Department findAll ====");
        List<Department> list = departmentDao.findAll();
        for(Department d : list){
            System.out.println(d);
        }
    }
}
