/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uepb.personalcollections.util;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;

/**
 * Operações úteis para manipulação de data
 *
 * @author Douglas Rafael
 */
public class MyData {

    /**
     * Recupera a data atual do sistema. Formato da data 99/99/9999
     *
     * @return String Data atual no formato brasileiro
     */
    public static String getDataAtual() {
        Calendar calendar = new GregorianCalendar();
        return calendar.get(Calendar.DAY_OF_MONTH) + "/" + calendar.get(calendar.MONTH) + "/" + calendar.get(calendar.YEAR);
    }

    /**
     * Converte uma string em um Calendar. Formato da data passado como
     * parametro: "dd/MM/yyyy"
     *
     * @return O objeto Calendar ou null
     * @throws ParseException
     */
    public static Calendar stringToCalendar(String str_data) throws ParseException {
        if (str_data == null || "".equals(str_data)) {
            return null;
        }
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();

        c.setTime(formatoData.parse(str_data));

        return c;
    }

    /**
     * Converte Calendar em string. Data retornada: "dd/MM/yyyy"
     *
     * @param c Calendar
     * @return STring
     */
    public static String calendarToString(Calendar c) {
        if (c == null) {
            return null;
        }
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        Calendar hoje = new GregorianCalendar();

        return formatoData.format(hoje.getTime());
    }

    /**
     * Retorna em dias a diferença entre duas datas.
     * 
     * @param dataInicial
     * @param dataFinal
     * @return int Dias da diferença das duas datas dataFinal - DataInicial
     */
    public static int diferencaDias(Calendar dataInicial, Calendar dataFinal) {
        long dias = 0;
        if (dataInicial != null && dataFinal != null) {
            dias = dataFinal.getTimeInMillis() - dataInicial.getTimeInMillis();
            dias = dias / 86400000; // Quantidade de milissegundos em um dia 1000 * 60 * 60 * 24;
        }
        return (int) dias;
    }
}
