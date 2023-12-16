package com.deevscale.principalapi.mapper;

import com.deevscale.principalapi.entity.BaseEntity;

import java.util.UUID;

public abstract class ResponseMapper<T, E> {

    public abstract T mapToResponse(E entity);


    public UUID mapToId(BaseEntity entity) {
        return entity.getId();
    }

}
