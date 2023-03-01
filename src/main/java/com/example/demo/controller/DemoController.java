package com.example.demo.controller;
import com.example.demo.dto.DemoDTO;
import com.example.demo.dto.ResponseDTO;
import com.example.demo.model.DemoModel;
import com.example.demo.service.IDemoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/home")
public class DemoController
{
    @Autowired
    IDemoService service;
    @PostMapping("/post")
    public ResponseEntity<ResponseDTO> insert(@Valid @RequestBody DemoDTO demoDTO)
    {
        DemoModel demoModel = service.insert(demoDTO);

        ResponseDTO responseDTO =new ResponseDTO("data inserted!!",demoModel);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
    @GetMapping("/getAll")
    public ResponseEntity<ResponseDTO> getAll()
    {
        List<DemoModel> demoModel = service.getAll();
        ResponseDTO responseDTO =new ResponseDTO("All Details Fetched!!",demoModel);
        return new ResponseEntity<>(responseDTO, HttpStatus.FOUND);
    }
    @PutMapping("/put/{id}")
    public ResponseEntity<ResponseDTO> update(@Valid @RequestBody DemoDTO demoDTO,@PathVariable int id)
    {
        DemoModel demoModel = service.update(demoDTO,id);
        ResponseDTO responseDTO =new ResponseDTO("data updated!!",demoModel);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> delete(@PathVariable int id)
    {
        service.delete(id);
        ResponseDTO responseDTO =new ResponseDTO("data deleted!!","Successfully");
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<ResponseDTO> getByDistrict(@PathVariable int id)
    {
        Optional<DemoModel> demoModel = service.getById(id);
        ResponseDTO responseDTO =new ResponseDTO("Id Founded",demoModel);
        return new ResponseEntity<>(responseDTO, HttpStatus.FOUND);

    }
    @GetMapping("/getByDistrict/{district}")
    public ResponseEntity<ResponseDTO> getByDistrict(@Valid @PathVariable String district)
    {
        DemoModel demoModel = service.getByDistrict(district);
        ResponseDTO responseDTO =new ResponseDTO("District Founded",demoModel);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);

    }
}
