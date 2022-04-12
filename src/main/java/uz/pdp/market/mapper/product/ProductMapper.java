package uz.pdp.market.mapper.product;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.pdp.market.dto.product.ProductCreateDto;
import uz.pdp.market.dto.product.ProductDto;
import uz.pdp.market.dto.product.ProductUpdateDto;
import uz.pdp.market.entity.product.Product;
import uz.pdp.market.mapper.BaseMapper;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface ProductMapper extends BaseMapper<Product, ProductDto, ProductCreateDto, ProductUpdateDto> {
    @Override
    ProductDto toDto(Product product);

    @Override
    List<ProductDto> toDto(List<Product> e);

    @Override
    Product fromCreateDto(final ProductCreateDto productCreateDto);

    @Override
    Product fromUpdateDto(final ProductUpdateDto productUpdateDto);
}