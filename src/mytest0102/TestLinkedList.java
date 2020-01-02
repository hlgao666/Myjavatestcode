package mytest0102;

import java.util.LinkedList;

//测试LinkedList
public class TestLinkedList {

    private Node first;     //第一个节点
    private Node last;      //最后一个节点
    private int size;       //链表长度


    //插入方法,顺序插入
    public void add(Object obj) {
        Node node = new Node(obj);
        if (first == null) {
            first = node;
            last = node;
        } else {

            node.privious = last;   //将node的前一个指针指向last
            node.next = null;       //将node的下一个指针指向空
            last.next = node;       //将last节点的下一个指针指向node
            last = node;            //将node赋值给last节点
        }
        size++;               //链表长度加一
    }

    //重载插入方法,在指定index处插入
    //插入前[a,b,c,d],index=2,obj=h,插入后[a,b,h,c,d]
    public void add(Object obj, int index) {

        Node temp = getNode(index);
        Node newnode = new Node(obj);

        if (temp != null) {

            Node up = temp.privious;

            checkRange(index);

            if (index == 0) {
                temp.privious = newnode;
                newnode.privious = null;
                newnode.next = temp;
                first = newnode;        //只改变first，未改变last

            } else {
                newnode.privious = up;
                up.next = newnode;

                newnode.next = temp;
                temp.privious = newnode;
            }
            size++;             //链表长度加一
        }
    }

    //移除方法
    public void remove(int index) {
        Node temp = getNode(index);
        if (temp != null) {

            Node up = temp.privious;
            Node down = temp.next;

            if (index == 0) {
                first = down;       //删除第一个元素，需改变first的指向
            }

            if (index == size - 1) {
                last = up;          //删除最后一个元素，需改变last的指向
            }

            if (up != null) {
                up.next = down;
            }

            if (down != null) {
                down.privious = up;
            }

            size--;
        }
    }

    //查询方法
    public Object get(int index) {

        checkRange(index);

        Node temp = getNode(index);

        return temp != null ? temp.obj : null;
    }

    //增加索引封装
    public void checkRange(int index) {
        if (index < 0 || index > size - 1) {
            throw new RuntimeException("索引数字不合法:" + index);
        }
    }

    //封装获取节点方法
    public Node getNode(int index) {
        Node temp = null;
        int i = 0;

        if (index <= (size >> 1)) {
            temp = first;
            while (i < index) {
                temp = temp.next;
                i++;
            }

        } else {
            temp = last;
            while (i < size - index - 1) {
                temp = temp.privious;
                i++;
            }
        }

        return temp;
    }


    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node temp = first;
        while (temp != null) {
            sb.append(temp.obj + ",");
            temp = temp.next;
        }
        sb.setCharAt(sb.length() - 1, ']');

        return sb.toString();                       //调用sb自己类内的toString()方法
    }

    public static void main(String[] args) {
        TestLinkedList list = new TestLinkedList();
        list.add("aa");
        list.add("123");
        list.add("我");

        list.add("555", 1);
        System.out.println(list.toString());        //调用自定义的类内方法，就近原则
        System.out.println(list.get(3));
        list.remove(0);
        System.out.println(list.toString());        //调用自定义的类内方法，就近原则
    }

}
