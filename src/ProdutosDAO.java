/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem;
    
    public Boolean cadastrarProduto (ProdutosDTO produto){    
        conn = new conectaDAO().connectDB();
        
        StringBuilder sb = new StringBuilder();
        String comandoSQL;
        Boolean retorno = false;
        int linhasAfetadas;
                   
        sb.append("INSERT INTO produtos ");
        sb.append("(nome, valor, status) ");
        sb.append("VALUES ");
        sb.append("(?,?,?)");
        
        comandoSQL = sb.toString();
        
        try{
            
            prep = conn.prepareStatement(comandoSQL);
            prep.setString(1, produto.getNome());
            prep.setInt(2, produto.getValor());
            prep.setString(3, produto.getStatus());
            
            linhasAfetadas = prep.executeUpdate();
            if(linhasAfetadas > 0){
                retorno = true;
            }
            
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return retorno;
        
        
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
            StringBuilder sb = new StringBuilder();
            String comandoSQL;
            ProdutosDTO produto;
            conn = new conectaDAO().connectDB();
            
            sb.append("SELECT * FROM ");
            sb.append("produtos");

            comandoSQL = sb.toString();

            try{          
                listagem = new ArrayList<>();
                prep = conn.prepareStatement(comandoSQL);
                resultset = prep.executeQuery();

                while(resultset.next()){
                    produto = new ProdutosDTO();   

                    produto.setId(resultset.getInt("id"));
                    produto.setNome(resultset.getString("nome"));

                    produto.setStatus(resultset.getString("status"));
                    

                    produto.setValor(resultset.getInt("valor"));

                    listagem.add(produto);
                }
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
            return listagem;
    }
    
    
    
        
}

