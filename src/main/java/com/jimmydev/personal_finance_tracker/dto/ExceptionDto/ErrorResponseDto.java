package com.jimmydev.personal_finance_tracker.dto.ExceptionDto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor
public class ErrorResponseDto {
   private String apiPath;
   private HttpStatus errorCode;
   private String errorMessage;
   private LocalDateTime errorTime;

}
