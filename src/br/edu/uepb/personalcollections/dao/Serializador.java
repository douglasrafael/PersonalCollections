package br.edu.uepb.personalcollections.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Classe para Serialização e Deserialização de objetos
 *
 * @author Douglas Rafael
 */
public class Serializador {

    private File file;

    /**
     * Recupera o arquivo
     * 
     * @return O arquivo
     */
    public File getFile() {
        return file;
    }

    /**
     * Seta o arquivo.
     * 
     * @param file O arquivo
     */
    public void setFile(String file) {
        this.file = new File(file);
    }

    /**
     * Construtor
     */
    public Serializador() {
    }

    /**
     * Serializa objeto e grava em disco. Irá gravar no path passado como
     * parametro no construtor
     *
     * @param path o caminho onde se encontra o arquivo
     * @param o Objeto a ser gravado
     * @throws FileNotFoundException se houver uma exceção por não encontrar o arquivo
     * @throws IOException se houver uma exceção
     */
    public void serializar(String path, Object o) throws FileNotFoundException, IOException {
        setFile(path);
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(path)));
            out.writeObject(o);
        } finally {
            out.close();
        }
    }

    /**
     * Deserializa objeto de acordo com o path.
     *
     * @param path o caminho onde se encontra o arquivo
     * @return Objeto da deserialização
     * @throws FileNotFoundException se houver uma exceção por não encontrar o arquivo
     * @throws IOException se houver uma exceção
     * @throws ClassNotFoundException se houver uma exceção
     */
    public Object deserializar(String path) throws FileNotFoundException, IOException, ClassNotFoundException {
        setFile(path);
        ObjectInputStream input = null;
        BufferedInputStream bis = null;
        Object o = null ;

        if (getFile().exists()) {
            bis = new BufferedInputStream(new FileInputStream(getFile()));
            if (bis.available() > 0) {
                input = new ObjectInputStream(bis);
                o = input.readObject();

                bis.close();
                input.close();
            }
        }
        return o;
    }
}