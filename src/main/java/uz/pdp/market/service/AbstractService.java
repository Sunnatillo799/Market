package uz.pdp.market.service;

import uz.pdp.market.mapper.Mapper;
import uz.pdp.market.repository.AbstractRepository;
import uz.pdp.market.validator.Validator;

public abstract class AbstractService<
        R extends AbstractRepository,
        M extends Mapper,
        V extends Validator
        > implements BaseService {
    protected final R repository;
    protected final M mapper;
    protected final V validator;

    protected AbstractService(R repository, M mapper, V validator) {
        this.repository = repository;
        this.mapper = mapper;
        this.validator = validator;
    }
}
