package br.edu.uepb.personalcollections.util;

import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Classe para validação de form.
 *
 * @author Douglas Rafael
 */
public class Validacao {

    /**
     * Percorre todos os compos de um JPanel do tipo JTextFild e verifica se
     * estão vazio. Retorna true se nenhum estiver vazio e false se pelo menos
     * um estiver.
     *
     * @param panel JPanel onde os components estão vinculados
     * @param comp Lista de components a serem validados
     * @return Retorna true se nenhum estiver vazio e false se pelo menos um
     * estiver.
     */
    public static boolean validarCamposVazios(JPanel panel, List<Component> comp) {
        Component[] components = panel.getComponents();

        for (Component component : components) {
            if (comp.contains(component)) {
                if (component instanceof JTextField) {
                    if (((JTextField) component).getText().trim().equals("")) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static Calendar validarDate(String dataString) {
        Calendar data = Calendar.getInstance();
        try {
            SimpleDateFormat dataFormat = new SimpleDateFormat("dd/MM/yyyy");
            dataFormat.setLenient(false);

            dataFormat.parse(dataString);
        } catch (ParseException e) {
            return null;
        }
        return data;
    }
}
