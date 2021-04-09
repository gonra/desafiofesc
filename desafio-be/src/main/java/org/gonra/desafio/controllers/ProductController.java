package org.gonra.desafio.controllers;

import org.modelmapper.ModelMapper;

import org.gonra.desafio.dto.*;
import org.gonra.desafio.entities.*;
import org.gonra.desafio.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/product")
public class ProductController {

    private IProductService productService;
    private ITypeProductService typeProductService;

    @Autowired
    private void setProducts(IProductService products) {
        this.productService = products;
    }

    @Autowired
    private void setTypeProducts(ITypeProductService typeProductService) {
        this.typeProductService = typeProductService;
    }

    @GetMapping(value = "/")
    public List<ProductDto> getProductList() {
        ModelMapper mapper = new ModelMapper();
        List<Product> p = productService.getList();
        List<ProductDto> result = new ArrayList<>();
        if (p != null) {
            ProductDto[] p2 = mapper.map(p, ProductDto[].class);
            result.addAll(Arrays.asList(p2));
        }

        return result;
    }

    @GetMapping(value = "/types")
    public List<TypeProductDto> getTypeProductList() {
        ModelMapper mapper = new ModelMapper();
        List<TypeProduct> p = typeProductService.getList();
        List<TypeProductDto> result = new ArrayList<>();
        if (p != null) {
            TypeProductDto[] p2 = mapper.map(p, TypeProductDto[].class);
            result.addAll(Arrays.asList(p2));
        }

        return result;
    }

    @PostMapping(value = "/add")
    public ProductDto addProduct(@RequestBody AddProductDto p) {
        return productService.addProductDto(p);
    }

    @PostMapping(value = "/addtype")
    public TypeProductDto addProductType(@RequestBody TypeProductDto pDto) {
        return typeProductService.addTypeProductDto(pDto);
    }

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Long id) {
        return productService.getProductDtoById(id);
    }

    @PostMapping("/{id}")
    public ProductDto updateProduct(@PathVariable Long id, @RequestBody AddProductDto p) {
        return productService.updateProductDto(id, p);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id) {
        productService.deleteProductById(id);
    }

    @DeleteMapping("/types/{id}")
    public void deleteTypeProductById(@PathVariable Long id) {
        typeProductService.deleteTypeProductById(id);
    }
}
