package com.mycompany.mystore.endpoint;

import javax.annotation.Nonnull;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

/**
 * Generic and basic End point Contract!
 * @param <PK>
 * @param <T>
 */
public interface EndPoint<PK,T> {

    T get(@Nonnull PK pk);

    Set<T> getAll();

    Set<T> getByName(@NotEmpty String filter);
}
