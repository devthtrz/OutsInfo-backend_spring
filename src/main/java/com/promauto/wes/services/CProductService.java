package com.promauto.wes.services;

import com.promauto.wes.models.CProduct;
import com.promauto.wes.repositories.CProductRepository;
import com.promauto.wes.requests.CProductRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CProductService {
    private final CProductRepository productRepository;

    public CProductService(CProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public CProduct update(CProduct module){
        return this.productRepository.save(module);
    }

    @Transactional
    public CProduct create(CProductRequest request){
        CProduct module = new CProduct();
        module.setName(request.getName());
        return this.productRepository.save(module);
    }

    @Transactional
    public void delete(String id){
        final Optional<CProduct> module = this.productRepository.findById(id);
        module.ifPresent(this.productRepository::delete);
    }

    public List<CProduct> findAll(){
        return this.productRepository.findAll();
    }

    public CProduct findByName(String name){
        return this.productRepository.findByName(name).get(0);
    }

    public List<CProduct> findByNameStartingWith(String name){
        return this.productRepository.findByNameIgnoreCaseStartingWith(name);
    }

}
