package com.derek.model.request;

/**
 * @author Derek
 * @date 2018/3/24 20:37
 */
public class OrderInfo {
    private int id;
    private int number;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "id=" + id +
                ", number=" + number +
                '}';
    }
}
