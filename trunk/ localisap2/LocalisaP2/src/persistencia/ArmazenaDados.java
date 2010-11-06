/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package persistencia;

import agencias.Filial;
import clientes.PessoaFisica;
import clientes.PessoaJuridica;
import funcionarios.Gerente;
import funcionarios.Locador;
import funcionarios.Usuario;
import java.util.ArrayList;
import java.util.Collection;
import planos.PlanoAutomovel;
import planos.PlanoMoto;
import veiculos.Veiculo;

/**
 *
 * @author filipe
 */
public class ArmazenaDados {
    private Collection<Veiculo> listaDeVeiculos = new ArrayList<Veiculo>();
    private Collection<PlanoAutomovel> listaDePlanosCarros = new ArrayList<PlanoAutomovel>();
    private Collection<PlanoMoto> listaDePlanosMoto = new ArrayList<PlanoMoto>();
    private Collection<Locador> listaDeLocadores = new ArrayList<Locador>();
    private Collection<Gerente> listaDeGerentes = new ArrayList<Gerente>();
    private Collection<PessoaFisica> listaDeClientesPessoaFisica = new ArrayList<PessoaFisica>();
    private Collection<PessoaJuridica> listaDeClientesPessoaJuridica = new ArrayList<PessoaJuridica>();
    private Usuario user;
    private Filial agencia;
    public void adicionaAgencia(Filial agencia){
        this.agencia = agencia;
    }
    public void adicionaUsuario(Usuario user){
        this.user = user;
    }
    public Usuario getUsuario(){
        return user;
    }
    public void adicionaVeiculos(Veiculo v){
        listaDeVeiculos.add(v);
    }

    public void adicionaPlanoAutomovel(PlanoAutomovel p){
        listaDePlanosCarros.add(p);
    }

    public void adicionaPlanoMoto(PlanoMoto p){
        listaDePlanosMoto.add(p);
    }

    public void adicionaLocador(Locador l){
        listaDeLocadores.add(l);
    }
    public void adicionaGerente(Gerente g){
        listaDeGerentes.add(g);
    }
    public void adicionaPessoaFisica(PessoaFisica pf ){
        listaDeClientesPessoaFisica.add(pf);
    }
    public void adicionaPessoaJuridica(PessoaJuridica pj){
        listaDeClientesPessoaJuridica.add(pj);
    }
    public Collection<Veiculo> getVeiculos(){
        return listaDeVeiculos;
    }

    public Collection<PlanoAutomovel> getPlanoAutomovel(){
        return listaDePlanosCarros;
    }

    public Collection<PlanoMoto> getPlanoMoto(){
        return listaDePlanosMoto;
    }

    public Collection<Locador> getLocador(){
        return listaDeLocadores;
    }
    public Collection<Gerente> getGerente(){
        return listaDeGerentes;
    }
    public Collection<PessoaFisica> getPessoaFisica(){
        return listaDeClientesPessoaFisica;
    }
    public Collection<PessoaJuridica> getPessoaJuridica(){
        return listaDeClientesPessoaJuridica;
    }
    public void removeVeiculos(Veiculo v){
        listaDeVeiculos.remove(v);
    }

    public void removePlanoAutomovel(PlanoAutomovel p){
        listaDePlanosCarros.remove(p);
    }

    public void removePlanoMoto(PlanoMoto p){
        listaDePlanosMoto.remove(p);
    }

    public void removeLocador(Locador l){
        listaDeLocadores.remove(l);
    }
    public void removeGerente(Gerente g){
        listaDeGerentes.remove(g);
    }
    public void removePessoaFisica(PessoaFisica pf ){
        listaDeClientesPessoaFisica.remove(pf);
    }
    public void removePessoaJuridica(PessoaJuridica pj){
        listaDeClientesPessoaJuridica.remove(pj);
    }
 }


