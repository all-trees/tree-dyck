tree-dyck
===========

Code to generate all words of the Dyck language.

Usage
-----

```java
Generator generator = new Generator();
State currentState = generator.initialStateOfLength(0);
do {
    // act on currentState
    currentState = generator.next(currentState);
} while(true); // There are infinite Dyck words
```
