package ru.otus.abstractFabric.fabric;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import ru.otus.abstractFabric.IoC.IOC;
import ru.otus.abstractFabric.sorting.FillSort;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FillSortingFactoryTest {

    private FillSortingFactory fillSortingFactory;

    @BeforeEach
    public void init() {
        fillSortingFactory = new FillSortingFactory();
        IOC.addToSortingsIoc("fillSort", new FillSort());
    }

    @Test
    @DisplayName("метод находит нужный класс для сортировки и возвращает отсортированный массив")
    public void sortingTestShouldFindSortClassAndReturnSortingArray() {
        int[] intArray = {9, 3, 8, 2, 0};
        assertDoesNotThrow(() -> fillSortingFactory.sorting(intArray));
    }

}