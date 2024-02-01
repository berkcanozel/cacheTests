package com.example.demo1.Vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class ResponseObjectForCaching {

    private Object response1;
    private Object response2;

    public ResponseObjectForCaching(Object response1, Object response2) {
        this.response1 = response1;
        this.response2 = response2;
    }

    public Object getResponse1() {
        return response1;
    }

    public void setResponse1(Object response1) {
        this.response1 = response1;
    }

    public Object getResponse2() {
        return response2;
    }

    public void setResponse2(Object response2) {
        this.response2 = response2;
    }


}
