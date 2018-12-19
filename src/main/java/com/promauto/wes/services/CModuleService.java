package com.promauto.wes.services;

import com.promauto.wes.exceptions.CModuleNotFoundException;
import com.promauto.wes.models.CModule;
import com.promauto.wes.repositories.CModuleRepository;
import com.promauto.wes.requests.CModuleRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
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

        public CModule findByName(String name){
            return this.moduleRepository.findByName(name).get(0);
        }
        public List<CModule> findByNameStartingWith(String name){
            return this.moduleRepository.findByNameIgnoreCaseStartingWith(name);
        }
}
