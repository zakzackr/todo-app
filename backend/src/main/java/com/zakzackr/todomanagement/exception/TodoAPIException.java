package com.zakzackr.todomanagement.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
@Setter
public class TodoAPIException extends RuntimeException{
    private HttpStatus status;
    private String message;
}
