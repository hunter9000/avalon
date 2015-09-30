package com.test.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.model.User;

public class JwtSubject {

    private long userId;

    private long charId;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getCharId() {
        return charId;
    }

    public void setCharId(long charId) {
        this.charId = charId;
    }

    @JsonIgnore
    public String getAsJSON() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this) ;
    }
}
