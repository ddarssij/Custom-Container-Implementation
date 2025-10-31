# Custom Container Implementation

Проект представляет собой реализацию универсального контейнера для хранения произвольных объектов на Java.

## Особенности

- Реализация на основе односвязного списка
- Поддержка обобщенных типов (generics)
- Полное покрытие unit-тестами
- Документация в формате JavaDoc
- Maven-проект

## Основные операции

- `add(T element)` - добавление элемента в конец
- `addFirst(T element)` - добавление элемента в начало
- `remove(T element)` - удаление элемента
- `get(int index)` - получение элемента по индексу
- `contains(T element)` - проверка наличия элемента
- `size()` - получение размера контейнера
- `isEmpty()` - проверка на пустоту
- `clear()` - очистка контейнера

## Требования

- Java 24
- Maven 3.9.11 или выше

## Сборка проекта

```bash
mvn clean install
```

## Запуск тестов

```bash
mvn test
```

## Структура проекта

```
custom-container/
├── src/
│   ├── main/java/com/customcontainer/
│   │   └── CustomContainer.java
│   └── test/java/com/customcontainer/
│       └── CustomContainerTest.java
├── pom.xml
└── README.md
```

## Использование

```java
// Создание контейнера для строк
CustomContainer<String> container = new CustomContainer<>();

// Добавление элементов
container.add("Первый");
container.add("Второй");
container.addFirst("Новый первый");

// Получение элемента по индексу
String element = container.get(1); // "Первый"

// Удаление элемента
container.remove("Второй");

// Проверка наличия элемента
boolean contains = container.contains("Первый"); // true

// Получение размера
int size = container.size(); // 2
```