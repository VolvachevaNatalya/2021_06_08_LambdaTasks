package project;

@FunctionalInterface
public interface TernaryIntPredicate<T> {
    boolean test (T x,T y,T z);
}
