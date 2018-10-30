package fr.dta.spring.boot.tests;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.http.MediaType;

public class UserControllerTest extends IntegrationTest {

	@Test
	public void creerUserGetTestT() throws Exception {
		this.mockMvc.perform(get("/user/bryan")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("WELCOME BRYAN")));
	}

	@Test
	public void creerUserGetTestF() throws Exception {
		this.mockMvc.perform(get("/user/momo")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("PAS BRYAN")));
	}

	@Test
	public void creerUserPostTestT() throws Exception {
		this.mockMvc.perform(post("/userp").contentType(MediaType.APPLICATION_JSON).content("bryan")).andDo(print())
				.andExpect(status().isOk()).andExpect(content().string(containsString("WELCOME BRYAN")));

	}

	@Test
	public void creerUserPostTestF() throws Exception {
		this.mockMvc.perform(post("/userp").contentType(MediaType.APPLICATION_JSON).content("momo")).andDo(print())
				.andExpect(status().isOk()).andExpect(content().string(containsString("PAS BRYAN")));

	}

}
