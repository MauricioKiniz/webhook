package com.mksistemas.webhook.persistencia.repositories;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.mksistemas.webhook.entities.EmpresaEntity;

@Component
public interface IEmpresaRepositorio extends CrudRepository<EmpresaEntity, UUID> {

}
