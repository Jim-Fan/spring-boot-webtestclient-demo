package org.sdf.jimfan.webtestclientdemo.dto;

public class HelloDTO {

    private String message;

    @SuppressWarnings("unused")
    public HelloDTO() {
    }

    public HelloDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (! (obj instanceof HelloDTO)) {
            return false;
        }
        return this.message.equals(((HelloDTO)obj).getMessage());
    }
}
