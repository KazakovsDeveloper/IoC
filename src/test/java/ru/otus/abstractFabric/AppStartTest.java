package ru.otus.abstractFabric;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import ru.otus.abstractFabric.IoC.IOC;
import ru.otus.abstractFabric.fabric.ChooseSortingFactory;
import ru.otus.abstractFabric.fabric.FillSortingFactory;
import ru.otus.abstractFabric.fabric.MergeSortingFactory;
import ru.otus.abstractFabric.sorting.ChooseSort;
import ru.otus.abstractFabric.sorting.FillSort;
import ru.otus.abstractFabric.sorting.MergeSort;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AppStartTest {

    private IOC ioc;
    private AppStart appStart;

    @BeforeAll
    public void init() {
        ioc = new IOC();
        IOC.addToFabricsIoc("chooseSort", new ChooseSortingFactory());
        IOC.addToFabricsIoc("fillSort", new FillSortingFactory());
        IOC.addToFabricsIoc("mergeSort", new MergeSortingFactory());
        IOC.addToSortingsIoc("chooseSort", new ChooseSort());
        IOC.addToSortingsIoc("fillSort", new FillSort());
        IOC.addToSortingsIoc("mergeSort", new MergeSort());
        appStart = new AppStart(ioc);
    }

    @Test
    @DisplayName("метод читает файл и возвращает массив чисел для сортировки")
    public void readFileTestShouldReturnIntArray() {
        int[] ints = appStart.readFile("testSort.txt");
        assertEquals(50, ints.length);
    }

    @Test
    @DisplayName("метод кидает исключение, если нет файла для чтения")
    public void readFileTestShouldThrowsExceptionIfFileDoesNotExist() {
        assertThrows(RuntimeException.class, () -> appStart.readFile("test.txt"));
    }

    @Test
    @DisplayName("метод записывает результат в файл")
    public void writeToFileTestShouldSuccessWriteResultIntoFile() {
        int[] array = {1, 2, 3};
        assertDoesNotThrow(() -> appStart.writeToFile(new ChooseSortingFactory(), array, "mua"));
    }

    @Test
    @DisplayName("метод выбирает название \"Сортировка выбором\" для записи в файл")
    public void getTypeOfSortingTestShouldReturnChooseSorting() {
        String typeOfSorting = appStart.getTypeOfSorting(new ChooseSortingFactory());
        assertEquals("Сортировка выбором", typeOfSorting);
    }

    @Test
    @DisplayName("метод выбирает название \"Сортировка вставкой\" для записи в файл")
    public void getTypeOfSortingTestShouldReturnFillSorting() {
        String typeOfSorting = appStart.getTypeOfSorting(new FillSortingFactory());
        assertEquals("Сортировка вставкой", typeOfSorting);
    }

    @Test
    @DisplayName("метод выбирает название \"Сортировка слиянием\" для записи в файл")
    public void getTypeOfSortingTestShouldReturnMergeSorting() {
        String typeOfSorting = appStart.getTypeOfSorting(new MergeSortingFactory());
        assertEquals("Сортировка слиянием", typeOfSorting);
    }

    @Test
    @DisplayName("метод выбирает название \"Неизвестный тип сортировки\" для записи в файл")
    public void getTypeOfSortingTestShouldReturnDNotKnowingType() {
        String typeOfSorting = appStart.getTypeOfSorting(new NotKnownSort());
        assertEquals("Неизвестный тип сортировки", typeOfSorting);
    }

    @Test
    @DisplayName("метод сортирует данные из файла при помощи слияния")
    public void startSortTestShouldSortingArrayFromFileByMergeSort() {
        assertDoesNotThrow(() -> appStart.startSort("mergeSort", "testSort.txt", "testForMerge"));
    }

    @Test
    @DisplayName("метод сортирует данные из файла при помощи выбора")
    public void startSortTestShouldSortingArrayFromFileByChooseSort() {
        assertDoesNotThrow(() ->  appStart.startSort("chooseSort", "testSort.txt", "testForChoose"));
    }

    @Test
    @DisplayName("метод сортирует данные из файла при помощи вставки")
    public void startSortTestShouldSortingArrayFromFileByFillSort() {
        assertDoesNotThrow(() ->  appStart.startSort("fillSort", "testSort.txt", "testForFill"));
    }

}