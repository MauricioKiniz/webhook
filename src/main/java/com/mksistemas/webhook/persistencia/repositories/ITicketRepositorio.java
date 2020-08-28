package com.mksistemas.webhook.persistencia.repositories;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.mksistemas.webhook.entities.TicketEntity;

@Component
public interface ITicketRepositorio extends CrudRepository<TicketEntity, UUID> {

}
