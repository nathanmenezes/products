package br.com.omotor.produtosapi.resource;

import br.com.omotor.produtosapi.model.ProductDto;
import br.com.omotor.produtosapi.model.ReturnMessage;
import br.com.omotor.produtosapi.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
@RequestMapping("/products")
public class ProductResource {

    @Autowired
    private ProductService service;

    @PostMapping
    public DeferredResult<ResponseEntity<ReturnMessage>> save(@RequestBody @Valid ProductDto product){
        return service.save(product);
    }

}
