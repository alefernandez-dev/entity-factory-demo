package dev.alejandro.util;

import java.io.Serializable;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Function;

public abstract class Result<F, S> implements Serializable {

    private Result() {
    }

    public static <F, S> Result<F, S> success(S success) {
        return new Success<>(success);
    }

    public static <F, S> Result<F, S> failure(F failure) {
        return new Failure<>(failure);
    }

    public abstract S getSuccess();

    public abstract F getFailure();

    public abstract boolean isSuccess();

    public abstract boolean isFailure();

    public final <U> U fold(Function<? super F, ? extends U> failureMapper, Function<? super S, ? extends U> successMapper) {
        Objects.requireNonNull(failureMapper, "failureMapper must not be null");
        Objects.requireNonNull(successMapper, "successMapper must not be null");
        if(isFailure()) {
            return failureMapper.apply(getFailure());
        }
        return successMapper.apply(getSuccess());
    }

    private static final class Success<F, S> extends Result<F, S> implements Serializable {

        private final S success;

        private Success(S success) {
            this.success = success;
        }

        @Override
        public S getSuccess() {
            return success;
        }

        @Override
        public F getFailure() {
            throw new NoSuchElementException("Cannot obtain Failure value on Success class");
        }

        @Override
        public boolean isSuccess() {
            return true;
        }

        @Override
        public boolean isFailure() {
            return false;
        }

        @Override
        public String toString() {
            return "Success("+success+")";
        }
    }

    private static final class Failure<F, S> extends Result<F, S> implements Serializable {

        private final F failure;

        private Failure(F failure) {
            this.failure = failure;
        }

        @Override
        public S getSuccess() {
            throw new NoSuchElementException("Cannot obtain Success value on Failure class");
        }

        @Override
        public F getFailure() {
            return failure;
        }

        @Override
        public boolean isSuccess() {
            return false;
        }

        @Override
        public boolean isFailure() {
            return true;
        }

        @Override
        public String toString() {
            return "Failure("+failure+")";
        }
    }
}
