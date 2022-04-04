package uz.pdp.market.mapper.product;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import uz.pdp.market.dto.product.ProductCreateDto;
import uz.pdp.market.dto.product.ProductDto;
import uz.pdp.market.dto.product.ProductUpdateDto;
import uz.pdp.market.entity.product.Product;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-04T22:48:27+0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDto toDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        return productDto;
    }

    @Override
    public List<ProductDto> toDto(List<Product> e) {
        if ( e == null ) {
            return null;
        }

        List<ProductDto> list = new ArrayList<ProductDto>( e.size() );
        for ( Product product : e ) {
            list.add( toDto( product ) );
        }

        return list;
    }

    @Override
    public Product fromCreateDto(ProductCreateDto productCreateDto) {
        if ( productCreateDto == null ) {
            return null;
        }

        Product product = new Product();

        return product;
    }

    @Override
    public Product fromUpdateDto(ProductUpdateDto productUpdateDto) {
        if ( productUpdateDto == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( productUpdateDto.getId() );

        return product;
    }
}
