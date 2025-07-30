package com.dapurhi.bedapurhi.dto.response;

import lombok.Data;

@Data
public class PagingResponse {
    private int currentPage;
    private int totalPage;
    private int size;
    private long totalElements;
    private boolean hasNext;
    private boolean hasPrevious;
}
