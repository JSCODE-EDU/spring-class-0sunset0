package com.springhello.domain.store.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class StoreSaveRequest {

    @NotBlank
    private String name;
    @NotBlank
    private String roadCode;
    @NotBlank
    private String detail;
    @NotBlank
    private String phoneValue;
}
