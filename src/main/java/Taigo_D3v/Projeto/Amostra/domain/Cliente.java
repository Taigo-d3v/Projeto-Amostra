package Taigo_D3v.Projeto.Amostra.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String cpfOuCnpj;
    @Enumerated(EnumType.STRING)
    private TipoCliente tipo;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Endereco> endereco;

    @ElementCollection(fetch = FetchType.LAZY) //"carregamento preguiçoso", não carrega a lista imediatamente
    @CollectionTable(name = "cliente_telefones", // Define o nome da nova tabela que será criada.
            joinColumns = @JoinColumn(name = "cliente_id")) // Define a FK Key.
    @Column(name = "numero") // Nome da coluna na tabela 'cliente_telefones'
    private List<Telefone> telefone = new ArrayList<>();


    //Construtores
    public Cliente() {

    }

    public Cliente(String nome, String email, String cpfOuCnpj, TipoCliente tipo) {
        super();
        this.nome = nome;
        this.email = email;
        this.cpfOuCnpj = cpfOuCnpj;
        this.tipo = tipo;
    }

    //Getters e Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpfOuCnpj() {
        return cpfOuCnpj;
    }

    public void setCpfOuCnpj(String cpfOuCnpj) {
        this.cpfOuCnpj = cpfOuCnpj;
    }

    public TipoCliente getTipo() {
        return tipo;
    }

    public void setTipo(TipoCliente tipo) {
        this.tipo = tipo;
    }

    public List<Telefone> getTelefone() {
        return telefone;
    }

    public void setTelefone(List<Telefone> telefone) {
        this.telefone = telefone;
    }
}
