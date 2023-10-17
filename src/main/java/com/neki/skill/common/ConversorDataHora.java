package com.neki.skill.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConversorDataHora {
    
    public static String converterDateParaDataHora (Date data) {
		
		
		SimpleDateFormat formatador = new SimpleDateFormat ("dd/MM/YYYY HH:mm:ss");
		
		return formatador.format(data);	
		
	}
}

