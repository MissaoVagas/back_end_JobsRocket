package com.back_end.JobsRocket.utils;


public class Validator {
	
	public static boolean validadorDeSenha(String senha){
        return senha.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*\\W).{8,}$");
    }

}
