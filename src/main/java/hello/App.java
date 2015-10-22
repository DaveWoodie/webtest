package hello;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		EmployeeDAO employeeDAO = (EmployeeDAO) context.getBean("employeeDAO");
        Employee employee1 = new Employee(2, "Fred", "Hat");
        employeeDAO.insert(employee1);
        Employee employee2 = employeeDAO.findById(2);
        System.out.println(employee2);	
		context.close();
	}

}
