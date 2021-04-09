package org.gonra.desafio.services;

import org.gonra.desafio.dto.*;
import org.gonra.desafio.entities.*;
import java.util.*;

public interface IProductService {

    public List<Product> findByParam(Hashtable<String, String> params);

    public Product addProduct(Product p);

    public ProductDto addProductDto(AddProductDto p);

    public Product getProductById(Long id);

    public List<Product> getList();

    public Product updateProduct(Product p);

    public int deleteProduct(Product p);

    public int deleteProductById(Long id);

    public ProductDto getProductDtoById(Long id);

    public ProductDto updateProductDto(Long id, AddProductDto p);

}
