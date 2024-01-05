## Hashing
### Map
  Hashmap
  LinkedHashmap
  TreeMap
### Set
  HashSet
  LinkedHashset
  TreeSet


### Hashmap 
  Key value pair
  identitifier 
  Unordered Map


  Time Complexity
  O(1)
  Insert 
  Remove
  Search 


### Hashmap Operations
```java
import java.util.Hashmap;

Hashmap<String,Integer> hm = new Hashmap<>();
put(key,value) 
get(key)
containsKey(key)
remove(key)
```


### Iteration on Hashmap
```java
Set<Integer> keys = hm.keySet();
```

### Implementation HashMap
Array of Linked List  -> Buckets
n -> Nodes 
N -> Buckets
hashCode()
sameHash value for Same input


Key Exist   | Key Not Exist
update          add


Put

a) Hash Function generate Bucket Index
b) Loop through Linked List  on Bucket Index and Find Key
    if Key Exist
      Update the Value
    else
      Add the New Node

If Node are evenly distributed between Buckets
n/ N 7/4 


Rehashing if number of nodes are more than certain threshold


--- 

## LinkedHashMap 
Keys are insertion ordered

```java
LinkedHashMap<K,V> hm = new LinkedHashMap<>();
```

| Operation   	| Time Complexity 	|
|-------------	|-----------------	|
| get(key)    	| O(1)            	|
| put(key)    	| O(1)            	|
| remove(key) 	| O(1)            	|
| size()      	| O(1)            	|
| isEmpty()   	| O(1)            	|
| keySet()    	| O(1)            	|

---
## TreeMap
Key are sorted
put get remove are O(logn)
```java
TreeMap<K,V> hm = new TreeMap<>();
```
Implemented using Red Black Trees


---
## HashSet
no duplicates
unordered
Null is allowed
```java
HashSet<Integer> hs = new HashSet<>();
```

| Operation     	| Time Complexity 	|
|---------------	|-----------------	|
| add(key)      	| O(1)            	|
| contains(key) 	| O(1)            	|
| remove(key)   	| O(1)            	|


set.size()
set.clear()
set.isEmpty()

---
## Iteration on HashSet
a)Using Iterators
```java
Iterator it = set.iterator()
while(it.hasNext())
{
  System.out.println(it.next())
}
```


b) Using Enhanced For Loop

```java
 for (String city : cities) {
      System.out.println(city);
    }
```