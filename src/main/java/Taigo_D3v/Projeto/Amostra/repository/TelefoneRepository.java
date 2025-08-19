package Taigo_D3v.Projeto.Amostra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Taigo_D3v.Projeto.Amostra.domain.Telefone;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Integer> {

}
