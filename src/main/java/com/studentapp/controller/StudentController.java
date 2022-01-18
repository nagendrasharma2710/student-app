package com.studentapp.controller;

import java.util.Optional;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.studentapp.dto.StudentDto;
import com.studentapp.entity.StudentEntity;
import com.studentapp.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Api(tags="student controller provider")
@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/student")
public class StudentController {
	
	private StudentService studentService;   // we use @AllArgsConstructor instead of Autowiring the StudentService

	@ApiOperation(value = "demo Api")
	@GetMapping("/ping")
	public String getMessage() {
		log.info("demo Api to check the controller");
		return "hello controller...";
	}

	@ApiOperation(value = "API to add student record")
	@PostMapping("/add")
	public ResponseEntity<?> addStudent(@Valid @RequestBody StudentDto dto) {
		log.info("Api to add student details, data = {}", dto);
		return ResponseEntity.ok(studentService.addStudentDetails(dto));
	}

	@ApiOperation(value = "API to get all student records")
	@GetMapping("/getAllStudent")
	public ResponseEntity<Object> getAllStudent(){
		log.info("Api to get all students details");
		return ResponseEntity.ok(studentService.getAllStudent());
	}

	@ApiOperation(value = "API to get student record by Id")
	@GetMapping("/get/{id}")
	public ResponseEntity<Optional<StudentEntity>> getStudent(@PathVariable int id) {
		log.info("Api to get student details by id, id = {}", id);
		return ResponseEntity.ok(studentService.getStudentById(id));
	}

	@ApiOperation(value = "API to update student record")
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateDetails(@PathVariable int id, @Valid @RequestBody StudentDto dto) {
		log.info("Api to update student details by id, data = {}, id = {}", dto, id);
		studentService.updateDetails(id, dto);
		return ResponseEntity.ok("Student Details updated successfully...");
	}

	@ApiOperation(value = "API to delete student record by Id")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteDetails(@PathVariable int id) {
		log.info("Api to delete student details by id, id = {}", id);
		studentService.deleteDetails(id);
		return ResponseEntity.ok("Student Details deleted succesfully...");
	}

//	@ApiOperation(value = "Api to get pdf of students records")
//	@GetMapping("/pdf")
//	public ResponseEntity<?> exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
//		log.info("Api to generate pdf of student details");
//		response.setContentType("pdf");
//		DateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy_HH:mm:ss");
//		String currentDateTime = dateFormatter.format(new Date());
//
//		String headerKey = "Content-Disposition";
//		String headerValue = "attachment; filename=studentsDetails" + currentDateTime + ".pdf";
//		response.setHeader(headerKey, headerValue);
//		List<StudentEntity> studentEntitylist = studentService.getAllStudent();
//		StudentPDF exporter = new StudentPDF(studentlist);
//		exporter.export(response);
//		return null;
//	}
}
