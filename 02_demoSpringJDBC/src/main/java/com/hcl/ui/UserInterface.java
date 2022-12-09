package com.hcl.ui;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hcl.config.SpringConfig;
import com.hcl.dao.EmployeeDAO;
import com.hcl.pojo.Employee;

public class UserInterface {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(SpringConfig.class);
		EmployeeDAO empDAO=ctx.getBean(EmployeeDAO.class);
		boolean flag;
		
		String choice="yes";
		Scanner sc=new Scanner(System.in);
		do
		{
			
			System.out.println("1. Get All Employee Details");
			System.out.println("2. Get Employee By ID");
			System.out.println("3. Add Employee Details");
			System.out.println("4. Update Employee Details");
			System.out.println("5. Delete Employee Details");
			System.out.println("6. Exit");
			System.out.println("Select Operation you would like to Perform?");
			int op=sc.nextInt();
			switch(op)
			{
				case 1:
				{
					List<Employee> emps=empDAO.getAllEmployee();
					for(Employee e:emps)
						System.out.println(e);
					break;
				}
				case 2:
				{
					System.out.println("Enter id to search an Employee");
					int id=sc.nextInt();
					Employee emp=empDAO.getEmployeeById(id);
					System.out.println(emp);
					break;
				}
				case 3:
				{
					System.out.println("Enter Employee id");
					int id=sc.nextInt();
					System.out.println("Enter Employee Name");
					String name=sc.next();
					System.out.println("Enter Employee Salary");
					double salary=sc.nextDouble();
					System.out.println("Enter Dept no");
					int dept=sc.nextInt();
					Employee e=new Employee(id,name,salary,dept);
					flag=empDAO.addEmployee(e);
					if(flag)
						System.out.println("Employee Details Added successfully...");
					else
						System.out.println("Employee Details could not be added..");
					break;
				}
				case 4:{
					System.out.println("Enter Existing Employee id");
					int id=sc.nextInt();
					System.out.println("Enter Employee Name");
					String name=sc.next();
					System.out.println("Enter Employee Salary");
					double salary=sc.nextDouble();
					System.out.println("Enter Dept no");
					int dept=sc.nextInt();
					Employee e=new Employee(id,name,salary,dept);
					flag=empDAO.updateEmployee(e);
					if(flag)
						System.out.println("Employee Details Updated successfully...");
					else
						System.out.println("Employee Details could not be updated..");
					break;
				}
				case 5:
				{
					System.out.println("Enter id to delete an Employee");
					int id=sc.nextInt();
					flag=empDAO.deleteEmployee(id);
					if(flag)
						System.out.println("Employee Details Deleted successfully...");
					else
						System.out.println("Employee Details could not be Deleted..");
					break;
				}
				default:
					System.out.println("Not a valid Operation number");
					break;
					
			}
			System.out.println("Would you like to Continue?(yes/no)");
			choice=sc.next();
		}while(choice.equalsIgnoreCase("yes"));

	}

}
