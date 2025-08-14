package com.dapurhi.bedapurhi.controller;

import com.dapurhi.bedapurhi.dto.request.CustomerRequest;
import com.dapurhi.bedapurhi.dto.response.CommonResponse;
import com.dapurhi.bedapurhi.dto.response.CustomerResponse;
import com.dapurhi.bedapurhi.service.CustomerService;
import com.dapurhi.bedapurhi.util.ResponseUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
@Tag(name = "Customer", description = "Operasi terkait data pelanggan")
public class CustomerController {

    private final CustomerService customerService;

    @Operation(summary = "Membuat customer baru", description = "Mendaftarkan customer baru ke dalam sistem.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Customer berhasil dibuat"),
            @ApiResponse(responseCode = "400", description = "Input tidak valid", content = @Content)
    })
    @PostMapping
    public ResponseEntity<CommonResponse<CustomerResponse>> createCustomer(@Valid @RequestBody CustomerRequest customer){
        return ResponseUtil.createResponse(
                HttpStatus.CREATED,
                "Customer berhasil dibuat.",
                customerService.createCustomer(customer)
        );
    }

    @Operation(summary = "Mendapatkan semua customer", description = "Mengambil daftar customer dengan paginasi dan filter berdasarkan nama.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Daftar customer berhasil didapatkan")
    })
    @GetMapping
    public ResponseEntity<CommonResponse<List<CustomerResponse>>> getAllCustomers(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size,
            @RequestParam(name = "sortBy", defaultValue = "name") String sortBy,
            @RequestParam(name = "direction", defaultValue = "asc") String direction,
            @RequestParam(name = "name", required = false) String name
    ){
        Sort.Direction sortDirection = Sort.Direction.fromString(direction);
        Pageable pageable = PageRequest.of(page, size, sortDirection, sortBy);
        Page<CustomerResponse> customerResponses = customerService.getAllCustomers(pageable, name);
        return ResponseUtil.createResponse(
                HttpStatus.OK,
                "Daftar customer didapatkan.",
                customerResponses
        );
    }

    @Operation(summary = "Mendapatkan customer berdasarkan ID", description = "Mengambil detail satu customer berdasarkan ID uniknya.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer ditemukan"),
            @ApiResponse(responseCode = "404", description = "Customer tidak ditemukan", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<CommonResponse<CustomerResponse>> getCustomerById(@PathVariable String id){
        return ResponseUtil.createResponse(
                HttpStatus.OK,
                "Berhasil mendapatkan customer.",
                customerService.getCustomerById(id)
        );
    }

    @Operation(summary = "Memperbaharui data customer", description = "Memperbaharui data customer yang sudah ada berdasarkan ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer berhasil diperbaharui"),
            @ApiResponse(responseCode = "404", description = "Customer tidak ditemukan", content = @Content)
    })
    @PutMapping("/{id}")
    public ResponseEntity<CommonResponse<CustomerResponse>> updateCustomer(
            @PathVariable String id,
            @RequestBody CustomerRequest customerRequest
    ){
        return ResponseUtil.createResponse(
                HttpStatus.OK,
                "Berhasil memperbaharui Customer.",
                customerService.updateCustomer(id, customerRequest)
        );
    }

    @Operation(summary = "Menghapus customer (soft delete)", description = "Menghapus customer berdasarkan ID dengan metode soft delete (menandai 'isDeleted' menjadi true).")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Customer berhasil dihapus"),
            @ApiResponse(responseCode = "404", description = "Customer tidak ditemukan", content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<CommonResponse<String>> deleteCustomer(@PathVariable String id){
        // CATATAN PENTING: Menambahkan pemanggilan service yang sebelumnya tidak ada
        customerService.deleteCustomerById(id);
        return ResponseUtil.createResponse(
                HttpStatus.NO_CONTENT,
                "Berhasil menghapus Customer.",
                (String) null
        );
    }
}