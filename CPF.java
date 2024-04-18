package Lab2;

public class CPF {
	 public String num;

	// Método que remove caracteres especiais
	 public void cadastrar(String num) {
	        if (num == null) {
	            this.num = "";
	            return;
	        }
	        
	        char[] novoNum = new char[num.length()];
	        int cnt = 0;
	        for (int i = 0; i < num.length(); i++) {
	            char c = num.charAt(i);
	            if (c >= '0' && c <= '9') 
	                novoNum[cnt++] = c;
	        }
	        this.num = new String(novoNum, 0, cnt);
	   }

	 // Método que verifica se o CPF é válido ou inválido
	   public boolean validar() {
		   if (num == null || num.length() != 11) 
	           return false;
	    	
		   // Verifica se todos os números são iguais
	       char dig1 = num.charAt(0);
	       for (int i = 1; i < 11; i++) {
	           if (num.charAt(i) != dig1) 
	               break;
	            
	           if (i == 10) 
	               return false;      
	       }
	        
	       int soma = 0;
	       for (int i = 0; i < 9; i++) {
	           soma += (10 - i) * (num.charAt(i) - '0');
	       }
	       int resto1 = (soma * 10) % 11;
	       if (resto1 != num.charAt(9) - '0') 
	           return false;

	       soma = 0;
	       for (int i = 0; i < 10; i++) 
	           soma += (11 - i) * (num.charAt(i) - '0');
	        
	       int resto2 = (soma * 10) % 11;
	       if (resto2 != num.charAt(10) - '0') 
	           return false;

	       return true;
	    }

	    // Método que formata o número no padrão XXX.XXX.XXX-XX
	    public String formatar() {
    		String formCPF = "";
    		for (int i = 0; i < 3; i++) 
        		formCPF += num.charAt(i);
    		formCPF += ".";

    		for (int i = 3; i < 6; i++) 
    			formCPF += num.charAt(i);
    		formCPF += ".";

    		for (int i = 6; i < 9; i++) 
    			formCPF+= num.charAt(i);
    		formCPF+= "-";

    		for (int i = 9; i < 11; i++) 
    			formCPF += num.charAt(i);
    
    	return formCPF;

	    }
}