package org.gonra.desafio.services.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import org.gonra.desafio.dto.*;
import org.gonra.desafio.entities.*;
import org.gonra.desafio.repository.*;
import org.gonra.desafio.services.IProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService {

    private ModelMapper mapper;
    private final ProductRepository productRepository;
    private final TypeProductRepository typeProductRepository;
    private SimpleDateFormat dateFormat;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, TypeProductRepository typeProductRepository) {
        this.productRepository = productRepository;
        this.typeProductRepository = typeProductRepository;
        this.mapper = new ModelMapper();
        this.dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    @Override
    public List<Product> findByParam(Hashtable<String, String> params) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Product addProduct(Product p) {
        return productRepository.save(p);
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.getOne(id);
    }

    @Override
    public Product updateProduct(Product p) {
        return productRepository.save(p);
    }

    @Override
    public int deleteProduct(Product p) {
        if (productRepository.existsById(p.getId())) {
            productRepository.delete(p);
            return 0;
        } else {
            return -1;
        }
    }

    @Override
    public int deleteProductById(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return 0;
        } else {
            return -1;
        }
    }

    @Override
    public List<Product> getList() {
        return productRepository.findAll();
    }

    @Override
    public ProductDto addProductDto(AddProductDto p) {
        Long tpId = p.getTypeProductId();
        Boolean verify = typeProductRepository.existsById(tpId);
        if (verify) {
            Product p1 = mapper.map(p, Product.class);
            p1.setId(null);
            TypeProduct tp1 = typeProductRepository.findById(tpId).get();
            p1.setTypeProduct(tp1);
            p1.setLastupdate(dateFormat.format(new Date()));
            Product p2 = productRepository.save(p1);
            ProductDto pdto = mapper.map(p2, ProductDto.class);
            return pdto;
        }
        return null;
    }

    @Override
    public ProductDto getProductDtoById(Long id) {
        if (productRepository.existsById(id)) {
            Product p = productRepository.getOne(id);
            ProductDto pdto = mapper.map(p, ProductDto.class);
            return pdto;
        }
        return null;
    }

    @Override
    public ProductDto updateProductDto(Long id, AddProductDto p) {
        Product p1 = productRepository.getOne(id);
        if (p1.getId() == id) {
            p1.setCode(p.getCode());
            p1.setDescription(p.getDescription());
            p1.setProviderPrice(p.getProviderPrice());
            p1.setLastupdate(dateFormat.format(new Date()));

            Product p2 = productRepository.save(p1);
            return mapper.map(p2, ProductDto.class);
        }
        return null;
    }

}
