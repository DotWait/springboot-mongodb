package com.dotwait.springbootmongodb.temp;

public class ScreenId {
    private String screenIds;
    private int sum;

    @Override
    public String toString() {
        return "ScreenId{" +
                "screenIds='" + screenIds + '\'' +
                ", sum=" + sum +
                '}';
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public String getScreenIds() {
        return screenIds;
    }

    public void setScreenIds(String screenIds) {
        this.screenIds = screenIds;
    }
}
