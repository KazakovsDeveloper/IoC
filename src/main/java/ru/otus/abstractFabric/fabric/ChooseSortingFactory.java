package ru.otus.abstractFabric.fabric;

import ru.otus.abstractFabric.IoC.IOC;
import ru.otus.abstractFabric.sorting.Sort;

public class ChooseSortingFactory implements AbstractFactory {

    @Override
    public int[] sorting(int[] array) {
        Sort chooseSort = IOC.getFromSortingsIoc("chooseSort");
        // передаем массив на сортировку в метод
        // получаем обратно отсортированный массив
        return chooseSort.sort(array);
    }
}
