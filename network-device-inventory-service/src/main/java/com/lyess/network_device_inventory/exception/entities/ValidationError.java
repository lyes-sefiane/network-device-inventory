package com.lyess.network_device_inventory.exception.entities;

import lombok.*;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2021-12-26 12:35 p.m.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ValidationError implements ErrorResponse {

    private String object;
    private String field;
    private Object rejectedValue;
    private String message;

}
