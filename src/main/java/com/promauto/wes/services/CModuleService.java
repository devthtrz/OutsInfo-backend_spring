package com.promauto.wes.services;

import com.promauto.wes.exceptions.CModuleNotFoundException;
import com.promauto.wes.models.CModule;
import com.promauto.wes.repository.CModuleRepository;
import com.promauto.wes.requests.CModuleRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class CModuleService { 
    private final CModuleRepository moduleRepository;

        public CModuleService(CModuleRepository moduleRepository) {
            this.moduleRepository = moduleRepository;
        }

        @Transactional
        public CModule update(CModule module){
            return this.moduleRepository.save(module);
        }

        @Transactional
        public CModule create(CModuleRequest request){
            CModule module = new CModule();
            module.setName(request.getName());
            return this.moduleRepository.save(module);
        }

        @Transactional
        public void delete(String id){
            final Optional<CModule> module = this.moduleRepository.findById(id);
            module.ifPresent(this.moduleRepository::delete);
        }

        public List<CModule> findAll(){
            return this.moduleRepository.findAll();
        }

        public List<CModule> findByName(String name){
            return this.moduleRepository.findByName(name);
        }
        public List<CModule> findByNameStartingWith(String name){
            return this.moduleRepository.findByNameIgnoreCaseStartingWith(name);
        }

        public CModule findOne(String name) throws CModuleNotFoundException {

            final CModule [] arr=new CModule[1];
            arr[0]=null;
            findAll().stream().forEach(x -> {if(name.compareTo(x.getName()) == 0){
                arr[0]=x;
            }});


            if(arr[0] != null){
                return arr[0];
            }else{
                throw new CModuleNotFoundException(name);
            }
        }
}
