package com.example.demo.dto;

import com.example.demo.model.DemoModel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseDTO
{
    private String message;
    private Object data;

    public ResponseDTO(String message,Object data)
    {
        this.message = message;
        this.data = data;
    }
}
