package ru.otus.abstractFabric;

import ru.otus.abstractFabric.fabric.AbstractFactory;

public class NotKnownSort implements AbstractFactory {
    @Override
    public int[] sorting(int[] array) {
        return new int[0];
    }
}
