package ControlePraia.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * DAO para Entidade de Acampamento.
 * @author joaocabraldev
 */
public class AcampamentoDAO {

    private final Connection conexao;
    private PreparedStatement pst;
    private ResultSet rs;

    /**
     * Construtor de AcampamentoDAO.
     * @param conexao Conexão com banco de dados.
     */
    public AcampamentoDAO(Connection conexao) {
        this.conexao = conexao;
    }
    
    /**
     * Pesquisa último id dos Acampamentos.
     * @return Último Id dos Acampamentos.
     * @throws SQLException Erro ao consultar dados.
     */
    public Integer pesquisarUltimoId() throws SQLException {
        String sql = "SELECT max(OrA) FROM tbacampar";
        Integer id = 0;
        
        pst = conexao.prepareStatement(sql);
        rs = pst.executeQuery();
        
        if (rs.next()) {
            id = rs.getInt(1);
        }
        
        return id;
    }
    
    /**
     * Pesquisa Acampamento por número.
     * @param numero Número a ser pesquisado.
     * @return Acampamento com número pesquisado.
     * @throws SQLException Erro ao consultar dados.
     */
    public Acampamento pesquisarPorNumero(Integer numero) throws SQLException {
        
        String sql = "SELECT * FROM tbacampar WHERE OrA=?";
        Acampamento acampamento = new Acampamento();
        
        pst = conexao.prepareStatement(sql);
        pst.setInt(1, numero);
        rs = pst.executeQuery();
        
        if (rs.next()) {
            acampamento.setOrA(rs.getInt(1));
            acampamento.setDataAcamp(rs.getDate(2));
            acampamento.setSituacao(rs.getString(3));
            acampamento.setAreaAcamp(rs.getString(4));
            acampamento.setValor(rs.getDouble(6));
            acampamento.setDiasAcamp(rs.getString(7));
            acampamento.setObsAcamp(rs.getString(8));
        }
        
        return acampamento;
        
    }
    
    /**
     * Adiciona o Acampamento no banco de dados.
     * @param acampamento Acampamento a ser adicionado.
     * @return Se Acampamento foi adicionado com sucesso. 
     * @throws SQLException Erro ao adicionar Acampamento.
     */
    public boolean adicionar(Acampamento acampamento) throws SQLException {
        
        String sql = "INSERT INTO tbacampar "
                + "(Situacao,AreaAcamp,Atendente,valor,DiasAcamp,ObsAcamp,Idcamp) "
                + "VALUES (?,?,?,?,?,?,?)";
        
        pst = conexao.prepareCall(sql);
        pst.setString(1, acampamento.getSituacao());
        pst.setString(2, acampamento.getAreaAcamp());
        // pst.setInt(3, acampamento.getAtendenteId());
        pst.setString(3, "Campo Atendente");
        pst.setDouble(4, acampamento.getValor());
        pst.setString(5, acampamento.getDiasAcamp());
        pst.setString(6, acampamento.getObsAcamp());
        
        return pst.executeUpdate() > 0;
    }
    
    /**
     * Altera o Acampamento especificado.
     * @param acampamento Acampamento a ser alterado.
     * @return Se acampamento foi alterado com sucesso.
     * @throws SQLException Erro ao alterar dados.
     */
    public boolean alterar(Acampamento acampamento) throws SQLException {
    
        String sql = "UPDATE tbacampar SET "
                + "Situacao=?,AreaAcamp=?,valor=?,DiasAcamp=?,ObsAcamp=? "
                + "WHERE OrA=?";
        
        pst = conexao.prepareCall(sql);
        pst.setString(1, acampamento.getSituacao());
        pst.setString(2, acampamento.getAreaAcamp());
        pst.setDouble(3, acampamento.getValor());
        pst.setString(4, acampamento.getDiasAcamp());

        pst.setString(5, acampamento.getObsAcamp());
        pst.setInt(6, acampamento.getOrA());
        
        return pst.executeUpdate() > 0;
        
    }
    
    /**
     * Exclui Acampamento pelo número.
     * @param numero Número do Acampamento a ser excluído.
     * @return Se Acampamento foi excluído com sucesso.
     * @throws SQLException Erro ao excluir dados.
     */
    public boolean excluir(Integer numero) throws SQLException {
    
        String sql = "DELETE FROM tbacampar WHERE OrA=?";
        
        pst = conexao.prepareStatement(sql);
        pst.setInt(1, numero);
        
        return pst.executeUpdate() > 0;
    
    }
    
}
