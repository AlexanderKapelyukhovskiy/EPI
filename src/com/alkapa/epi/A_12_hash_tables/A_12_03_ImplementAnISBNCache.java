package com.alkapa.epi.A_12_hash_tables;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class A_12_03_ImplementAnISBNCache {
    private static class LruCache {
        private LinkedHashMap<Integer, Integer> map;
        public LruCache(int capacity) {
            map = new LinkedHashMap<>(capacity, 1.0f ,true) {
                @Override
                protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                    return this.size() > capacity;
                }
            };
        }

        public void insert(Integer key, Integer value) {
            map.putIfAbsent(key, value);
        }

        public Integer lookup(Integer key) {
            return map.getOrDefault(key, -1);
        }

        public Boolean erase(Integer key) {
            return map.remove(key) != null;
        }
    }

    private static class MyLinkedList {
        public MyLinkedList prev, next;
        public Integer value;

        public MyLinkedList(MyLinkedList prev, MyLinkedList next, Integer value) {
            this.prev = prev;
            this.next = next;
            this.value = value;
        }
    }

    private static class MyLruCache extends LruCache{
        MyLinkedList head = null;
        MyLinkedList tail = null;
        HashMap<Integer, MyLinkedList> map;
        Integer capacity;

        public MyLruCache(Integer capacity) {
            super(capacity);
            map = new HashMap<>(capacity);
            this.capacity = capacity;
        }

        @Override
        public void insert(Integer key, Integer value) {
            if (lookup(key) != -1) {
                return;
            }
            if (map.size() == capacity) {
                //remove last;
                map.remove(tail.value);
                tail = tail.prev;
                tail.next = null;
            }
            MyLinkedList newHead = new MyLinkedList(null, head, value);
            if (head != null) {
                head.prev = newHead;

            }

            head = newHead;

            if (tail == null) {
                tail = head;
            }
            map.put(key, newHead);
        }

        @Override
        public Integer lookup(Integer key) {
            MyLinkedList existingItem = map.get(key);
            if (existingItem != null) {
                if (existingItem == head) {
                    //item is already first
                    return head.value;
                }
                //remove the found item from the current position in the linked list
                existingItem.prev.next = existingItem.next;
                if (existingItem.next != null) {
                    existingItem.next.prev = existingItem.prev;
                }
                //place the found item to the head of the linked list
                existingItem.next = head;
                if (head != null) {
                    head.prev = existingItem;
                }
                head = existingItem;
                return head.value;
            }
            return -1;
        }

        @Override
        public Boolean erase(Integer key) {
            if (map.size() == 0) {
                return false;
            }
            MyLinkedList existingItem = map.get(key);
            if (existingItem == null) {
                return false;
            }

            map.remove(existingItem.value);
            if (existingItem != head && existingItem != tail) {
                existingItem.prev.next = existingItem.next;
                existingItem.next.prev = existingItem.prev;
            }
            if (existingItem == head) {
                head = head.next;
                if (head != null) {
                    head.prev = null;
                }
            }
            if (existingItem == tail) {
                tail = tail.prev;
                if (tail != null) {
                    tail.next = null;
                }
            }

            return true;
        }
    }

    public static LruCache create(int capacity){
        return new LruCache(capacity);
        //return new MyLruCache(capacity);
    }

    public static void main (String[] args) {
        LruCache lruCache = create(3);
        lruCache.insert(1,1);
        lruCache.insert(2,2);
        lruCache.insert(3,3);

        Integer val = lruCache.lookup(2);
        System.out.println(val);

        val = lruCache.lookup(3);
        System.out.println(val);

        lruCache.insert(4,4);

        val = lruCache.lookup(1);
        System.out.println(val);

        lruCache = create(3);
        lruCache.insert(1,1);
        System.out.println(lruCache.erase(2));
        System.out.println(lruCache.erase(1));
        System.out.println(lruCache.erase(2));

        lruCache = create(3);
        lruCache.insert(1,1);
        lruCache.insert(3,3);
        System.out.println(lruCache.erase(1));

        lruCache = create(3);
        lruCache.insert(1,1);
        lruCache.insert(3,3);
        System.out.println(lruCache.erase(3));

        lruCache = create(3);
        lruCache.insert(1,1);
        lruCache.insert(2,2);
        lruCache.insert(3,3);
        System.out.println(lruCache.erase(2));
    }
}
