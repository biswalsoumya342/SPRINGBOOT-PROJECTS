package com.soumya.blogapp.payloads;

import java.time.LocalDateTime;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
	private LocalDateTime time;
	
	private String message;
	
	private boolean status;
	
	private int code;
}
