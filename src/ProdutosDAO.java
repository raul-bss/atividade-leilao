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
    
    public void cadastrarProduto (ProdutosDTO produto){
        
        
        conn = new conectaDAO().connectDB();
        
        
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
//            StringBuilder sb = new StringBuilder();
//            String comandoSQL;
//            ProdutosDTO produto;
//            conn = new conectaDAO().connectDB();
//            
//            sb.append("SELECT * FROM ");
//            sb.append("produtos");
//
//            comandoSQL = sb.toString();
//
//            try{          
//                listagem = new ArrayList<>();
//                prep = conn.prepareStatement(comandoSQL);
//                resultset = prep.executeQuery();
//
//                while(resultset.next()){
//                    produto = new ProdutosDTO();   
//
//                    produto.setId(resultset.getInt("id"));
//                    produto.setNome(resultset.getString("nome"));
//
//                    produto.setStatus(resultset.getString("status"));
//                    
//
//                    produto.setValor(resultset.getInt("valor"));
//
//                    listagem.add(produto);
//                }
//            }catch(SQLException e){
//                System.out.println(e.getMessage());
//            }
//            return listagem;
    }
    
    
    
        
}

