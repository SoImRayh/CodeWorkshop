package com.codetower.workshop.service.implementation;

import com.codetower.workshop.domain.Aluno;
import com.codetower.workshop.repository.AlunoRepository;
import com.codetower.workshop.service.AlunoService;
import lombok.AllArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AlunoServiceImplementation implements AlunoService {

    private final AlunoRepository alunoRepository;

    @Override
    public Page<Aluno> getAll(Pageable pageable) {
        return alunoRepository.findAll(pageable);
    }

    @Override
    public Aluno getOne(UUID id) {
        return alunoRepository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException(id, "nao foi encontrado o usário"));
    }

    @Override
    public Aluno update(UUID id, Aluno aluno) {
        var velhoAluno = alunoRepository.findById(id).orElse(null);

        if(velhoAluno != null){
            aluno.setId(velhoAluno.getId());
            return alunoRepository.save(aluno);
        }
        throw new ObjectNotFoundException(id, "nao foi possivel encontrar o objeto a ser atualizado");
    }

    @Override
    public Aluno create(@Valid Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @Override
    public void delete(UUID uuid) {
        alunoRepository.deleteById(uuid);
    }
}
