package com.example.demo.service;

import com.example.demo.dto.DemoDTO;
import com.example.demo.exception.DemoException;
import com.example.demo.model.DemoModel;
import com.example.demo.repository.DemoRepository;
import com.example.demo.utility.EmailSenderService;
import com.example.demo.utility.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class DemoService implements  IDemoService
{
    @Autowired
    DemoRepository repo;
    @Autowired
    EmailSenderService send;
    @Autowired
    TokenUtil toke;
    @Override
    public DemoModel insert(DemoDTO demoDTO)
    {
        DemoModel demoModel = new DemoModel(demoDTO);
        repo.save(demoModel);
        String token = toke.createToken(demoModel.getId());
        send.sendEmail("r.ragavendran8198@gmail.com","DEMO-MAIL-TESTING", "\nDISTRICT OF ROCK IS : "+demoModel.getDistrict()+
                                                                                               "\n TOKEN FOR ROCK IS : "+token);
        return demoModel;
    }
    @Override
    public List<DemoModel> getAll()
    {
        List<DemoModel> demoModel = repo.findAll();
        return demoModel;
    }
    @Override
    public DemoModel update(DemoDTO demoDTO,int id)
    {
        DemoModel demoModel = repo.findById(id).get();
        if(repo.findById(id).isPresent())
        {
            demoModel.setDistrict(demoDTO.getDistrict());
            repo.save(demoModel);
            return demoModel;
        }
        else
        {
            throw new DemoException("Id not found to be Updated!!");

        }
    }
    @Override
    public void delete(int id)
    {
        Optional<DemoModel> demoModel =repo.findById(id);
        if(demoModel.isPresent())
        {
            repo.deleteById(id);
        }
        else
        {
            throw new DemoException("Id not found to be deleted!1");

        }
    }
    @Override
    public Optional<DemoModel> getById(int id)
    {
        Optional<DemoModel> demoModel = repo.findById(id);
        if(repo.findById(id).isPresent())
        {
            return demoModel;
        }
        else
        {
            throw new DemoException("Id Not Found!!");
        }
    }
    @Override
    public DemoModel getByDistrict(String district)
    {
        DemoModel demoModel = repo.findByDistrict(district);
        if(demoModel==null)
        {
            throw new DemoException("District Not Found!!");
        }
        else
        {
            return demoModel;
        }
    }
}
