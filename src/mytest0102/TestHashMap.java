package mytest0102;

import java.util.Arrays;

//HashMap取出乱序，LinkedHashMap有序
//HashMap线程不安全，效率高。允许key和value值为空
//HashTable线程安全，效率低。不允许key和value值为空
public class TestHashMap<K, V> {

    Node2[] table;      //核心。位桶数组 bucket array
    int size;           //定义键值对的个数

    public TestHashMap() {
        table = new Node2[2];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < table.length; i++) {
            Node2 temp = table[i];
            while (temp != null) {
                sb.append(temp.key + ":" + temp.value + ",");
                temp = temp.next;
            }
        }
        sb.setCharAt(sb.length() - 1, '}');
        return sb.toString();
    }

    public void put(K key, V value) {

        //考虑数组扩容问题。链表长度大于8，JDK1.8会自动转变为红黑树存储结构
        int num_nonempty = 0;

        for (int i = 0; i < table.length; i++) {
            Node2 temp = table[i];
            if (temp != null) {
                num_nonempty++;
            }
        }

        //扩容操作
        if (num_nonempty > table.length * 0.75) {

            Node2[] newTable = new Node2[table.length + (table.length >> 1)];       //右移一位，除以2

            //挨个遍历，将所有非空键值对全部拷贝到新数组中
            for (int i = 0; i < table.length; i++) {
                Node2 temp = table[i];
                if (temp != null) {
                    while (temp != null) { //temp非空，将temp复制到新的newTable中
                        temp.hash = myHash(temp.key.hashCode(), newTable.length);
                        newTable[temp.hash] = temp;
                        temp = temp.next;
                    }
                }
            }
            table = newTable;
        }

        //定义的新节点对象
        Node2 newnode = new Node2();

        newnode.hash = myHash(key.hashCode(), table.length);     //key.hashCode()为Object类自带的获取键Hashcode的方法
        newnode.key = key;
        newnode.value = value;
        newnode.next = null;

        Node2 iterlast = new Node2();
        boolean repeatflag = false;
        Node2 temp = table[newnode.hash];
        //若table数组对应的某一链表为空，则直接将新结点放入
        if (temp == null) {
            table[newnode.hash] = newnode;
            size++;
        } else {

            while (temp != null) {
                if (newnode.key.equals(temp.hash)) {  //hash值相同，则覆盖
                    repeatflag = true;
                    temp.value = value;
                    break;
                } else {      //遍历整个链表
                    iterlast = temp;
                    temp = temp.next;
                }
            }

            if (!repeatflag) {
                iterlast.next = newnode;
                newnode.next = null;
                size++;
            }
        }

    }

    public int myHash(int hc, int length) {
        return hc & (length - 1);
    }

    public V get(K key) {
        V value = null;
        int hash = myHash(key.hashCode(), table.length);

        if (table[hash] != null) {
            Node2 temp = table[hash];
            while (temp != null) {
                if (temp.key.equals(key)) {
                    value = (V) temp.value;
                    break;
                } else {
                    temp = temp.next;
                }
            }
        }

        return value;
    }

    public static void main(String[] args) {
        test01();

    }

    static void test01() {
        TestHashMap<Integer, String> testHashMap = new TestHashMap<>();

        testHashMap.put(1, "DHU");
        testHashMap.put(2, "WUI");
        testHashMap.put(3, "SKO");
        testHashMap.put(4, "gk");

        System.out.println(testHashMap);
        System.out.println(testHashMap.get(3));

    }
}
