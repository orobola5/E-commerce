package com.example.ecommerce;

import com.example.ecommerce.dto.Request.ProductRequestDto.ProductRequestDto;
import com.example.ecommerce.dto.Response.ProductResponseDto.ProductResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@TestComponent
@AutoConfigureMockMvc
class ECommerceApplicationTests {
//  private final String ROOT_URI="http://localhost:8081";

    @Autowired
    public MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    @DisplayName("test that we can add product")
    void canCreatProduct() throws Exception {
      ProductRequestDto requestDto=getProductRequestDto();
      String productRequest=objectMapper.writeValueAsString(requestDto);

      mockMvc.perform(MockMvcRequestBuilders.post("/api/product")
              .contentType(MediaType.APPLICATION_JSON)
              .content(productRequest))
              .andExpect(status().isCreated());
    }

  private ProductRequestDto getProductRequestDto() {
    return ProductRequestDto.builder()
            .name("channel-bag")
            .description("golden brown")
            .price(BigDecimal.valueOf(200000))
            .build();
  }

  @Test
  @DisplayName("test that we can find all our product")
  void getAllProduct() throws Exception {
        ProductResponse response=getProductResponse();
        String productResponse = objectMapper.writeValueAsString(response);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/product")
                .contentType(MediaType.APPLICATION_JSON)
                .content(productResponse))
                .andExpect(status().isFound());

  }

    private ProductResponse getProductResponse() {
        return ProductResponse.builder()
                .id(1L)
                .name("channel-bag")
                .description("golden brown")
                .price(BigDecimal.valueOf(200000))
                .build();

    }

}
