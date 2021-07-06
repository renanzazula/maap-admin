package com.maap.admin.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maap.admin.BaseTest;

abstract class AbstractRestControllerTest extends BaseTest {


    static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
