package br.com.mariolemos.gestao_escolar.service;

import java.util.List;
import java.util.UUID;

public interface ILocationService<T>{
    T findByLocation(UUID id);
    T create(T entity);
}
