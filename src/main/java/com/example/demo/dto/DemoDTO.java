package com.example.demo.dto;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Data
public class DemoDTO
{
    @Pattern(regexp = "[A-Z]{1,}[a-z]{2,}")
    private String district;
}
