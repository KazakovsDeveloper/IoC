package ru.otus.abstractFabric.sorting;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import ru.otus.abstractFabric.sorting.MergeSort;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MergeSortTest {

    private MergeSort mergeSort;

    @BeforeAll
    public void init() {
        mergeSort = new MergeSort();
    }

    @Test
    @DisplayName("метод сортирует массив слиянием")
    public void sortTestShouldReturnSortingArrayByMerge() {
        int[] intArray = {9, 3, 8, 2, 0};

        int[] expectedResult = {0, 2, 3, 8, 9};

        int[] sort = mergeSort.sort(intArray);

        assertThat(sort).containsOnly(expectedResult);
    }

}