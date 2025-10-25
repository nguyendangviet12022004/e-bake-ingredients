package com.swd.e_bake_ingredients.dto.order;

import com.swd.e_bake_ingredients.constant.OrderStatusValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private Integer id;
    private Integer customerId;
    private List<ItemDTO> items;
    private DeliveryDTO delivery;
    private PaymentDTO payment;
    private OrderStatusDTO currentStatus;
    private List<OrderStatusDTO> statusHistory;
    private OrderStatusValue currentStatusValue;
    private Double total;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}