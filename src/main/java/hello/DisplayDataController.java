package hello;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DisplayDataController {

		@RequestMapping("/display")
		public String display(/*Employee employeeAlpha, */Model model) { 
			
			ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			EmployeeDAO employeeDAO = (EmployeeDAO) context.getBean("employeeDAO");
			Employee employeeAlpha = employeeDAO.findById(3);
			
			model.addAttribute("Employee1", employeeAlpha);
			context.close();
			return "display";
		}
		
		@RequestMapping("/addUser")
		public String add(Model model) {
			
//			ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//			EmployeeDAO employeeDAO = (EmployeeDAO) context.getBean("employeeDAO");
			
			return "addUser";
		}
		
		@RequestMapping(value="postReg", method = RequestMethod.POST)
		public String doPost (HttpServletRequest request, HttpServletResponse response) {
			
			ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			EmployeeDAO employeeDAO = (EmployeeDAO) context.getBean("employeeDAO");
			
			String fname = request.getParameter("firstnamesignup");
			String lname = request.getParameter("lastnamesignup");
			
			System.out.println(fname);
			System.out.println(lname);
			
			Employee e = new Employee (6, fname, lname);
			employeeDAO.insert(e);
			System.out.println("Added the employee!");
			
			context.close();
			
			return "redirect:/display";
		}
		
}
