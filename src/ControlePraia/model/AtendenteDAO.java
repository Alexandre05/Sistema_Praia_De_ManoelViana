package ControlePraia.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * DAO para Entidade de Atendente.
 * @author joaocabraldev
 */
public class AtendenteDAO {
    
    private Connection conexao;
    private PreparedStatement pst;
    private ResultSet rs;
    
    /**
     * Construtor de AtendenteDAO.
     * @param conexao conexão a ser utilizada nas operações a banco de dados.
     */
    public AtendenteDAO(Connection conexao) {
        this.conexao = conexao;
    }
    
    /**
     * Consulta o Atendente por ID.
     * @param id ID a ser pesquisado.
     * @return Atendente com ID informado.
     * @throws SQLException Erro ao realizar consulta.
     */
    public Atendente consultarPorId(Integer id) throws SQLException {
        
        String sql = "SELECT * FROM tblatendente WHERE idate=?";
        Atendente atendente = new Atendente();
        
        pst = conexao.prepareStatement(sql);
        pst.setInt(1, id);
        rs = pst.executeQuery();
        
        if (rs.next()) {         
            atendente.setIdAte(rs.getInt(1));
            atendente.setNomeAte(rs.getString(2));
            atendente.setEndade(rs.getString(3));
            atendente.setEmail(rs.getString(4));
            atendente.setTelefone(rs.getNString(5));
            atendente.setCpf(rs.getString(6));
            atendente.setPerfil(EPerfilAtendente.valueOf(rs.getString(7)));
            atendente.setLogin(rs.getString(8));
            atendente.setSenha(rs.getString(9));
        }
        
        return atendente;
    }
    
    /**
     * Adiciona atendente no banco de dados.
     * @param atendente Atendente a ser adicionado.
     * @return Se atendente foi adicionado com sucesso.
     * @throws SQLException Erro ao adicionar Atendente.
     */
    public boolean adicionar(Atendente atendente) throws SQLException {
        
        String sql = "INSERT INTO tbatendente "
                + "(Nomeate,endate,Telefone,Cpf,email,senha,login,perfil)"
                + " VALUES (?,?,?,?,?,?,?,?)";
        
        pst = conexao.prepareStatement(sql);
        
        pst.setString(1, atendente.getNomeAte());
        pst.setString(2, atendente.getEndade());
        pst.setString(3, atendente.getTelefone());        
        pst.setString(4, atendente.getCpf());
        pst.setString(5, atendente.getEmail());
        pst.setString(6, atendente.getSenha());
        pst.setString(7, atendente.getLogin());
        pst.setString(8, atendente.getPerfil().getValor());
        
        return pst.executeUpdate() > 1;
        
    }
    
}
