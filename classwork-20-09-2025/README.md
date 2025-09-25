# Классная работа 20.09.2025

# 🇬🇧 Git: Базовые команды — объяснения и примеры

## Введение

[**Git**](https://git-scm.com/) — самая распространённая система контроля версий; используется для ведения истории и совместной работы над проектами.

Ниже разъяснены простые, но важные git-команды — последовательность, примеры, рекомендации.

---

## 1. `git clone [адрес]`

**Что делает:**  
Скачивает ("клонирует") внешний репозиторий (например, с GitHub или GitLab) на ваш компьютер.

**Синтаксис:**  
```sh
git clone https://github.com/username/reponame.git
```

**Пример:**  
```sh
git clone https://github.com/torvalds/linux.git
```

После выполнения у вас появится папка с проектом и уже инициализированным git-репозиторием.  
**`git init` делать не надо**, если вы уже сделали clone!

---

## 2. `git init`

**Что делает:**  
Инициализирует новый, локальный git-репозиторий в **текущей папке**.

**Синтаксис:**  
```sh
git init
```

**Пример:**  
```sh
mkdir myproject
cd myproject
git init
```

Создаётся скрытая папка `.git` — теперь любые изменения файлов можно контролировать с помощью git.

---

## 3. `git checkout -b "название_ветки"`

**Что делает:**  
Создаёт **новую ветку** с именем `"название_ветки"` и тут же переключается на неё.

**Синтаксис:**  
```sh
git checkout -b feature/my-new-branch
```

**Пример:**  
```sh
git checkout -b bugfix/login-error
```

**На заметку:**  
*Аналог команды:*  
```sh
git branch bugfix/login-error
git checkout bugfix/login-error
```
но первой командой — быстрее.

---

## 4. `git checkout "название_ветки"`

**Что делает:**  
Переключает на существующую ветку `"название_ветки"`.

**Синтаксис:**  
```sh
git checkout develop
```

**Пример:**  
```sh
git checkout master
```

---

## 5. `git status`

**Что делает:**  
Показывает информацию о текущем состоянии репозитория:
- какие файлы изменены,
- какие не проиндексированы,
- на какой ветке находитесь,
- есть ли конфликтные файлы и т.д.

**Синтаксис:**  
```sh
git status
```

**Пример вывода:**
```
On branch feature/search
Your branch is up to date with 'origin/feature/search'.

Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
        modified:   src/App.java

Untracked files:
  (use "git add <file>..." to include in what will be committed)
        README.md
```

---

## 6. `git add .`

**Что делает:**  
Добавляет **все изменения** (новые, изменённые, удалённые файлы) в область подготовки к коммиту (**staging area**).

**Синтаксис:**  
```sh
git add .
```

**Варианты:**  
- `git add file.txt` — только конкретный файл.
- `git add src/` — только папку.

**Важно:**  
`git add .` не добавит файлы, которые описаны в `.gitignore`.

---

## 7. `git push`

**Что делает:**  
Отправляет все изменения (коммиты), которые вы сделали в своей локальной ветке, на **удалённый репозиторий** (например, на GitHub).

**Синтаксис:**  
```sh
git push
```

**На заметку:**  
Если вы впервые пушите новую ветку, используйте команду из следующего шага👇.

---

## 8. `git push --set-upstream origin "название_ветки"`

**Что делает:**  
Передаёт локальную ветку `"название_ветки"` на удалённый репозиторий (origin) и связывает (настраивает "upstream") её  
— чтобы при следующем `git push` достаточно было писать просто `git push`.

**Синтаксис:**  
```sh
git push --set-upstream origin feature/search
```

**Укороченный вариант (современный git):**
```sh
git push -u origin feature/search
```

**Зачем это нужно?**  
Если ветка ещё не существует на сервере — так вы её создадите и "свяжете".

---

## 9. `git pull`

**Что делает:**  
Подтягивает все изменения с удалённого репозитория в вашу текущую ветку (потом производит слияние изменений — merge).

**Синтаксис:**  
```sh
git pull
```

**На заметку:**
- Если у других участников проекта появились новые коммиты — эта команда стянет их.
- Перед крупным push/merge СТРОГО РЕКОМЕНДУЕТСЯ делать pull, чтобы избежать конфликтов!

---

## 📝 Краткая шпаргалка по шагам

```sh
# Клонируем репозиторий
git clone https://github.com/example/orgrepo.git
cd orgrepo

# Создаём ветку и переходим в неё
git checkout -b feature/my-brilliant-feature

# Работаем с файлами...

# Смотрим, что изменено
git status

# Подготавливаем все изменения к коммиту
git add .

# Делаем коммит
git commit -m "Добавил новую фичу"

# Отправляем ветку на сервер и связываем
git push -u origin feature/my-brilliant-feature

# Если нужны свежие изменения с сервера
git pull
```

---

## ⚡️ Советы

- Делайте небольшие коммиты с осмысленными сообщениями.
- Никогда не работайте в master/main — создайте свою ветку!
- Не забывайте git pull перед началом рабочего дня :)
- Изучите git log, git diff, git restore — пригодятся для анализа.

