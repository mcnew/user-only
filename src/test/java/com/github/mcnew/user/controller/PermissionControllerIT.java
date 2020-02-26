package com.github.mcnew.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.github.mcnew.user.TConfiguration;

//@WebMvcTest(controllers = PermissionController.class)
@ContextConfiguration(classes = { TConfiguration.class })
public class PermissionControllerIT {

	@Autowired
	private MockMvc mockMvc;

	// @Test
	void testGet0() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/permissions")).andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().json("[]"));
	}

	// @Test
	void testGet() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/permissions/0")).andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isNotFound());
	}

}
