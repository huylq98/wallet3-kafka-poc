package vn.com.viettel.vds.wallet3.kycmanagement.mapper;

import java.util.List;

public interface EntityMapper<Q, E, P> {

    E toEntity(Q request);

    P toDTO(E entity);

    List<P> toDTOs(List<E> entity);
}
