package io.github.nathanjrussell.betterNumber;

public interface BetterNumber<T> {
    public T add(T other);
    public T additiveInverse();
    public T multiply(T other);
}
