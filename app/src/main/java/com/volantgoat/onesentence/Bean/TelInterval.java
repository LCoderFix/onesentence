package com.volantgoat.onesentence.Bean;

/**
 * Create by dong
 * Date on 2020/5/12  19:20
 */
public class TelInterval {
    String telIntervalNum;
    String getTelIntervalName;

    public TelInterval(String telIntervalNum, String getTelIntervalName) {
        this.telIntervalNum = telIntervalNum;
        this.getTelIntervalName = getTelIntervalName;
    }

    public String getTelIntervalNum() {
        return telIntervalNum;
    }

    public void setTelIntervalNum(String telIntervalNum) {
        this.telIntervalNum = telIntervalNum;
    }

    public String getGetTelIntervalName() {
        return getTelIntervalName;
    }

    public void setGetTelIntervalName(String getTelIntervalName) {
        this.getTelIntervalName = getTelIntervalName;
    }
}
