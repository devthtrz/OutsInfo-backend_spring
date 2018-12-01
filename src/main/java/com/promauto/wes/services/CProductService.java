package com.promauto.wes.services;

import com.promauto.wes.exceptions.CProductNotFoundException;
import com.promauto.wes.models.CProduct;
import com.promauto.wes.repository.CProductRepository;
import com.promauto.wes.requests.CProductRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
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

    public List<CProduct> findByName(String name){
        return this.productRepository.findByName(name);
    }
    public List<CProduct> findByNameStartingWith(String name){
        return this.productRepository.findByNameIgnoreCaseStartingWith(name);
    }

    public CProduct findOne(String name) throws CProductNotFoundException {

        final CProduct [] arr=new CProduct[1];
        arr[0]=null;
        findAll().stream().forEach(x -> {if(name.compareTo(x.getName()) == 0){
            arr[0]=x;
        }});


        if(arr[0] != null){
            return arr[0];
        }else{
            throw new CProductNotFoundException(name);
        }
    }
}
