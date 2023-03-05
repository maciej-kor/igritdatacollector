package com.projects.igritdatacollector.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "record not found")
public class ResourceNotFoundException extends RuntimeException {

}
