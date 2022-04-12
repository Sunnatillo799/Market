package uz.pdp.market.service.sales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.pdp.market.dto.sales.SalesCreateDto;
import uz.pdp.market.mapper.sales.SalesMapper;
import uz.pdp.market.repository.sales.SalesRepository;
import uz.pdp.market.response.Response;
import uz.pdp.market.service.AbstractService;
import uz.pdp.market.validator.sales.SalesValidator;

import javax.transaction.Transactional;

@Service
@Transactional
public class SalesService extends AbstractService<SalesRepository, SalesMapper, SalesValidator> {

    @Autowired
    protected SalesService(SalesRepository repository, SalesMapper mapper, SalesValidator validator) {
        super(repository, mapper, validator);
    }

    public ResponseEntity<Response> create(SalesCreateDto salesCreateDto) {
        return ResponseEntity.ok(new Response("Ok", 200));
    }
}
