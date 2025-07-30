package com.classicmodels.classicmodels.service.product;

import com.classicmodels.classicmodels.DTOs.ProductDTO;
import com.classicmodels.classicmodels.entities.Product;
import com.classicmodels.classicmodels.entities.Productline;
import com.classicmodels.classicmodels.repository.ProductRepository;
import com.classicmodels.classicmodels.repository.ProductlineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImplementation implements ProductService {

    private final ProductRepository productRepository;
    private final ProductlineRepository productlineRepository;

    // ✅ Get all products as DTOs
    @Override
    public List<ProductDTO> findAll() {
        return productRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // ✅ Find a product by its ID and return as DTO (if present)
    @Override
    public Optional<ProductDTO> findById(String productCode) {
        return productRepository.findById(productCode)
                .map(this::convertToDTO);
    }

    // ✅ Save a new product (convert DTO to entity before saving)
    @Override
    public ProductDTO save(ProductDTO dto) {
        Product product = convertToEntity(dto);
        Product saved = productRepository.save(product);
        return convertToDTO(saved);
    }

    @Override
    public ProductDTO updateProduct(String productCode, ProductDTO productDTO) {
        Product existingProduct = productRepository.findById(productCode)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Productline productline = productlineRepository.findById(productDTO.getProductLine())
                .orElseThrow(() -> new RuntimeException("Product line not found"));

        // Update fields from DTO only
        existingProduct.setProductName(productDTO.getProductName());
        existingProduct.setProductLine(productline);
        existingProduct.setQuantityInStock(productDTO.getQuantityInStock());
        existingProduct.setBuyPrice(productDTO.getBuyPrice());
        existingProduct.setProductScale(productDTO.getProductScale());
        existingProduct.setProductVendor(productDTO.getProductVendor());
//        existingProduct.setProductDescription(productDTO.getProductDescription());
        existingProduct.setMsrp(productDTO.getMsrp());

        // Save and return
        Product saved = productRepository.save(existingProduct);
        return convertToDTO(saved);
    }


    // ✅ Delete by ID
    @Override
    public void deleteById(String productCode) {
        productRepository.deleteById(productCode);
    }

    // 🔁 Convert ENTITY to DTO
    private ProductDTO convertToDTO(Product product) {
        return new ProductDTO(
                product.getProductCode(),
                product.getProductName(),
                product.getProductLine().getProductLine(),// only the String
                product.getProductScale(),
                product.getProductVendor(),
//                product.getProductDescription(),
                product.getQuantityInStock(),
                product.getBuyPrice(),
                product.getMsrp()
        );
    }

    // 🔁 Convert DTO back to ENTITY
    private Product convertToEntity(ProductDTO dto) {
        Product product = new Product();
        product.setProductCode(dto.getProductCode());
        product.setProductName(dto.getProductName());

        // We need to set a Productline object because it's a relationship
        Productline productLine = new Productline();
        productLine.setProductLine(dto.getProductLine()); // only set the ID
        product.setProductLine(productLine);

        product.setProductScale(dto.getProductScale());
        product.setProductVendor(dto.getProductVendor());
        product.setProductDescription("Product Description");
        product.setQuantityInStock(dto.getQuantityInStock());
        product.setBuyPrice(dto.getBuyPrice());
        product.setMsrp(dto.getMsrp());;




        return product;
    }
}

