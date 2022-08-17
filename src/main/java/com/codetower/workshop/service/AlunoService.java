package com.codetower.workshop.service;

import com.codetower.workshop.domain.Aluno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface AlunoService {

    public Page<Aluno> getAll(Pageable pageable);

    public Aluno getOne(UUID id);

    public Aluno update(UUID id, Aluno aluno);

    public Aluno create(Aluno aluno);

    public void delete(UUID uuid);
}
