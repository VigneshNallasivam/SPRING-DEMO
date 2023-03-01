package com.example.demo.service;
import com.example.demo.dto.DemoDTO;
import com.example.demo.model.DemoModel;
import java.util.List;
import java.util.Optional;
public interface IDemoService
{
    DemoModel insert(DemoDTO demoDTO);
    List<DemoModel> getAll();
    DemoModel update(DemoDTO demoDTO,int id);
    void delete(int id);
    Optional<DemoModel> getById(int id);
    DemoModel getByDistrict(String district);
}
