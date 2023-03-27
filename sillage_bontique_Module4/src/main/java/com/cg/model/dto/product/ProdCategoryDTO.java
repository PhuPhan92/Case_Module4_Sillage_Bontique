package com.cg.model.dto.product;

import com.cg.model.enums.EProdCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProdCategoryDTO {
    private Long id;
    private EProdCategory name;
}