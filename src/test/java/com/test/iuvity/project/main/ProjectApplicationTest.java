package com.test.iuvity.project.main;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.iuvity.project.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static com.test.iuvity.project.DataTest.listProductsDataTest;
import static com.test.iuvity.project.DataTest.productDataTest;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class ProjectApplicationTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    ProductService productService;

    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void findAllControllerTest() throws Exception {
        when(productService.findAll()).thenReturn(listProductsDataTest());

        mvc.perform(get("/api/findAll"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)));

        verify(productService).findAll();

    }

    @Test
    public void createProductControllerTest() throws Exception {
        when(productService.save(Mockito.any())).thenReturn(productDataTest());

        mvc.perform(post("/api/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(productDataTest())))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.productName").value("Mug IronMan"));

        verify(productService).save(Mockito.any());

    }

    @Test
    public void updateProductControllerTest() throws Exception {
        when(productService.save(Mockito.any())).thenReturn(productDataTest());

        mvc.perform(put("/api/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(productDataTest())))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.productName").value("Mug IronMan"));

        verify(productService).save(Mockito.any());

    }

    @Test
    public void deleteProductControllerTest() throws Exception {
        when(productService.deleteById(Mockito.any())).thenReturn(listProductsDataTest());

        mvc.perform(delete("/api/delete/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)));

        verify(productService).deleteById(Mockito.any());

    }
}