package com.drofile.dro_file_upload;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.drofile.Entity.User;
import com.drofile.daoImpl.EmployeeDAOImpl;

public class SpringJDBCExample {
	public static void main(String[] args) {
		//Reading the configuratio
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");
        
        //Get EmployeeDAOImpl bean instance
        EmployeeDAOImpl dao = (EmployeeDAOImpl) context.getBean("employeeDAOImpl");
        
        //dao.insert();
        
        List<User> userList = null;
        userList = dao.getAllEmployess();
        System.out.println("USER LIST SIZE IS :"+userList.size());
        
        for(User user : userList){
			System.out.println("USER NAME :"+user.getUserName());
			System.out.println("USER NAME :"+user.getUserName());
		}
        
        context.close();
	}
}
