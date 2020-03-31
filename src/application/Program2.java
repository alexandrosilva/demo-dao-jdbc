package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("\n=== TEST 1: Department FindById ===");
		Department department = departmentDao.findById(2);
		System.out.println(department);
		
		System.out.println("\n=== TEST 3: Department findAll ===");
		List<Department> listAll = departmentDao.findAll();		
		for (Department obj : listAll) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 3: department insert ===");
		Department newDepartment = new Department(null, "Mercado");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted!!! New id = " + newDepartment.getId());
		
		System.out.println("\n=== TEST 4: department delete ===");
		System.out.println("Digite um id para ser deletado: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Deleted!!!");

		System.out.println("\n=== TEST 5: department update ===");
		System.out.println("Digite um id para ser atualizado: ");
		id = sc.nextInt();
		department = departmentDao.findById(id);
		department.setName("Mercadossss");
		departmentDao.update(department);
		System.out.println("Atualizado!!!");
		
		sc.close();
	}
}
