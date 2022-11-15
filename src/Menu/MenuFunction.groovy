package Menu

@FunctionalInterface
interface MenuFunction<T> {
    void command(T obj)
}