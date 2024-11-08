package com.back_end.JobsRocket.dto;

import com.back_end.JobsRocket.model.enums.Role;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {
	
	private Integer user_id;
	
	
	private String nome;
	
	
	private String email;
	

	private Role role;

}
