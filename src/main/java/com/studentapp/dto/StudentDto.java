package com.studentapp.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class StudentDto {

	@NotNull(message = "student name must not be null or blank")
	private String studentName;
	@NotBlank(message = "student age must not be null or blank")
	private String studentAge;
	@NotBlank(message = "student branch must not be null or blank")
	private String studentBranch;

}
