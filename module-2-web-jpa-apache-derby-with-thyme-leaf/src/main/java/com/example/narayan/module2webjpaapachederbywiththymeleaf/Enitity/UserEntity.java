package com.example.narayan.module2webjpaapachederbywiththymeleaf.Enitity;


	
	import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
	
	@Entity
	@Data
	public class UserEntity{
		@Id
		private String id;
		private String name;
		private String email;
}
