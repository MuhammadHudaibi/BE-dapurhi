package com.dapurhi.bedapurhi.controller;

import com.dapurhi.bedapurhi.dto.request.OrderRequest;
import com.dapurhi.bedapurhi.dto.response.CommonResponse;
import com.dapurhi.bedapurhi.dto.response.OrderResponse;
import com.dapurhi.bedapurhi.service.OrderService;
import com.dapurhi.bedapurhi.util.ResponseUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
@Tag(name = "Order", description = "Operasi terkait transaksi atau pesanan")
public class OrderController {

    private final OrderService orderService;

    @Operation(summary = "Membuat transaksi/pesanan baru", description = "Mencatat transaksi penjualan baru ke dalam sistem.")
    @PostMapping
    public ResponseEntity<CommonResponse<OrderResponse>> createOrder(@Valid @RequestBody OrderRequest request) {
        return ResponseUtil.createResponse(
                HttpStatus.CREATED,
                "Transaksi berhasil dibuat.",
                orderService.createOrder(request)
        );
    }

    @GetMapping
    public ResponseEntity<CommonResponse<List<OrderResponse>>> getOrders() {
        return ResponseUtil.createResponse(
                HttpStatus.OK,
                "Berhasil mendapatkan daftar transaksi",
                orderService.getOrders()
        );
    }
}