---

## 📚 Полезные ресурсы

- [Официальная документация Git](https://git-scm.com/doc)
- [GitHub — основной гид](https://docs.github.com/en/get-started/using-git)
- [Интерактивный учебник по Git (ru)](https://learngitbranching.js.org/)

---

# 📚 Основы: Массивы и Функции в Java

---

## 1. Массивы в Java

### Что такое массив?

**Массив** — это структура данных с фиксированной длиной, хранящая значения одного типа (int, double, String и др.) под общим именем.

**Кратко:**  
- Все элементы массива одного типа  
- Длина массива не меняется после создания  
- Индексация начинается с 0

---

### Как объявить массив?

```java
int[] nums;         // Объявление массива целых чисел
String[] names;     // Объявление массива строк
```

---

### Как создать (инициализировать) массив?

```java
nums = new int[5];      // Массив на 5 целых чисел (по умолчанию все 0)
String[] names = new String[3]; // Массив на 3 строки (по умолчанию все null)
```

---

### Как заполнить массив при объявлении?

```java
int[] arr = {1, 5, 10, -3, 8};
String[] colors = {"red", "green", "blue"};
```

---

### Как получить длину массива?

```java
int length = arr.length;         // 5
```

---

### Как обратиться к элементу массива?

```java
System.out.println(arr[2]);     // 10 (индекс 2 — третий элемент)
```

---

### Как изменить значение элемента?

```java
arr[0] = 42;        // Теперь первый элемент равен 42
```

---

### Перебор массива (цикл for):

```java
for (int i = 0; i < arr.length; i++) {
    System.out.println("Элемент " + i + ": " + arr[i]);
}
```

---

## 2. Функции (Методы) в Java

### Что такое функция (метод)?

**Метод** — это фрагмент кода (подпрограмма), который можно вызывать по имени.  
Может принимать аргументы (параметры) и возвращать результат (или ничего).

---

### Общий синтаксис метода

```java
[модификатор] [тип_возврата] имяМетода([аргументы]) {
    // тело метода
    return что-то_или_ничего;
}
```

---

### Пример: простой метод без параметров

```java
public static void sayHello() {
    System.out.println("Привет!");
}
```
Вызов:  
```java
sayHello();       // Выведет "Привет!"
```

---

### Метод с параметрами и возвратом значения

```java
public static int sum(int a, int b) {
    return a + b;
}
```
Вызов:  
```java
int s = sum(2, 5);   // s = 7
```

---

### Использование массивов в параметрах и результатах метода

**Передача массива в функцию:**
```java
public static void printArray(int[] arr) {
    for(int x : arr)
        System.out.print(x + " ");
    System.out.println();
}
```
Вызов:
```java
printArray(arr);
```

**Функция, возвращающая массив:**
```java
public static int[] fillSquares(int n) {
    int[] res = new int[n];
    for(int i=0; i<n; i++)
        res[i] = i * i;
    return res;
}
```
Вызов:
```java
int[] squares = fillSquares(5);  // [0, 1, 4, 9, 16]
```

---

## 3. Пример: Найти максимум в массиве с помощью функции

```java
public static int max(int[] arr) {
    int max = arr[0];
    for(int i=1; i<arr.length; i++) {
        if(arr[i] > max)
            max = arr[i];
    }
    return max;
}

// Использование:
int[] nums = {5, 3, 100, -7, 6};
System.out.println("Максимум: " + max(nums)); // 100
```

---

## 4. Важно помнить!

- В аргументах и возвращаемых значениях может быть любой тип данных: int, double, String, массив и др.

---

## 5. Частые ошибки новичков

- Индексация с 0 (`arr[0]` — первый элемент)
- При выходе за границы массива (`arr[arr.length]`) — будет ошибка
- Длина массива — свойство `.length`, а не метод!  
  (`arr.length`, **НЕ** `arr.length()`)
- Массив после создания нельзя расширить — только создавать новый и копировать.

---

## 6. Дополнительные полезные методы

- `Arrays.toString(arr)` — красиво вывести массив
- `Arrays.sort(arr)` — отсортировать массив
- `Arrays.copyOf(arr, newLength)` — скопировать с изменением размера

---

### Пример:
```java
import java.util.Arrays;

int[] arr = {2, 7, 1};
Arrays.sort(arr);                  // теперь arr: {1, 2, 7}
System.out.println(Arrays.toString(arr));  // [1, 2, 7]
```

---

## 7. Общий шаблон программы

```java
public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};

        printArray(nums);
        int m = max(nums);
        System.out.println("Максимум: " + m);
    }
    public static void printArray(int[] arr) { /* ... */ }
    public static int max(int[] arr) { /* ... */ }
}
```

---

## 8. Рекомендации для изучения

- Официальный Java Tutorial: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html
- [JavaRush — массивы и методы (ru)](https://javarush.com/groups/posts/masivji-v-java)
- Экспериментируйте в [onlinegdb.com/online_java_compiler](https://www.onlinegdb.com/online_java_compiler) или [repl.it](https://replit.com/~)

---