package example5;

import java.util.ArrayList;
import java.util.List;

public class MyMapImpl<K, V> implements MyMap<K, V> {

    private List<KeyValuePair<K, V>> list;

    public MyMapImpl() {
        list = new ArrayList<>();
    }

    @Override
    public void put(K key, V value) {
        KeyValuePair<K, V> optionalPair = null;
        for(KeyValuePair<K, V> pair : list) {
            if(pair.key.equals(key)) {
                optionalPair = pair;
            }
        }
        if(optionalPair != null) {
            // Ключ существовал
            optionalPair.value = value;
        } else {
            // Создаём
            KeyValuePair<K, V> newPair = new KeyValuePair<>();
            newPair.key = key;
            newPair.value = value;
            list.add(newPair);
        }
    }

    @Override
    public V get(K key) {
        for(KeyValuePair<K, V> pair : list) {
            if(pair.key.equals(key)) {
                return pair.value;
            }
        }
        return null;
    }

    @Override
    public boolean containsKey(K key) {
        for(KeyValuePair<K, V> pair : list) {
            if(pair.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return list.size();
    }
}
