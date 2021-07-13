package com.maap.admin.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maap.admin.BaseTest;

public abstract class AbstractRestControllerTest extends BaseTest {

    protected static String asJsonString(final Object obj) {
        try {
            String output = new ObjectMapper().writeValueAsString(obj);

            System.out.println(output);

            return output;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
