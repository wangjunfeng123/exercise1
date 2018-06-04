package com.kuai.springboot.domain;

/**
 * @author wangjunfeng
 * @version 1.0
 * @desc The type Sale menu service.
 * @since ${date}
 */
public class Apple {
    private String name;
    private Integer weight;
    private String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}