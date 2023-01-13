package FinalProject.FinalProject;

import FinalProject.FinalProject.controller.impl.DeliveryOrderController;
import FinalProject.FinalProject.repository.DeliveryOrderRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class DeliveryOrderControllerTests {

    @Autowired
    DeliveryOrderController deliveryOrderController;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    DeliveryOrderRepository deliveryOrderRepository;

    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {

        /*mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).apply(springSecurity()).build();*/
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    //WithMockUser para simular autenticación de un usuario con determinados roles, no tiene porqué existir en la
    //base de datos
    @Test
    /*@WithMockUser(username="user01", roles={"ADMIN"})*/
    void getDeliveryOrderById_validId_getOrder() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/orders/3"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("platesSet"));
    }



}
