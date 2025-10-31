package com.customcontainer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Модульные тесты для класса CustomContainer
 */
public class CustomContainerTest {
    
    private CustomContainer<String> container;

    @BeforeEach
    void setUp() {
        container = new CustomContainer<>();
    }

    @Test
    void testIsEmptyOnNewContainer() {
        assertTrue(container.isEmpty(), "Новый контейнер должен быть пустым");
        assertEquals(0, container.size(), "Размер нового контейнера должен быть 0");
    }

    @Test
    void testAddAndGet() {
        container.add("Первый");
        container.add("Второй");
        container.add("Третий");

        assertEquals(3, container.size(), "Размер должен быть 3");
        assertEquals("Первый", container.get(0), "Неверный элемент на позиции 0");
        assertEquals("Второй", container.get(1), "Неверный элемент на позиции 1");
        assertEquals("Третий", container.get(2), "Неверный элемент на позиции 2");
    }

    @Test
    void testAddFirst() {
        container.add("Первый");
        container.addFirst("Новый первый");

        assertEquals(2, container.size(), "Размер должен быть 2");
        assertEquals("Новый первый", container.get(0), "Неверный первый элемент");
        assertEquals("Первый", container.get(1), "Неверный второй элемент");
    }

    @Test
    void testRemove() {
        container.add("Первый");
        container.add("Второй");
        container.add("Третий");

        assertTrue(container.remove("Второй"), "Удаление существующего элемента должно вернуть true");
        assertEquals(2, container.size(), "Размер должен быть 2 после удаления");
        assertEquals("Первый", container.get(0), "Неверный первый элемент после удаления");
        assertEquals("Третий", container.get(1), "Неверный второй элемент после удаления");
    }

    @Test
    void testRemoveFromEmptyContainer() {
        assertFalse(container.remove("Элемент"), "Удаление из пустого контейнера должно вернуть false");
    }

    @Test
    void testGetWithInvalidIndex() {
        container.add("Элемент");
        
        assertThrows(IndexOutOfBoundsException.class, () -> container.get(-1),
                "get() с отрицательным индексом должен выбросить исключение");
        assertThrows(IndexOutOfBoundsException.class, () -> container.get(1),
                "get() с индексом >= size должен выбросить исключение");
    }

    @Test
    void testClear() {
        container.add("Первый");
        container.add("Второй");
        
        container.clear();
        assertTrue(container.isEmpty(), "Контейнер должен быть пустым после clear()");
        assertEquals(0, container.size(), "Размер должен быть 0 после clear()");
    }

    @Test
    void testContains() {
        container.add("Первый");
        container.add("Второй");
        
        assertTrue(container.contains("Первый"), "contains() должен вернуть true для существующего элемента");
        assertTrue(container.contains("Второй"), "contains() должен вернуть true для существующего элемента");
        assertFalse(container.contains("Третий"), "contains() должен вернуть false для отсутствующего элемента");
    }

    @Test
    void testToString() {
        assertEquals("[]", container.toString(), "toString() пустого контейнера должен вернуть []");
        
        container.add("Первый");
        container.add("Второй");
        
        assertEquals("[Первый, Второй]", container.toString(), 
                "toString() должен правильно форматировать элементы");
    }
}