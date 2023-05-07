package ru.otus.abstractFabric.IoC;

import ru.otus.abstractFabric.fabric.AbstractFactory;
import ru.otus.abstractFabric.sorting.Sort;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.isNull;

public class IOC {

    private static final Map<String, Sort> sortings = new HashMap<>();
    private static final Map<String, AbstractFactory> fabrics = new HashMap<>();

    public static void addToSortingsIoc(String sortingName, Sort sortingMethod) {
        sortings.put(sortingName, sortingMethod);
    }

    public static Sort getFromSortingsIoc(String sortingName) {
        Sort sort = sortings.get(sortingName);
        if (isNull(sort)) {
            throw new RuntimeException(sortingName + " обработчика для такой сортировки не найдено");
        }
        return sort;
    }

    public static void addToFabricsIoc(String sortName, AbstractFactory factory) {
        fabrics.put(sortName, factory);
    }

    public static AbstractFactory getFromFabricsIoc(String sortName) {
        AbstractFactory abstractFactory = fabrics.get(sortName);
        if (isNull(abstractFactory)) {
            throw new RuntimeException(sortName + " обработчика для такой сортировки не найдено");
        }
        return abstractFactory;
    }
}
