package com.mycompany.mystore.exceptions;

import javax.annotation.Nonnull;
import java.util.Objects;

import static java.util.Objects.requireNonNull;

public class GenericError {

    private final String code;
    private final String description;

    /**
     * @param code
     * @param description
     */
    public GenericError(@Nonnull String code,
                        @Nonnull String description) {
        this.code = requireNonNull(code);
        this.description = requireNonNull(description);
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GenericError)) return false;
        GenericError that = (GenericError) o;
        return code == that.code &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, description);
    }

    @Override
    public String toString() {
        return "GenericError{" +
                "code=" + code +
                ", description='" + description + '\'' +
                '}';
    }
}
