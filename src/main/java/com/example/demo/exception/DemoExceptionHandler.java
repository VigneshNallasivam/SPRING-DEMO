package com.example.demo.exception;
import com.example.demo.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.List;
import java.util.stream.Collectors;
@ControllerAdvice
public class DemoExceptionHandler
{
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex)
    {
        List<ObjectError> errorList=ex.getBindingResult().getAllErrors();
        List<String> errMsg = errorList
                              .stream()
                              .map(objectError -> objectError.getDefaultMessage())
                              .collect(Collectors.toList());
        ResponseDTO responseBookDTO =new ResponseDTO("Exception Occured", errMsg.toString());
        return new ResponseEntity<>(responseBookDTO, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(DemoException.class)
    public ResponseEntity<ResponseDTO> handlePayrollException(DemoException ex)
    {
        ResponseDTO responseBookDTO =new ResponseDTO("Exception Occured",ex.getMessage());
        return new ResponseEntity<>(responseBookDTO, HttpStatus.BAD_GATEWAY);
    }

}
