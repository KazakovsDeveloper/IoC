package ru.otus.abstractFabric.sorting;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import ru.otus.abstractFabric.sorting.FillSort;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FillSortTest {

    private FillSort fillSort;

    @BeforeAll
    public void init() {
        fillSort = new FillSort();
    }

    @Test
    @DisplayName("метод сортирует массив вставкой")
    public void sortTestShouldReturnSortingArrayByFill() {
        int[] intArray = {9, 3, 8, 2, 0};

        int[] expectedResult = {0, 2, 3, 8, 9};

        int[] sort = fillSort.sort(intArray);

        assertThat(sort).containsOnly(expectedResult);
    }

}