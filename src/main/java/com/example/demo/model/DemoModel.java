package com.example.demo.model;
import com.example.demo.dto.DemoDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="raghav")
@Data
@NoArgsConstructor
public class DemoModel
{
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String district;

    public DemoModel(DemoDTO demoDTO)
    {
        this.district = demoDTO.getDistrict();
    }
}
