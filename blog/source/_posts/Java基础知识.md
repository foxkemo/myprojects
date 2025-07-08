---
title: Java基础知识
date: 2025-04-05 14:24:27
tags: Java
---
        
        
        
     `Object` 类是 Java 中所有类的祖宗类，所有类默认都继承它。它定义了一组最基础、最通用的方法，**每个 Java 对象都可以使用这些方法**。

---
# Object method
 
## 🧬 Object 类的所有方法一览

| 方法名 | 作用简述 |
|--------|---------|
| `clone()` | 创建并返回对象的副本（浅拷贝） |
| `equals(Object obj)` | 比较两个对象是否“逻辑相等” |
| `finalize()` | 垃圾回收前调用的方法（已过时） |
| `getClass()` | 获取对象的运行时类（返回 Class 对象） |
| `hashCode()` | 返回对象的哈希码（用于哈希结构） |
| `toString()` | 返回对象的字符串表示 |
| `notify()` | 唤醒一个正在等待该对象的线程（多线程同步） |
| `notifyAll()` | 唤醒所有等待该对象的线程 |
| `wait()` | 当前线程等待，直到被唤醒（配合 synchronized 使用） |
| `wait(long timeout)` | 等待指定毫秒后自动唤醒 |
| `wait(long timeout, int nanos)` | 更精细的等待 |

---

## 🔍 方法说明（常用的）

### 1. `equals(Object obj)`
默认比较地址，可以重写实现内容比较（如 `String.equals()`）

```java
@Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Person p = (Person) obj;
    return this.age == p.age && this.name.equals(p.name);
}
```

---

### 2. `hashCode()`
用于哈希结构，如 `HashMap`，必须和 `equals()` 一起重写。

```java
@Override
public int hashCode() {
    return Objects.hash(name, age);
}
```

---

### 3. `toString()`
默认输出格式是：类名@哈希码，可以重写更友好。

```java
@Override
public String toString() {
    return "Person{name='" + name + "', age=" + age + '}';
}
```

---

### 4. `clone()`
用来复制对象，**要实现 `Cloneable` 接口**，否则会抛异常。

```java
public class Person implements Cloneable {
    @Override
    public Person clone() throws CloneNotSupportedException {
        return (Person) super.clone();
    }
}
```

---

### 5. `getClass()`
返回对象的类信息（反射相关）

```java
Person p = new Person();
System.out.println(p.getClass().getName()); // 输出: Person
```

---

### 6. `wait()` / `notify()` / `notifyAll()`
这些是线程通信相关方法，必须在 `synchronized` 块中使用。

```java
synchronized(obj) {
    obj.wait();      // 当前线程等待
    obj.notify();    // 唤醒等待中的线程
}
```

---

## 🧠 总结分类

| 类型 | 方法 |
|------|------|
| 对象比较与表示 | `equals()`、`hashCode()`、`toString()` |
| 克隆 | `clone()` |
| 获取类信息 | `getClass()` |
| 多线程通信 | `wait()`、`notify()`、`notifyAll()` |
| 生命周期（过时） | `finalize()` |

---

如果你想看看某个方法的源码、应用场景，或者需要我举具体例子，我可以给你细讲~


Java 集合（Collection）框架提供了大量的方法，用于操作各种集合类型，如 `List`、`Set`、`Map` 等。下面是一些常用集合接口和它们的方法简要整理：

---
# 集合类 有关 函数  
## 🧺 一、Collection 接口（List、Set 的父接口）

常用方法：

| 方法 | 描述 |
|------|------|
| `add(E e)` | 添加元素 |
| `addAll(Collection<? extends E> c)` | 添加另一个集合中的全部元素 |
| `remove(Object o)` | 移除指定元素 |
| `removeAll(Collection<?> c)` | 移除集合中所有与参数集合相同的元素 |
| `retainAll(Collection<?> c)` | 只保留集合中和参数集合相同的元素 |
| `clear()` | 清空集合 |
| `contains(Object o)` | 是否包含指定元素 |
| `containsAll(Collection<?> c)` | 是否包含指定集合中的所有元素 |
| `isEmpty()` | 是否为空 |
| `size()` | 返回元素个数 |
| `iterator()` | 返回迭代器 |

---

## 📃 二、List 接口（ArrayList、LinkedList 等）

继承自 Collection，支持索引操作：

| 方法 | 描述 |
|------|------|
| `get(int index)` | 获取指定索引的元素 |
| `set(int index, E element)` | 替换指定索引处的元素 |
| `add(int index, E element)` | 在指定位置插入元素 |
| `remove(int index)` | 移除指定索引处的元素 |
| `indexOf(Object o)` | 返回首次出现的位置 |
| `lastIndexOf(Object o)` | 返回最后一次出现的位置 |
| `subList(int fromIndex, int toIndex)` | 获取子列表 |

---

## 🔁 三、Set 接口（HashSet、TreeSet、LinkedHashSet）

继承自 Collection，**不允许重复元素**。

常用方法基本与 Collection 相同，但不支持索引访问（如 `get()`）。

---

## 📒 四、Map 接口（HashMap、TreeMap、LinkedHashMap）

键值对存储（Key-Value）：

| 方法 | 描述 |
|------|------|
| `put(K key, V value)` | 添加或更新键值对 |
| `putAll(Map<? extends K, ? extends V> m)` | 添加另一个 Map 中的所有键值对 |
| `get(Object key)` | 获取指定 key 的值 |
| `remove(Object key)` | 移除指定 key 的键值对 |
| `containsKey(Object key)` | 是否包含指定 key |
| `containsValue(Object value)` | 是否包含指定 value |
| `keySet()` | 返回所有 key 的 Set |
| `values()` | 返回所有 value 的 Collection |
| `entrySet()` | 返回所有键值对的 Set<Map.Entry<K,V>> |
| `size()` | 返回键值对个数 |
| `clear()` | 清空 map |
| `isEmpty()` | 是否为空 |

---

如果你有具体哪种集合、哪类方法（比如：排序、查找、遍历）想详细了解，我可以更深入整理！也可以结合代码例子来讲讲。你想重点学哪个部分？