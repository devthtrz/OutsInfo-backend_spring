package com.promauto.wes.services;

import com.promauto.wes.exceptions.CMainNotFoundException;
import com.promauto.wes.models.CMain;
import com.promauto.wes.repository.CMainRepository;
import com.promauto.wes.requests.CMainRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class CMainService {
    private final CMainRepository mainRepository;

    public CMainService(CMainRepository repository){
        this.mainRepository = repository;
    }

    @Transactional
    public CMain update(CMain module){
        return this.mainRepository.save(module);
    }

    @Transactional
    public CMain create(CMainRequest request){
        CMain module = new CMain();
        module.setName(request.getName());
        return this.mainRepository.save(module);
    }

    @Transactional
    public void delete(String id){
        final Optional<CMain> module = this.mainRepository.findById(id);
        module.ifPresent(this.mainRepository::delete);
    }

    public List<CMain> findAll(){
        return this.mainRepository.findAll();
    }

    public List<CMain> findByName(String name){
        return this.mainRepository.findByName(name);
    }
    public List<CMain> findByNameStartingWith(String name){
        return this.mainRepository.findByNameIgnoreCaseStartingWith(name);
    }

    public CMain findOne(String name) throws CMainNotFoundException {

        final CMain [] arr=new CMain[1];
        arr[0]=null;
        findAll().stream().forEach(x -> {if(name.compareTo(x.getName()) == 0){
            arr[0]=x;
        }});


        if(arr[0] != null){
            return arr[0];
        }else{
            throw new CMainNotFoundException(name);
        }
    }

}
