package ru.otus.abstractFabric.sorting;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ChooseSortTest {

    private ChooseSort chooseSort;

    @BeforeAll
    public void init() {
        chooseSort = new ChooseSort();
    }

    @Test
    @DisplayName("метод сортирует массив выбором")
    public void sortTestShouldReturnSortingArrayByChoose() {
        int[] intArray = {9, 3, 8, 2, 0};

        int[] expectedResult = {0, 2, 3, 8, 9};

        int[] sort = chooseSort.sort(intArray);

        assertThat(sort).containsOnly(expectedResult);
    }

}