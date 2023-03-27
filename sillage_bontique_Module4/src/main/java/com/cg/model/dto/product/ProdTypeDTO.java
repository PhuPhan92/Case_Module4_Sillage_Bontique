package com.cg.model.dto.product;
import com.cg.model.enums.EProdType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProdTypeDTO {


    @NotNull(message = "Role is required")
    private Long id;

    private EProdType prodType;

}