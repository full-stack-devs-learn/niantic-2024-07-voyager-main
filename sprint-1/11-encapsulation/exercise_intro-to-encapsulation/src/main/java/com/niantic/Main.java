package com.niantic;

import com.niantic.part_2_objects.Circle;

public class Main
{
    public static void main(String[] args)
    {

        // this is like the EMPTY form
        Circle circle = new Circle();

        // I have to fill in the values
        circle.setRadius(5);

        double area = circle.getArea();
        System.out.println(area);

        Circle circle2 = new Circle(5);

    }
}