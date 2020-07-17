package ControlePraia.model;

/**
 * Enum para Perfil de Atendente.
 * @author joaocabraldev
 */
public enum EPerfilAtendente {
    
    ADMIN("admin"), 
    USUARIO("usuario");
    
    private final String valor;

    private EPerfilAtendente(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
    
}
