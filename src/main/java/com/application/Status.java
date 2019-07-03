package com.application;

public enum Status {

    ONLINE,
    OFFLINE,
    AWAY;


    @Override
    public String toString() {
        return this.name();
    }
}
