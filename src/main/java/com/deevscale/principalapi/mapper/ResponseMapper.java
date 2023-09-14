package com.deevscale.principalapi.mapper;

public interface ResponseMapper<T,Y> {

    T mapToResponse(Y entity);

}
