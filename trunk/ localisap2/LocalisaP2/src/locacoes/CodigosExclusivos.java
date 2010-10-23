/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package locacoes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.math.BigInteger;
import java.security.SecureRandom;
import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;

/**
 *
 * @author Filipe
 */
public class CodigosExclusivos {
    /**
     * Metodo responsavel por gerar uma string aleatoria do tamanho desejado.
     * @param tamanho - Recebe o tamanho desejado da String.
     * @return - Uma string aleatoria do tamanho desejado.
     */
    public String geraCodigoInternoDeArmazenamento(int tamanho){
        SecureRandom numeroAleatorio = new SecureRandom();
        return new BigInteger(30, numeroAleatorio).toString(tamanho);

}

    /**
     * Metodo responsável por gerar codigo de barras no padrao Code39
     * @param codigoUnico - Valor que sera transformado em codigo de barras
     */
    public void GeraCodigoBarras(String codigoUnico){
        try{
            Barcode codigoDeBarras = BarcodeFactory.create3of9(codigoUnico, false);
            BufferedImage imagemDoCodigo = new BufferedImage(220, 130, BufferedImage.TYPE_BYTE_GRAY);
            Graphics2D grafico = (Graphics2D) imagemDoCodigo.getGraphics();
            grafico.setBackground(Color.BLUE);
            codigoDeBarras.draw(grafico, 10, 56);
            File f = new File(codigoUnico + ".jpg");
            BarcodeImageHandler.saveJPEG(codigoDeBarras, f);
        }catch(Exception ex){
            ex.getMessage();
        }
    }
}
