package uz.pdp.market.service.stores;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import uz.pdp.market.dto.stores.StoresCreateDto;
import uz.pdp.market.dto.stores.StoresUpdateDto;
import uz.pdp.market.entity.stores.Stores;
import uz.pdp.market.mapper.stores.StoresMapper;
import uz.pdp.market.repository.stores.StoresRepository;
import uz.pdp.market.response.Response;
import uz.pdp.market.service.AbstractService;
import uz.pdp.market.validator.stores.StoresValidator;

import java.util.List;
import java.util.Optional;

@Service
public class StoresService extends AbstractService<StoresRepository, StoresMapper, StoresValidator> {
    protected StoresService(StoresRepository repository, @Qualifier("storesMapperImpl") StoresMapper mapper, StoresValidator validator) {
        super(repository, mapper, validator);
    }

    public Response create(StoresCreateDto storesCreateDto) {
        Stores stores = mapper.fromCreateDto(storesCreateDto);
        repository.save(stores);
        return new Response("Successfully created", 201);
    }

    public Response delete(Long id) {
        repository.deleteById(id);
        return new Response("Successfully deleted", 200);
    }

    public Response update( StoresUpdateDto storesUpdateDto) {
        Optional<Stores> byId = repository.findById(storesUpdateDto.getId());
        Stores stores1 = mapper.fromUpdateDto(storesUpdateDto);

        repository.save(stores1);

        return new Response("Successfully update", 205);
    }

    public List<Stores> getAll() {
        return repository.findAll();
    }

    public Stores get(Long id) {
        return repository.findById(id).get();
    }
}
