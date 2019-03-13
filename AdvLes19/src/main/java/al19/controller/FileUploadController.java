package al19.controller;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.RedirectView;

import al19.domain.Student;
import al19.service.StudentService;

@EnableWebMvc
@Controller
public class FileUploadController {
	  @Autowired
   StudentService studentService;

	  @RequestMapping(value="/upload", method= {RequestMethod.POST, RequestMethod.GET})
		public   @ResponseBody ModelAndView uploadStudent(
				@RequestParam("firstName") String firstName,
				@RequestParam("secondName") String secondName,
				@RequestParam("age") Integer age,
				@RequestParam("file") MultipartFile file,
				RedirectAttributes ra) throws IOException, ServletException {
		  String fileName =file.getOriginalFilename();
		  System.out.println(fileName);
		  Student student =	studentService.saveStudent(firstName, secondName, age, file);
		  String dirPath="J:\\Java\\core\\AdvLes19\\src\\main\\resources\\static\\pics\\";
		System.out.println(student);
		
	            try {
	                byte[] bytes = file.getBytes();
	                BufferedOutputStream stream =
	                        new BufferedOutputStream(new FileOutputStream(new File(dirPath+fileName)));
	                stream.write(bytes);
	                stream.close();
	               
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	          ModelAndView modelAndView= new ModelAndView("redirect:/student");
	          modelAndView.setViewName("student");
	          ra.addAttribute("name",student.getFirstName());
	          ra.addAttribute("url",dirPath+fileName);
	          
	          System.out.println(ra);
	         
	  return modelAndView;     
	  } 
	  @RequestMapping({"/index","/"})
	    public String getWelcome(){
	        return "index";
	    }
	 
	  @RequestMapping(value="/student", method = RequestMethod.GET)
	    public ModelAndView  hiJack(
//	    		@RequestParam ModelMap model,
//	    		HttpServletRequest req
	    		)
	  {
//		  String name = (String) req.getAttribute("name");
//		  String url =(String) req.getAttribute("url");
//		  System.out.println(name+url);
//		  model.addAttribute("name", name);
//		  model.addAttribute("urlPic", url);
	       return new ModelAndView("student");
	    }


	

}