package com.maverick._8_profiledemo.service;
import java.lang.reflect.Method;


class Node<T> {
    public void setData(T data) {
        System.out.println("Node.setData");
    }
}

class MyNode extends Node<Integer> {
    @Override
    public void setData(Integer data) {
        System.out.println("MyNode.setData(Integer)");
    }
}
public class NodeClass {
    public static void main(String[] args) throws Exception {
        MyNode mn = new MyNode();
        Node n = mn; // Raw type assignment

        // Invocation 1:
        n.setData("Hello MNC");

        // Invocation 2:
        Method[] methods = MyNode.class.getDeclaredMethods();
        System.out.println("Declared methods count in MyNode: " + methods.length);
        for (Method m : methods) {
            System.out.println(m.getName() + " -> " + m.getParameterTypes()[0].getSimpleName());
        }
    }
}
