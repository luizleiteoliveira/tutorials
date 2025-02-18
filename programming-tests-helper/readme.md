# Java Data Structures Overview

## 1. List
- Ordered collection that allows duplicate elements
- Main implementations: ArrayList (default), LinkedList

### ArrayList Example
```java
import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {
        // Initialize
        List<String> list = new ArrayList<>();
        
        // Add elements
        list.add("Apple");    // Add to end
        list.add(0, "Banana"); // Add at specific index
        
        // Remove elements
        list.remove("Banana"); // Remove by value
        list.remove(0);        // Remove by index
        
        // Size
        System.out.println("List size: " + list.size());
    }
}
```

2. Set
Collection that does not allow duplicate elements
Main implementations: HashSet (unordered), TreeSet (sorted)
HashSet Example

```java
import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        // Initialize
        Set<String> set = new HashSet<>();
        
        // Add elements
        set.add("Apple");
        set.add("Banana");
        
        // Remove elements
        set.remove("Banana");
        
        // Check existence
        System.out.println("Contains Apple? " + set.contains("Apple"));
    }
}

```

3. Map
Stores key-value pairs
Main implementations: HashMap (default), LinkedHashMap (maintains insertion order), TreeMap (sorted keys)
HashMap Example

```java
import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        // Initialize
        Map<String, String> map = new HashMap<>();
        
        // Add elements
        map.put("fruit1", "Apple");
        map.put("fruit2", "Banana");
        
        // Remove elements
        map.remove("fruit2");
        
        // Get value
        System.out.println("Fruit1: " + map.get("fruit1"));

        System.out.println("Contains key 'fruit1'? " + map.containsKey("fruit1"));  // true
        System.out.println("Contains key 'fruit3'? " + map.containsKey("fruit3"));  // false

        // Check for values
        System.out.println("Contains value 'Banana'? " + map.containsValue("Banana")); // true
        System.out.println("Contains value 'Orange'? " + map.containsValue("Orange")); // false
    }
}
```

4 - Hashset

# Understanding contains() in HashMap and HashSet

## HashSet contains()
- Checks if the set contains a specific element
- Returns true if present, false otherwise

### Example
```java
import java.util.HashSet;
import java.util.Set;

public class HashSetContainsExample {
    public static void main(String[] args) {
        // Initialize
        Set<String> set = new HashSet<>();
        
        // Add elements
        set.add("Apple");
        set.add("Banana");
        
        // Check for elements
        System.out.println("Contains Apple? " + set.contains("Apple"));  // true
        System.out.println("Contains Orange? " + set.contains("Orange")); // false
    }
}
```