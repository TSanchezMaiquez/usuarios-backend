package com.kreitek.mantenimientousuarios.usuarios.specs;


import com.kreitek.mantenimientousuarios.usuarios.domain.entity.Usuario;
import com.kreitek.mantenimientousuarios.usuarios.specs.shared.EntitySpecification;
import com.kreitek.mantenimientousuarios.usuarios.specs.shared.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class ItemSpecification extends EntitySpecification<Usuario> implements Specification<Usuario> {


    public ItemSpecification(List<SearchCriteria> criteria) {
        this.criteria = criteria;
    }



}
