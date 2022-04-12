package uz.pdp.market.mapper;

import java.util.List;

public interface BaseMapper<E, D, CD, UD> extends Mapper {
    D toDto(E e);

    List<D> toDto(List<E> e);

    E fromCreateDto(final CD cd);

    E fromUpdateDto(final UD ud);
}
