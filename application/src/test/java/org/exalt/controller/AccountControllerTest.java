package org.exalt.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.exalt.dto.DepositRequest;

import org.exalt.dto.WithdrawRequest;
import org.exalt.service.AccountService;
import org.exalt.service.DepositService;
import org.exalt.service.WithdrawService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.util.UUID;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = AccountController.class)
public class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private WithdrawService withdrawUseCase;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private DepositService depositUseCase;
    @MockBean
    private AccountService accountUseCase;


    @Test
    public void should_get_operation_history_by_id() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/account/{id}/operation",
                        UUID.fromString("f6fd9a4e-31de-11ed-a261-0242ac120005"))
                .contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    public void should_deposit() throws Exception {
        DepositRequest depositRequest = new DepositRequest();
        depositRequest.setAmount(new BigDecimal(1000));
        depositRequest.setId(UUID.fromString("f6fd9a4e-31de-11ed-a261-0242ac120005"));
        mockMvc.perform(MockMvcRequestBuilders.post("/account/{id}/operation/deposit",
                                UUID.fromString("f6fd9a4e-31de-11ed-a261-0242ac120005"))
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(depositRequest)))
                .andExpect(status().isOk());
    }

    @Test
    public void should_withdraw() throws Exception {
        WithdrawRequest withdrawRequest = new WithdrawRequest();
        withdrawRequest.setAmount(new BigDecimal(1000));
        withdrawRequest.setId(UUID.fromString("f6fd9a4e-31de-11ed-a261-0242ac120005"));
        mockMvc.perform(MockMvcRequestBuilders.post("/account/{id}/operation/withdraw",
                                UUID.fromString("f6fd9a4e-31de-11ed-a261-0242ac120005"))
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(withdrawRequest)))
                .andExpect(status().isOk());
    }

}
