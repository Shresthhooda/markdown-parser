import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.*;
import java.util.*;
import java.util.Hashtable;
import java.util.Map;
import java.util.HashMap;
interface Hasher { int hash(K key); }

class HashTable<K,V> {
  class Entry {
    
    K k; V v;
    public Entry(K k, V v) { this.k = k; this.v = v; }
  }
  List[] buckets; // An array of Lists of Entries
  int size;
  Hasher hasher;

  

  public HashTable(Hasher h, int startCapacity) {
    this.size = 0;
    this.hasher = h;
    this.buckets = (List[])(new List[startCapacity]);
  }

  public double loadFactor() { return (double)(this.size) / this.buckets.length; }

  public V get(K k) {
    int hashCode = this.hasher.hash(k);
    int index = hashCode % this.buckets.length;
    if(this.buckets[index] == null) {
      return null;
    }
    else {
      for(Entry e: this.buckets[index]) {
        if(e.k.equals(k)) { return e.v; }
      }
      return null;
    }
  }

  public void set(K k, V v) {
    int hashCode = this.hasher.hash(k);
    int index = hashCode % this.buckets.length;
    if(this.buckets[index] == null) {
      this.buckets[index] = new ArrayList();
      this.buckets[index].add(new Entry(k, v));
    }
    else {
      for(Entry e: this.buckets[index]) {
        if(e.k.equals(k)) { e.v = v; return; }
      }
      this.buckets[index].add(new Entry(k, v));
    }
    this.size += 1;
  }

}
class HasherA implements Hasher<String> {
    int i;
    public HasherA() { this.i = 0; }
    public int hash(String s) { i += 1; return s.length() + i; }
  }
  
  class HasherB implements Hasher<String> {
    public int hash(String s) { return Character.codePointAt(s, 0); }
  }
  
  class tester {
    public static void main(String[] args) {
      HashTable<String, Integer> ht = new HashTable<>(new HasherA(), 6);
      ht.set("first", 100);
      System.out.println(ht.size);
  
    }
  }