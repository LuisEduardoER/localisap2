package persistencia;

import agencias.Filial;
import funcionarios.Gerente;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Persistencia {

        private static FileInputStream arquivoInfosRead;
        private static ObjectInputStream objInfosRead;
        private static FileOutputStream arquivoInfosWrite;
        private static ObjectOutputStream objInfosWrite;

    public ArrayList<Filial> carregarFiliais(){
        ArrayList<Filial> lista;
	try {
            arquivoInfosRead = new FileInputStream("./infosAgencia.dat");
        } catch (FileNotFoundException ex) {
            return new ArrayList<Filial>();
        }
        try {
            objInfosRead = new ObjectInputStream(arquivoInfosRead);
            try {
                lista = (ArrayList<Filial>) objInfosRead.readObject();
                objInfosRead.close();
                arquivoInfosRead.close();
                return lista;
            } catch (Exception ex) {
                System.out.println("Nao foi possivel carregar as agencias gravadas!");
                return new ArrayList<Filial>();
            }
        } catch (IOException ex) {
        }
        return new ArrayList<Filial>();
    }

    public void atualizarFiliais(ArrayList<Filial> listaDeFiliais){
        try {
            arquivoInfosWrite = new FileOutputStream("./infosAgencia.dat");
            objInfosWrite = new ObjectOutputStream(arquivoInfosWrite);
            objInfosWrite.writeObject(listaDeFiliais);
            objInfosWrite.flush();
            objInfosWrite.close();
            arquivoInfosWrite.close();
        } catch (Exception ex) {
            System.out.println("Nao foi possivel atualizar os dados de agencias.");
        }

    }

    public ArrayList<Gerente> carregarGerentes(){
        ArrayList<Gerente> lista;
	try {
            arquivoInfosRead = new FileInputStream("./infosGerente.dat");
        } catch (FileNotFoundException ex) {
            return new ArrayList<Gerente>();
        }
        try {
            objInfosRead = new ObjectInputStream(arquivoInfosRead);
            try {
                lista = (ArrayList<Gerente>) objInfosRead.readObject();
                objInfosRead.close();
                arquivoInfosRead.close();
                return lista;
            } catch (Exception ex) {
                System.out.println("Nao foi possivel carregar os gerentes gravados!");
                return new ArrayList<Gerente>();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return new ArrayList<Gerente>();
    }

    public void atualizarGerentes(ArrayList<Gerente> listaDeGerentes){
        try {
            arquivoInfosWrite = new FileOutputStream("./infosGerente.dat");
            objInfosWrite = new ObjectOutputStream(arquivoInfosWrite);
            objInfosWrite.writeObject(listaDeGerentes);
            objInfosWrite.flush();
            objInfosWrite.close();
            arquivoInfosWrite.close();
        } catch (Exception ex) {
            System.out.println("Nao foi possivel atualizar os dados de gerentes.");
        }

    }
}
