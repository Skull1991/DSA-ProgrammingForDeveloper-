package Week1;

import java.util.*;
import java.util.LinkedList;

public class Week1 {
    Queue<Integer> list;
    int totalSize;

    Week1(LinkedList[] a) {
        int whole = 0;
        for (int i = 0; i < a.length; i++) {
            whole += a[i].size();

        }

        totalSize = whole;
        list = new PriorityQueue<Integer>(whole);
        LinkedList current;
        for (int i = 0; i < a.length; i++) {
            current = a[i];
            int internalItterator = 0;
            while (internalItterator < current.size()) {
                int adder = (Integer) current.get(0);
                list.add(adder);
                current.removeFirst();
            }
            internalItterator++;
        }
    }

    int[] queueItterator() {
        int[] temp = new int[totalSize];
        for (int i = 0; i < totalSize; i++) {
            temp[i] = list.remove();
        }
        return temp;
    }

    public static void main(String[] args) {

        LinkedList a = new LinkedList<Integer>();
        a.add(2);
        a.add(4);
        a.add(7);
        a.add(5);
        a.add(10);

        LinkedList b = new LinkedList<Integer>();
        b.add(3);
        b.add(2);
        b.add(7);
        b.add(9);

        LinkedList c = new LinkedList<Integer>();
        c.add(12);
        c.add(5);
        c.add(6);
        c.add(9);

        LinkedList[] list = { a, b, c };
        Week1 medianFinder = new Week1(list);
        int[] requiredArr = medianFinder.queueItterator();
        int median = (requiredArr.length + 1) / 2;
        System.out.println(requiredArr.length);
        System.out.println(median);
        System.out.println(requiredArr[median]);

    }

}