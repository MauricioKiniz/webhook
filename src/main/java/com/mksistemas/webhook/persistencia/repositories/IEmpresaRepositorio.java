package com.mksistemas.webhook.persistencia.repositories;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.mksistemas.webhook.entities.empresa.Empresa;

@Component
public interface IEmpresaRepositorio extends CrudRepository<Empresa, UUID> {

}
