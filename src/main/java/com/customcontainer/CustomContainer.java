package com.customcontainer;

/**
 * CustomContainer - универсальный контейнер для хранения произвольных объектов.
 * Реализован на основе односвязного списка для эффективного добавления и удаления элементов.
 * 
 * @param <T> тип элементов, хранящихся в контейнере
 * @author Your Name
 * @version 1.0
 */
public class CustomContainer<T> {
    
    /**
     * Внутренний класс для представления узла списка
     */
    private class Node {
        T data;         // данные узла
        Node next;      // ссылка на следующий узел

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;      // голова списка
    private Node tail;      // хвост списка
    private int size;       // размер контейнера

    /**
     * Создает пустой контейнер
     */
    public CustomContainer() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Добавляет элемент в конец контейнера
     * 
     * @param element элемент для добавления
     */
    public void add(T element) {
        Node newNode = new Node(element);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    /**
     * Добавляет элемент в начало контейнера
     * 
     * @param element элемент для добавления
     */
    public void addFirst(T element) {
        Node newNode = new Node(element);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    /**
     * Удаляет первое вхождение указанного элемента из контейнера
     * 
     * @param element элемент для удаления
     * @return true если элемент был найден и удален, false в противном случае
     */
    public boolean remove(T element) {
        if (isEmpty()) {
            return false;
        }

        // Особый случай: удаление первого элемента
        if (head.data.equals(element)) {
            head = head.next;
            size--;
            if (isEmpty()) {
                tail = null;
            }
            return true;
        }

        // Поиск элемента для удаления
        Node current = head;
        while (current.next != null) {
            if (current.next.data.equals(element)) {
                current.next = current.next.next;
                size--;
                if (current.next == null) {
                    tail = current;
                }
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * Получает элемент по индексу
     * 
     * @param index индекс элемента
     * @return элемент по указанному индексу
     * @throws IndexOutOfBoundsException если индекс выходит за пределы контейнера
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс: " + index + ", Размер: " + size);
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    /**
     * Проверяет, пуст ли контейнер
     * 
     * @return true если контейнер пуст, false в противном случае
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Возвращает количество элементов в контейнере
     * 
     * @return количество элементов
     */
    public int size() {
        return size;
    }

    /**
     * Очищает контейнер
     */
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Проверяет, содержит ли контейнер указанный элемент
     * 
     * @param element элемент для поиска
     * @return true если элемент найден, false в противном случае
     */
    public boolean contains(T element) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(element)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * Возвращает строковое представление контейнера
     * 
     * @return строка с элементами контейнера
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        Node current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}