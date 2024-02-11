package com.example.CoffeeTea;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.CoffeeTea.model.CoffeeRepository;
import com.example.CoffeeTea.model.TeaRepository;
import com.example.CoffeeTea.utils.PopulateDB;
import com.example.CoffeeTea.web.CoffeeTeaController;

@WebMvcTest(CoffeeTeaController.class)
public class CoffeeTeaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CoffeeRepository coffeeRepository;
    @MockBean
    private TeaRepository teaRepository;
    @MockBean
    private PopulateDB populateDb;
    
    @Test
    public void testEditCoffee() throws Exception {
        mockMvc.perform(post("/addcoffee")
                .param("name", "test coffee")
                .param("weight", "15")
                .param("price", "4")
                .param("roastLevel", "2"))
                .andExpect(status().isOk());
        
        mockMvc.perform(put("/editcoffee")
                .param("id", "1")
                .param("name", "edited coffee")
                .param("weight", "10")
                .param("price", "5")
                .param("roastLevel", "5"))
                .andExpect(status().isOk());
    }
    
    @Test
    public void testAddCoffee() throws Exception {
        mockMvc.perform(post("/addcoffee")
                .param("name", "test coffee")
                .param("weight", "15")
                .param("price", "4")
                .param("roastLevel", "2"))
                .andExpect(status().isOk());
    }
	
	/*
    @Test
    public void testDeleteCoffee() throws Exception {
        mockMvc.perform(delete("/deletecoffee")
                .param("id", "1"))
                .andExpect(status().isOk());
    }
    */

    @Test
    public void testAddTea() throws Exception {
        mockMvc.perform(post("/addtea")
                .param("name", "test tea")
                .param("weight", "15")
                .param("price", "39.44"))
                .andExpect(status().isOk());
    }
    

    @Test
    public void testDeleteTea() throws Exception {
        mockMvc.perform(delete("/deletetea")
                .param("id", "1"))
                .andExpect(status().isOk());
    }
}