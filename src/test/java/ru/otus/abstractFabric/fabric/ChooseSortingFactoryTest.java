package ru.otus.abstractFabric.fabric;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import ru.otus.abstractFabric.IoC.IOC;
import ru.otus.abstractFabric.sorting.ChooseSort;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ChooseSortingFactoryTest {

    private ChooseSortingFactory chooseSortingFactory;

    @BeforeEach
    public void init() {
        chooseSortingFactory = new ChooseSortingFactory();
        IOC.addToSortingsIoc("chooseSort", new ChooseSort());
    }

    @Test
    @DisplayName("метод находит нужный класс для сортировки и возвращает отсортированный массив")
    public void sortingTestShouldFindSortClassAndReturnSortingArray() {
        int[] intArray = {9, 3, 8, 2, 0};
        assertDoesNotThrow(() -> chooseSortingFactory.sorting(intArray));
    }

}