package com.github.mcnew.user.controller;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

//@SpringBootTest
//@AutoConfigureMockMvc
//@ContextConfiguration(classes = UserOnlyApplication.class)
@WebMvcTest(controllers = PermissionController.class)
class PermissionControllerIT {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void testGet0() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/permissions")).andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().json("[]"));
	}

	@Test
	void testGet() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/permissions/0")).andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isNotFound());
	}

}
