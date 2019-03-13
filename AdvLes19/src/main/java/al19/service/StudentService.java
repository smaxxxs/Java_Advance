package al19.service;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import al19.domain.Student;
import al19.repository.StudentRepo;

@Service
public class StudentService {

	@Autowired
	private StudentRepo studentRepo;
	@SuppressWarnings("null")
	public Student saveStudent(String firstName, String secondName, Integer age, MultipartFile file) throws IOException {
		Student student  = new Student();
		String fileName = file.getOriginalFilename();
		student.setFirstName(firstName);
		student.setSecondName(secondName);
		student.setAge(age);
		

		if (!fileName.contains("..")) {
			student.setUrlPic(fileName);
		}

		return studentRepo.save(student);
	}

	@SuppressWarnings("unused")
	public File getPhoto(Student student) {
		File photo = new File(student.getUrlPic());
		if (photo==null) {photo=new File("../pics/noPhoto.jpg");}
		return photo;
				
	}
}
