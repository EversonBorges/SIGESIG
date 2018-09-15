package com.borges.igreja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.borges.igreja.security.entity.GrupoEntity;
import com.borges.igreja.security.entity.PermissaoEntity;

public interface PermissaoRepository extends JpaRepository<PermissaoEntity, Long> {

	List<PermissaoEntity> findByGruposIn(GrupoEntity grupoEntity);
}
