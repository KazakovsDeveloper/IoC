package ru.otus.abstractFabric;

import ru.otus.abstractFabric.IoC.IOC;
import ru.otus.abstractFabric.fabric.AbstractFactory;

import java.io.*;
import java.util.Arrays;

import static java.util.Objects.isNull;

public class AppStart {

    private final IOC ioc;

    public AppStart(IOC ioc) {
        this.ioc = ioc;
    }

    public void startSort(String typeOfSort, String inputFileName, String outputFileName) {
        AbstractFactory factoryForSorting = IOC.getFromFabricsIoc(typeOfSort);
        if (isNull(factoryForSorting)) {
            throw new RuntimeException("Нет подходящего обработчика для данного метода сортировки");
        }
        // читаем файл и передаем дальше массив
        int[] array = readFile(inputFileName);
        int[] sortingArray = factoryForSorting.sorting(array);
        // пишем в файл
        writeToFile(factoryForSorting, sortingArray, outputFileName);
    }

    int[] readFile(String fileName) {
        String file = AppStart.class.getClassLoader().getResource(fileName).getFile();
        String str;
        StringBuilder strb = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((str = br.readLine()) != null) {
                strb.append(str).append(" ");
            }
        } catch (FileNotFoundException f) {
            throw new RuntimeException(fileName + " не найден");
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] strings = strb.toString().split(" ");
        return Arrays.stream(strings)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    void writeToFile(AbstractFactory factory, int[] sortingArray, String fileName) {
        try (PrintWriter writer = new PrintWriter(fileName)) {
            String typeOfSorting = getTypeOfSorting(factory);
            writer.write(typeOfSorting + "\n");
            for (int j : sortingArray) {
                writer.write(j + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    String getTypeOfSorting(AbstractFactory abstractFactory) {
        String simpleName = abstractFactory.getClass().getSimpleName();
        return switch (simpleName) {
            case "ChooseSortingFactory" -> "Сортировка выбором";
            case "FillSortingFactory" -> "Сортировка вставкой";
            case "MergeSortingFactory" -> "Сортировка слиянием";
            default -> "Неизвестный тип сортировки";
        };
    }

}
