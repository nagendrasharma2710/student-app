package com.studentapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentapp.dto.StudentDto;
import com.studentapp.entity.StudentEntity;
import com.studentapp.repository.StudentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public StudentEntity addStudentDetails(StudentDto dto) {
		log.info("Request received to add student records");
		StudentEntity entity = new StudentEntity();
		entity.setStudentName(dto.getStudentName());
		entity.setStudentAge(dto.getStudentAge());
		entity.setStudentBranch(dto.getStudentBranch());
		return studentRepository.save(entity);
	}

//	public List<StudentEntity> getAllStudent(){
//		log.info("Request received to get all student records");
//		List<StudentEntity> list = studentRepository.findAll();
//		if(!list.isEmpty()) {
//			return list;
//		}
//		return null;
//	}

//	public List<StudentDto> getAllStudent(){
//		log.info("Request received to get all student records");
//		List<StudentDto> studentDtoList = new ArrayList<StudentDto>();
//		List<StudentEntity> studentEntityList = studentRepository.findAll();
//		for(StudentEntity studentEntity : studentEntityList) {
//			StudentDto studentDto = new StudentDto();
//			studentDto.setStudentName(studentEntity.getStudentName());
//			studentDto.setStudentAge(studentEntity.getStudentAge());
//			studentDto.setStudentBranch(studentEntity.getStudentBranch());	
//			studentDtoList.add(studentDto);
//		}
//		return studentDtoList;		
//	}

	public List<StudentDto> getAllStudent() {
		List<StudentEntity> studentEntityList = studentRepository.findAll();
		Map<Integer, List<String>>
		studentList = studentEntityList.stream()
			.collect(Collectors.groupingBy(StudentEntity::getId,Collectors
			.mapping(StudentEntity::getStudentName,Collectors.toList())));
            System.out.println("List of Student Id's : " + studentList);
			return (List<StudentDto>) studentList;
		}
//			StudentDto studentDto = new StudentDto();
//			studentDto.setStudentName(studentEntity.getStudentName());
//			studentDto.setStudentAge(studentEntity.getStudentAge());
//			studentDto.setStudentBranch(studentEntity.getStudentBranch());
		
//			Map<Integer, List<StudentEntity> >
//			mapA = studentDto.stream()
//						.collect(Collectors.groupingBy(StudentEntity::getId,Collectors
//						.mapping(StudentEntity::getStudentName,Collectors.toList()));
//		System.out.println("List of Student w.r.t. Id's : " + studentDtoList);
			
//			return studentDto;
//		}).collect(Collectors.toList());
//		return studentDtoList;
	

	public Optional<StudentEntity> getStudentById(int id) {
		log.info("Request received to get student record by id");
		Optional<StudentEntity> studentEntity = studentRepository.findById(id);
		if (Optional.ofNullable(id).isPresent()) {
			return studentEntity;
		}
		return null;
	}

	public boolean updateDetails(int id, StudentDto dto) {
		log.info("Request received to update student record");
		if (studentRepository.findById(id).isPresent()) {
			StudentEntity entity = studentRepository.findById(id).get();
			entity.setStudentName(dto.getStudentName());
			entity.setStudentAge(dto.getStudentAge());
			entity.setStudentBranch(dto.getStudentBranch());
			studentRepository.save(entity);
			return true;
		} else {
			return false;
		}

	}

	public void deleteDetails(int id) {
		log.info("Request received to delete student record");
		StudentEntity entity = studentRepository.getOne(id);
		studentRepository.delete(entity);
	}

	public Object getAllStudent(String studentName) {
		// TODO Auto-generated method stub
		return null;
	}

}
