package com.example.alarmproject;

import android.widget.Switch;

public class Dictionary {

    private String cust_name;
    private String expire_date;
    private Switch alarm_switch;

    public Dictionary(String cust_name, String expire_date, Switch alarm_switch) {
        this.cust_name = cust_name;
        this.expire_date = expire_date;
        this.alarm_switch = alarm_switch;
    }

    public String getCust_name() { return cust_name; }
    public void setCust_name(String cust_name) { this.cust_name = cust_name; }
    public String getExpire_date() { return expire_date; }
    public void setExpire_date(String expire_date) { this.expire_date = expire_date; }
    public Switch getAlarm_switch() { return alarm_switch; }
    public void setAlarm_switch(Switch alarm_switch) { this.alarm_switch = alarm_switch; }

}
