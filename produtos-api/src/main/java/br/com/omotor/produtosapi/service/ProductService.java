package br.com.omotor.produtosapi.service;

import br.com.omotor.produtosapi.model.Product;
import br.com.omotor.produtosapi.model.ProductDto;
import br.com.omotor.produtosapi.model.ReturnMessage;
import br.com.omotor.produtosapi.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;


    public DeferredResult<ResponseEntity<ReturnMessage>> save(ProductDto product) {
        final DeferredResult<ResponseEntity<ReturnMessage>> dr = new DeferredResult<>();

        if(repository.existsByName(product.getName()) &&
                repository.existsByPrice(product.getPrice()) &&
                        repository.existsByQuantity(product.getQuantity())){
            dr.setResult(ResponseEntity.status(400).body(new ReturnMessage("Product Already in Database!", product)));
        }

        Product productModel = new Product();
        BeanUtils.copyProperties(product, productModel);
        repository.save(productModel);
        dr.setResult(ResponseEntity.status(201).body(new ReturnMessage("Product Saved!", product)));

        return dr;
    }
}
