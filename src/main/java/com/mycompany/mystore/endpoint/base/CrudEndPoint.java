package com.mycompany.mystore.endpoint.base;

import javax.annotation.Nonnull;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

/**
 * Generic and basic End point Contract!
 *
 * @param <PK>
 * @param <T>
 */
public interface CrudEndPoint<T, PK> {

    T get(@Nonnull PK pk);

    Set<T> getAll();

    Set<T> getByName(@NotEmpty String filter);
}
