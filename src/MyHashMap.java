import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

// Класс, представляющий пару ключ-значение
class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

// Класс HashMap с использованием метода цепочек
public class MyHashMap<K, V> {
    private LinkedList<Pair<K, V>>[] buckets;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;


    // Хеш-функция для вычисления индекса корзины
    private int hash(K key) {
        return Math.abs(key.hashCode() % buckets.length);
    }

    // Метод для добавления элемента в HashMap
    public void put(K key, V value) {
        int index = hash(key);
        LinkedList<Pair<K, V>> bucket = buckets[index];
        for (Pair<K, V> pair : bucket) {
            if (pair.getKey().equals(key)) {
                pair = new Pair<>(key, value); // Перезаписываем значение для существующего ключа
                return;
            }
        }
        bucket.add(new Pair<>(key, value));
        size++;
    }

    // Метод для получения значения по ключу из HashMap
    public V get(K key) {
        int index = hash(key);
        LinkedList<Pair<K, V>> bucket = buckets[index];
        for (Pair<K, V> pair : bucket) {
            if (pair.getKey().equals(key)) {
                return pair.getValue();
            }
        }
        return null;
    }

    // Метод для удаления элемента по ключу из HashMap
    public void remove(K key) {
        int index = hash(key);
        LinkedList<Pair<K, V>> bucket = buckets[index];
        for (Pair<K, V> pair : bucket) {
            if (pair.getKey().equals(key)) {
                bucket.remove(pair);
                size--;
                return;
            }
        }
    }

    // Метод для проверки, содержится ли ключ в HashMap
    public boolean containsKey(K key) {
        int index = hash(key);
        LinkedList<Pair<K, V>> bucket = buckets[index];
        for (Pair<K, V> pair : bucket) {
            if (pair.getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    // Метод для получения размера HashMap
    public int size() {
        return size;
    }

    // Метод для проверки, пуст ли HashMap
    public boolean isEmpty() {
        return size == 0;
    }


    // Для кэширования
    private Map<K, V> cache;
    private int cacheSize;

    public MyHashMap() {
        buckets = new LinkedList[DEFAULT_CAPACITY];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }
        size = 0;

        // Инициализация кэша
        cache = new HashMap<>();
        cacheSize = 5; // Размер кэша по умолчанию
    }

    // Метод для добавления элемента в кэш
    public void addToCache(K key, V value) {
        if (cache.size() >= cacheSize) {
            evictCache(); // Если кэш переполнен, удаляем старые записи
        }
        cache.put(key, value);
    }

    // Метод для получения элемента из кэша
    public V getFromCache(K key) {
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        return null;
    }

    // Метод для удаления элемента из кэша
    public void removeFromCache(K key) {
        cache.remove(key);
    }

    // Метод для очистки кэша
    public void clearCache() {
        cache.clear();
    }

    // Метод для удаления старых записей из кэша (наиболее давно используемые)
    private void evictCache() {
        Queue<K> keysToRemove = new LinkedList<>();
        for (Map.Entry<K, V> entry : cache.entrySet()) {
            keysToRemove.offer(entry.getKey());
            if (keysToRemove.size() > cacheSize / 2) {
                break; // Удаляем половину старых записей
            }
        }
        while (!keysToRemove.isEmpty()) {
            K key = keysToRemove.poll();
            cache.remove(key);
        }
    }
}