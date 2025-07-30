package com.dapurhi.bedapurhi.util;

import com.dapurhi.bedapurhi.dto.response.CommonResponse;
import com.dapurhi.bedapurhi.dto.response.PagingResponse;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ResponseUtil {
    public static <T>ResponseEntity<CommonResponse<T>> createResponse( HttpStatus status, String message, T data) {
        CommonResponse<T> response = CommonResponse.<T>builder()
                .code(status.value())
                .message(message)
                .data(data)
                .build();

        return ResponseEntity.status(status).body(response);
    }

    public static <T> ResponseEntity<CommonResponse<List<T>>> createResponse(HttpStatus status, String message, Page<T> page) {
        PagingResponse pagingResponse = new PagingResponse();
        pagingResponse.setCurrentPage(page.getNumber() + 1);
        pagingResponse.setTotalPage(page.getTotalPages());
        pagingResponse.setSize(page.getSize());
        pagingResponse.setTotalElements(page.getTotalElements());
        pagingResponse.setHasNext(page.hasNext());
        pagingResponse.setHasPrevious(page.hasPrevious());

        CommonResponse<List<T>> response = CommonResponse.<List<T>>builder()
                .code(status.value())
                .message(message)
                .data(page.getContent())
                .paging(pagingResponse)
                .build();

        return ResponseEntity.status(status).body(response);
    }
}
